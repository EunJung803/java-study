package exception;

public class ExceptionTest {
	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;

		System.out.println("some code 1 ...");
		try {
			System.out.println("some code 2 ...");
			System.out.println("some code 3 ...");
			
//			int result = (1 + 2 + 3) / b;
			
			System.out.println("some code 4 ...");
			System.out.println("some code 5 ...");
			
		} catch (ArithmeticException ex) {		// 발생하는 예외 이름으로 잡아주기
			/* 예외 처리 */
			
			// 1. 로깅 (로그를 남겨야함, 파일로 남겨놓기)
			System.out.println("error : " + ex);
			
			// 2. 사과
			System.out.println("미안합니다...");
			
			// 3. 정상 종료
//			System.exit(1);
			return;
		} finally {
			System.out.println("자원 정리 : ex) close file, socket, db connection");
		}
		
		System.out.println("some code 6 ...");
		System.out.println("some code 7 ...");
		
	}	

}
