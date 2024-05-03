package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;

import chat.ChatServer;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	private Socket socket;
	private PrintWriter pw;

	public ChatWindow(String name, Socket socket) {
		this.socket = socket;
		
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		// KeyAdapter를 상속받은 클래스를 따로 만들지 않고 여기서 바로 구현 (클래스이름 없이)
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {		// Virtual Key
					sendMessage();
				}
			}	
			
		});		

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		// 나가는건 창을 끌 때 진행 
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		
		// IOStream 받아오기
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			// ChatClientThread 생성
			new ChatClientThread(socket).start();
			
		} catch (SocketException e) {
			ChatServer.log("" + e);
		} catch (IOException e) {
			ChatServer.log("" + e);
		}
		
	}
	
	private void sendMessage() {
		String message = textField.getText();
		// 메세지 처리
		String encodeMessage = Base64.getEncoder().encodeToString(message.getBytes());		// 메세지 Base64 Encoding
		pw.println("MESSAGE:" + encodeMessage);
		
		textField.setText("");
		textField.requestFocus();
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");		// 커서를 밑으로
	}
	
	private void finish() {
		// quit 프로토콜 구현
		try {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.println("QUIT");
		
		// exit java application
		System.exit(0);
	}
	
	
	private class ChatClientThread extends Thread {
		Socket socket;
		BufferedReader br;
		
		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				
				while(true) {
					String message = br.readLine();
					
					if(message == null) {
						break;
					}
					updateTextArea(message);
				}
				
			} catch (SocketException e) {
				ChatClientApp.log("" + e);
			} catch (IOException e) {
				ChatClientApp.log("" + e);
			} finally {
				finish();
			}
			
		}
	}
	
	
	
}
