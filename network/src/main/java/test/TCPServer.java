package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
			
			try {
			
				// 반대편(클라이언트 쪽)에 있는 애의 socket 주소 받아오기
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();	// 캐스팅
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by clinet[" + remoteHostAddress + ":" + remotePort + "]");
			
				// 4. 소켓 안에 있는 IO Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				// 5. 데이터 읽기
				while(true) {
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer);	// blocking
					
					if(readByteCount == -1) {		// 정상적인 종료 (클라이언트에서 종료)
						System.out.println("[server] closed by client");	// 클라이언트가 정상적으로 종료 (close() 호출)
						break;
					}
					
					// String으로 엔코딩
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					
					System.out.println("[server] received:");
					
					// 6. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
					
					
				}
				
				
			} catch (SocketException e) {
				
				System.out.println("[server] suddenly closed by client");
				
			} catch (IOException e) {
				
				System.out.println("[server] error : " + e);
				
			} finally {
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				
			
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
