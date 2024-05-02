package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT = 3000;

	public static void main(String[] args) {
		ServerSocket serverSockert = null;
		
		try {
			
			serverSockert = new ServerSocket();
			
			serverSockert.bind(new InetSocketAddress("0.0.0.0", PORT), 10);
			
			log("starts....[port:" + PORT + "]");
			
			// 무한 루프 돌리기
			while(true) {
				Socket socket = serverSockert.accept();		// blocking (대기중)
				new EchoRequestHandler(socket).start();;	// 새로운 요청을 처리하는 thread 생성 -> 실행
			}
			
		} catch (IOException e) {
			
			log("error : " + e);
			
		} finally {
			
			try {
				if(serverSockert != null && !serverSockert.isClosed()) {	// 서버 소켓은 이렇게 확인 (소켓도 닫고, 소켓 안에 있는 스트림도 닫고)
					serverSockert.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}
	
}
