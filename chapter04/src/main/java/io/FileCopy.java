package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			
			is = new FileInputStream("photo.jpeg");
			os = new FileOutputStream("photo_copy.jpeg");		// 파일 copy를 output할 내용
			
			int data = -1;
			while((data = is.read()) != -1) {		// 바이트씩 읽어야해서 계속 읽어야함
				os.write(data);
			}
			
		
		} catch (FileNotFoundException e) {
			
			System.out.println("file not found:" + e);
		
		} catch (IOException e) {
			
			System.out.println("error:" + e);
		
		} finally {
			
			try {
				if(is != null) {
					is.close();
				}
				if(os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
