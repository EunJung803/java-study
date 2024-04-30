package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PhoneList01 {
	
	public static void main(String[] args) {
		
		
		try {
			
			File file = new File("./phone.txt");
			
			if(!file.exists()) {		// exception을 많이 만드는게 좋은게 아님 (메모리를 잡아먹어서) -> 그래서 이렇게 빼주기
				System.out.println("file not found");
				return;
			}
			
			FileInputStream fis = new FileInputStream(file);
			fis.read();
			
		} catch (IOException e) {		// IOException의 자식이 FileNotFoundException 이므로 이거 하나만 잡아주기
			
			
			
		}
	}

}
