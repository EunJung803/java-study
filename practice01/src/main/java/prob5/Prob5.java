package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for(int i=1; i<100; i++) {
			String str = Integer.toString(i);
			int cnt = 0;
			
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == '3' ||  str.charAt(j) == '6' ||  str.charAt(j) == '9') {
					cnt += 1;
				}
			}
			
			if(cnt > 0) {
				String jjak = "짝".repeat(cnt);
				System.out.println(str + " " + jjak);
			}
		}
		
	}
}
