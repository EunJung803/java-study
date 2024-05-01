package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 3000;

	public static void main(String[] args) {
		ServerSocket serverSockert = null;
		
		try {
			
			serverSockert = new ServerSocket();
			
			serverSockert.bind(new InetSocketAddress("0.0.0.0", PORT), 10);
			
			Socket socket = serverSockert.accept();
			
			try {
			
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();	// 캐스팅
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				log("connected by clinet[" + remoteHostAddress + ":" + remotePort + "]");
				
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);	// true == 버퍼가 차면 오토 flush됨
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				
				
				while(true) {
					String data = br.readLine();		// blocking
					
					if(data == null) {
						log("closed by client");
						break;
					}
					
					log("received:" + data);
					
					pw.println(data);		// OutputStreamWriter가 getBytes해서 해줌
					
				}
				
				
			} catch (SocketException e) {
				
				log("suddenly closed by client");
				
			} catch (IOException e) {
				
				log("error : " + e);
				
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
	
	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}
	
}
