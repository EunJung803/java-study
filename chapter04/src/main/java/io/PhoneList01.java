package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {
	
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			
			File file = new File("./phone.txt");
			
			if(!file.exists()) {		// exception을 많이 만드는게 좋은게 아님 (메모리를 잡아먹어서) -> 그래서 이렇게 빼주기
				System.out.println("file not found");
				return;
			}
			
			System.out.println("=== 파일정보 ===");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + " Bytes");
//			System.out.println(file.lastModified());
			
			Date d = new Date(file.lastModified());
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(d));
			
			
			System.out.println("=== 전화번호 ===");
			
			// 1. 기반스트림
			FileInputStream fis = new FileInputStream(file);
			
			// 2. 보조스트림 02 (byte|byte|byte -> char)	
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");		// 이렇게 엔코딩하라고 알려줘야함
			
			// 3. 보조스트림 03 (char|char|char|\n -> "charcharchar")	
			br = new BufferedReader(isr);
			
			// 4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
//				System.out.println(line);
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				int index = 0;
				
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					
					
					if(index == 0) {			// 이름
						System.out.print(token + " : ");
					} else if (index == 1) {	// 전화번호 1
						System.out.print(token + "-");
					} else if (index == 2) {	// 전화번호 2
						System.out.print(token + "-");
					} else {					// 전화번호 3
						System.out.print(token + "\n");
					}
					
					index++;
					
				}
			}
			
		} catch (UnsupportedEncodingException e) {
			
			System.out.println("error:" + e);
			
		} catch (IOException e) {
			
			System.out.println("error:" + e);
			
		} finally {
			
			try {
				if(br != null) {
					br.close();	
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
