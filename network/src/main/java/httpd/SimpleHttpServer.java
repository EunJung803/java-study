package httpd;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
	private static final int PORT = 8088;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();
			
			serverSocket.bind( new InetSocketAddress( "0.0.0.0", PORT ) );
			consolLog("starts... [" + PORT + "]");

			while (true) {
				Socket socket = serverSocket.accept();

				new RequestHandler(socket).start();
			}

		} catch (IOException ex) {
			consolLog("error:" + ex);
		} finally {
			// 5. 자원정리
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException ex) {
				consolLog("error:" + ex);
			}
		}
	}

	public static void consolLog(String message) {
		// 스레드 마다 있는 id를 출력하도록 해놓음
		System.out.println("[HttpServer#" + Thread.currentThread().getId()  + "] " + message);
	}
}
