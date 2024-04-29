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
		
	}

}
