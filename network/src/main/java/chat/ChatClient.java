package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;

// 메인스레드
public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			
			//1. 키보드 연결
			scanner = new Scanner(System.in);

			//2. socket 생성
			socket = new Socket();

			//3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			//4. reader/writer 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			//5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("JOIN:" + nickname);
			
			String ack = br.readLine();
			if("JOIN:OK".equals(ack)) {
				System.out.println("입장하였습니다. 즐거운 채팅 되세요");
			}

			//6. ChatClientReceiveThread 시작
			new ChatClientThread(socket).start();

			//7. 키보드 입력 처리
			while(true) {
//		      System.out.print( ">>" );
		      String input = scanner.nextLine();
		      if(!input.isEmpty()) {
			      if("quit".equals(input) == true) {
			          // 8. quit 프로토콜 처리
			    	  pw.println("QUIT");
			          break;
			      } else {
			          // 9. 메시지 처리    
			    	  String encodeMessage = Base64.getEncoder().encodeToString(input.getBytes());		// 메세지 Base64 Encoding
			    	  pw.println("MESSAGE:" + encodeMessage);
			      }
		      }
		      else {
		    	  System.out.print("대화명은 한글자 이상 입력해야 합니다.\n");
		      }
		      
		   }

		} catch(IOException ex) {
			log( "error:" + ex );
		} finally {
			//10. 자원정리
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 

	}
	
	public static void log(String message) {
		System.out.println("[ChatClient] " + message);
	}
	
	
}
