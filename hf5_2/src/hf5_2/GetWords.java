package hf5_2;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

public class GetWords {
	public static ArrayList<String> message = new ArrayList<String>();

	public static void kombajn(String data) {
		BreakIterator bi = BreakIterator.getWordInstance(Locale.getDefault());
		bi.setText(data);
		int lastIndex = bi.first();
		while (lastIndex != BreakIterator.DONE) {
			int firstIndex = lastIndex;
			lastIndex = bi.next();
			if (lastIndex != BreakIterator.DONE
					&& Character.isLetterOrDigit(data.charAt(firstIndex))) {
				String word = data.substring(firstIndex, lastIndex);
				message.add(word);
			}
		}
	}
}
