package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 8080;
	
	public static void main(String[] args) {
		List<PrintWriter> listWriters = new ArrayList<PrintWriter>();
		ServerSocket serverSockert = null;
		List<String> chatPeopleList = new ArrayList<String>();
		
		try {
			// 서버 소켓 생성 & 바인딩
			serverSockert = new ServerSocket();
			serverSockert.bind(new InetSocketAddress("0.0.0.0", PORT), 10);
			
			log("starts....[port:" + PORT + "]");
			
			// 요청 대기
			while(true) {
				Socket socket = serverSockert.accept();				// blocking (대기중)
				new ChatServerThread(socket, listWriters, chatPeopleList).start();	// 새로운 요청을 처리하는 thread 생성 -> 실행
			}
			
		} catch (SocketException e) {
			
			log("Socket Exception : " + e);
			
		} catch (IOException e) {
			
			log("error : " + e);
			
		} finally {
			
			try {
				if(serverSockert != null && !serverSockert.isClosed()) {
					serverSockert.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void log(String message) {
		System.out.println("[ChatServer] " + message);
	}
	
}
