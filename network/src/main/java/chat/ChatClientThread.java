package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;

public class ChatClientThread extends Thread {
	private Socket socket;
	
	public ChatClientThread(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			while(true) {
				String message = br.readLine();
				
				if(message == null) {
					break;
				}
				System.out.println(message);
			}
			
		} catch(SocketException e) { 
			// ChatClient.log("" + e);
		} catch (IOException e) {
			// ChatClient.log("" + e);
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
}
