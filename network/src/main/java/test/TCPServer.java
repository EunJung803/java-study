package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSockert = null;
		
		try {
			
			// 1. Server Socket 생성
			serverSockert = new ServerSocket();
			
			// 2. 소켓에 주소를 바인딩(Binding)
			//	  Socket에 InetSocketAddress[InetAddress(IPAddress) + Port]를 바인딩 한다.
			// 	  IPAddress : 0.0.0.0 -> 특정 호스트 IP를 바인딩하지 않는다 (== IP를 지정하지 않고 다 받도록 설정)
			// 	  여기서 10은 백로그 큐 개수
			serverSockert.bind(new InetSocketAddress("0.0.0.0", 3000), 10);
			
			// 3. Accept
			Socket socket = serverSockert.accept();		// 코드가 더 진행안됨 (blocking) -> 클라이언트의 요청을 기다림
			
			System.out.println("연결됨");
			
		} catch (IOException e) {
			
			System.out.println("[server] error : " + e);
			
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
	
}
