package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		
		// 1. 하나씩 뽑아서 거꾸로 넣기
		char[] rev = new char[str.length()];
		int idx = 0;
		
		for(int i=str.length()-1; i>-1; i--) {
			rev[idx] = str.charAt(i);
			idx += 1;
		}
		
		// 2. toCharArray 메서드 사용
		/*
		char[] cs = str.toCharArray();
		
		char[] rev2 = new char[str.length()];
		int idx2 = 0;
		
		for(int i=cs.length-1; i>-1; i--) {
			rev2[idx2] = cs[i];
			idx2 += 1;
		}
		*/
		
		return rev;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}