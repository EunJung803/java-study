package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
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
				
				if(name.isEmpty()) {
					System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
				}
				
				else {
					// JOIN 프로토콜
					pw.println("JOIN:" + name);
					
					String ack = br.readLine();

					// JOIN 가능
					if("JOIN:OK".equals(ack)) {
						new ChatWindow(name, socket).show();	// 윈도우 열기
						break;
					}
					// 닉네임 중복인 경우
					if("SAMENAME".equals(ack)) {
						System.out.println("중복된 닉네임 입니다. 다시 입력해주세요.");
					}
				}
				
			}
			
			scanner.close();
			
		} catch (SocketException e) {
			log("" + e);
		} catch (IOException e) {
			log("" + e);
		}
	}
	public static void log(String message) {
		System.out.println("[ChatClientApp] " + message);
	}

}
