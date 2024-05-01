package util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
	
	public static void main(String[] args) {
		Scanner scanner = null;
		
		try {
			
			while(true) {
				scanner = new Scanner(System.in);
				String input = scanner.nextLine();
				
				if(input.equals("exit")) {
					break;
				}
				
				InetAddress[] inetAddresses = InetAddress.getAllByName(input);
				
				for(InetAddress i : inetAddresses) {
					System.out.println(i);
				}
			}
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		
		} 
		
	}

}
