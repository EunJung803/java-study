package prob01;

public class PrinterTest {

	public static void main(String[] args) {
		Printer printer = new Printer();

//		printer.<Integer>println( 10 );
		printer.println( 10 );
		printer.println( true );
		printer.println( 5.7 );
		printer.println( "홍길동" );
	}
}