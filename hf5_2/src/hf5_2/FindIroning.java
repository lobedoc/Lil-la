package hf5_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindIroning {
	static int j = 0;

	public static void isContainVasal(String fullString, String findString) {
		Pattern p = Pattern.compile(findString);
		Matcher m = p.matcher(fullString);
		while (m.find()) {
			j++;
		}
	}
}
