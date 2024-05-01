package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {
	
	public static void main(String[] args) {
		
		try {
			
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName();					// 컴퓨터의 이름 (도메인과 상관없음)
			String hostIpAddress = inetAddress.getHostAddress();			// 내 ip 주소 갖기
			
			System.out.println(hostName);
			System.out.println(hostIpAddress);
			
			byte[] IpAddresses = inetAddress.getAddress();					// ip 주소 바이트로 가져오기 (원본)
			for(byte IpAddress : IpAddresses) {
				System.out.println(IpAddress & 0x000000ff);
			}
			
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
