package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = new Socket();
		
		try {
			socket.connect(new InetSocketAddress("0.0.0.0", ChatServer.PORT));
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
	
			while( true ) {
				
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();
				
				if (!name.isEmpty()) {
					break;
				}
				
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
			
			scanner.close();
			
			// JOIN 프로토콜
			pw.println("JOIN:" + name);
			
			String ack = br.readLine();
			if("JOIN:OK".equals(ack)) {
				new ChatWindow(name, socket).show();
			}
			
			
		} catch (SocketException e) {
			ChatServer.log("" + e);
		} catch (IOException e) {
			ChatServer.log("" + e);
		}
	}

}
