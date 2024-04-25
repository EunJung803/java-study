package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		String answer = "";
		for(int i=0; i<strArr.length; i++) {
			answer += strArr[i];
		}
		return answer;
	}
}
