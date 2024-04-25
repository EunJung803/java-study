package prob03;

public class CurrencyConverter {
	private static double rate;
	
	public static void setRate(double rate) {
		// 환율 설정 (KRW/$1)
		CurrencyConverter.rate = rate;
	}

	public static double toDollar(double dollar) {
		// 달러를 한국 원화로 변환
		double money = dollar / CurrencyConverter.rate;
		
		return money;
	}

	public static double toKRW(double krw) {
		// 한국 원화를 달러로 변환
		double money = krw * CurrencyConverter.rate;
		
		return money;
	}

}
