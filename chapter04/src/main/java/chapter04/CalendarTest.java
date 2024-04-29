package chapter04;

import java.util.Calendar;
//import java.util.Locale;
//import java.util.TimeZone;

public class CalendarTest {
	
	public static void main(String[] args) {
//		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
//		TimeZone tz = TimeZone.getDefault();
//		System.out.println(aLocale + " : " + tz);
		
		// printDate 메서드로 출력하기
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		
		// 특정 시간 출력 1
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 11);		// == 12월 (Month - 1)
		cal.set(Calendar.DATE, 25);
		
		printDate(cal);
		
		// 특정 시간 출력 2
		cal.set(2000, 8, 3);
		cal.add(Calendar.DATE, 10000);
		printDate(cal);
		
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일","월","화","수","목","금","토"};	// 변하지 않는 상수에 final 붙임
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);		// 0~11 이므로 +1 해주기
		int date = cal.get(Calendar.DATE);
		
		int day = cal.get(Calendar.DAY_OF_WEEK);	// 1(일)~7(토)
		
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
						year + "년 "
						+ (month + 1) + "월 "
						+ date + "일 "
						
						+ DAYS[day-1] + "요일 "
						
						+ hour + "시 "
						+ minute + "분 "
						+ second + "초");
		
	}

}
