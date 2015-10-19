package hf5_2;

import java.util.HashMap;
import java.util.Map;

public class ByLetterNumber {
	public void byLetterNumber() {

		Map<String, Integer> stringsCount = new HashMap<>();
		for (String s : Main.names_receiver) {
			Integer c = stringsCount.get(s);
			if (c == null)
				c = new Integer(0);
			c++;
			stringsCount.put(s, c);
		}
		Map.Entry<String, Integer> mostRepeated = null;
		for (Map.Entry<String, Integer> e : stringsCount.entrySet()) {
			if (mostRepeated == null || mostRepeated.getValue() > e.getValue())
				mostRepeated = e;
		}
		if (mostRepeated != null)
			System.out.println("Ki van rúgva, legkevesebbet levelezõ: "
					+ mostRepeated.getKey() + ", " + "Összesen: "
					+ mostRepeated.getValue() + " levelezese van. :(");
	}

}
