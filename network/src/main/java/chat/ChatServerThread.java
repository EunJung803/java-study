package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	private List<PrintWriter> listWriters;
	private List<String> chatPeopleList;
	
	public ChatServerThread(Socket socket, List<PrintWriter> listWriters, List<String> chatPeopleList) {
		this.socket = socket;
		this.listWriters = listWriters;
		this.chatPeopleList = chatPeopleList;
	}

	@Override
	public void run() {
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
			// 1. Remote Host Information
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			ChatServer.log("connected by clinet[" + remoteHostAddress + ":" + remotePort + "]");
			
			// 2. 스트림 얻기
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// 3. 요청 처리
			while(true) {
				String request = br.readLine();
				
				if(request == null) {
					ChatServer.log("closed by client");
					doQuit(pw);
					break;
				}
				
				// 4. 프로토콜 분석
				String[] tokens = request.split(":");
				
				if("JOIN".equals(tokens[0])) {
					if(chatPeopleList.contains(tokens[1])) {
						pw.println("SAMENAME");
					}
					else {
						synchronized(chatPeopleList) {
							chatPeopleList.add(tokens[1]);
						}
						doJoin(tokens[1], pw);
					}
					
				} else if("MESSAGE".equals(tokens[0])) {
					doMessage(tokens[1]);
					
				} else if("QUIT".equals(tokens[0])) {
					doQuit(pw);
					break;
					
				} else {
				   ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}

			}
			
			
		} catch (SocketException e) {
			
			ChatServer.log("Socket Exception : " + e);
			doQuit(pw);
			
		} catch (IOException e) {
			
			ChatServer.log("error : " + e);
			doQuit(pw);
			
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void doJoin(String nickName, PrintWriter pw) {
	   this.nickname = nickName;
	   
	   String data = nickName + "님이 참여하였습니다.";
	   broadcast(data);
	   
	   // writer pool에 저장
	   addWriter(pw);
	   
	   // ack
	   pw.println("JOIN:OK");
	   
	}
	
	private void doQuit(PrintWriter pw) {
		removeWriter(pw);
		
		synchronized(chatPeopleList) {
			chatPeopleList.remove(this.nickname);
		}

		if(nickname!=null) {
			String data = this.nickname + "님이 퇴장하였습니다.";
			broadcast(data);
		}
	}
	
	private void addWriter(PrintWriter pw) {
		synchronized(listWriters) {
			listWriters.add(pw);
		}
	}

	private void removeWriter(PrintWriter pw) {
		synchronized(listWriters) {
			listWriters.remove(pw);
		}
	}

	private void doMessage(String message) {
		// 메세지 Base64 Decoding
		byte[] decodedBytes = Base64.getDecoder().decode(message);
        String decodedStr = new String(decodedBytes);
        
		broadcast(this.nickname + " : " + decodedStr);
	}
	
	private void broadcast(String data) {
	   synchronized(listWriters) {
		   for(PrintWriter writer : listWriters) {
			   writer.println(data);
			   writer.flush();
		   }
	   }
	}
	
}
