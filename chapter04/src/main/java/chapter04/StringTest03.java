package chapter04;

public class StringTest03 {
	
	public static void main(String[] args) {
//		String s1 = "Hello " + "World" + " java" + 17;
		
		String s1 = new StringBuffer("Hello ")
						.append("World")
						.append(" java ")
						.append(17)
						.toString();
		
//		String s2 = new StringBuilder("Hello ")
//						.append("World")
//						.append(" java ")
//						.append(17)
//						.toString();

//		System.out.println(s1);
//		System.out.println(s2);
		
		String s2 = "";
		for(int i = 0; i < 1000000; i++) {
			// s2 += "h";
			// s2 = new StringBuffer(s2).append("h").toString();
		} 
		
		StringBuffer sb = new StringBuffer("");
		
		for(int i = 0; i < 1000000; i++) {
			sb.append("h");
		}
		String s3 = sb.toString();
		
		
		// String method들
		String s4 =  "aBcABCabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));			// 가장 먼저 등장한 인덱스
		System.out.println(s4.indexOf("abc", 7));		// 시작 인덱스 붙이기 가능, 없으면 -1
		System.out.println(s4.substring(3));			// 인덱스 3부터 슬라이싱
		System.out.println(s4.substring(3, 5));			// 인덱스 3에서 5(포함X)까지 자름
		
		String s5 = "      ab        cd         ";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6);
		System.out.println(s7);												// 두 String 합치기
		System.out.println("----" + s5.trim() + "----");					// 겉에 있는 공백 삭제
		System.out.println("----" + s5.replaceAll(" ", "") + "----");		// 해당 문자열 모두 replace
		
		String[] tokens = s6.split(",");		// 해당 문자열을 기준으로 잘라내어 배열에 담김
		for(String s : tokens) {
			System.out.println(s);
		}
		
		String[] tokens2 = s6.split(" ");		// 해당 문자열을 기준으로 잘라낼 수 없는 경우는 -> 통째로 안잘리고 들어감 배열에
		for(String s : tokens2) {
			System.out.println(s);
		}
		
	}

}
