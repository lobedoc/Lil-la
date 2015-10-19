package hf5_2;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tokenize {

	public static ArrayList<String> splitted = new ArrayList<String>();

	public static void judge(String fullString) {

		StringTokenizer multiTokenizer = new StringTokenizer(fullString,
				"://.-<>!,[] ");

		for (int i = 0; multiTokenizer.hasMoreTokens(); i++) {

			splitted.add(i, multiTokenizer.nextToken());

		}
	}

}
