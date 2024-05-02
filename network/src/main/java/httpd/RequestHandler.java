package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private Socket socket;
	private final String DOCUMENT_ROOT = "./webapp";
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );

			String request = null;		// 첫줄만 가져오기 위해 설정
			while(true) {
				String line = br.readLine();
				
				// 브라우저에서 연결을 끊으면
				if(line == null) {
					break;
				}
				
				// SimpleHttpServer는 HTTP Header만 처리
				if("".equals(null)) {
					break;
				}
				
				// request Header의 첫줄만 처리
				if(request == null) {
					request = line;		// request에 line이 셋팅되고 -> 끊김
					break;
				}
			}
			// 요청 처리
			consoleLog(request);
			
			String[] tokens = request.split(" ");
			if("GET".equals(tokens[0])) {
				responseStaticResource(outputStream, tokens[1], tokens[2]);		// 자원을 읽어서 outputStream에 들어감
			} else {
				/* methods : POST, PUT, DELETE, HEAD, CONNECT
				 * SimpleHttpServer에서는 무시 (400 Bad Request 처리) */
				// response404BadRequest(outputStream, tokens[2]);
			}
		
		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {
		// default(welcome) file set
		if("/".equals(url)) { 
			url = "/index.html";
		} // 그 뒤로는 파일이 지정되어서 들어옴 
		
		File file = new File(DOCUMENT_ROOT + url);
		
		if(!file.exists()) {		// 파일 없으면 -> 404 처리
			// response404Error(outputStream, protocol);
			return;
		}
		
		// nio
		byte[] body = Files.readAllBytes(file.toPath());				// 예외 생기면 run()메서드에서 예외처리 하니까 던져버리기
		String contentType = Files.probeContentType(file.toPath());		// 파일 타입을 읽어들이기
		
		outputStream.write((protocol + "200 OK\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
		
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
