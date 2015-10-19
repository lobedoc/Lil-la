package hf5_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadFile {

	public ArrayList<String> message = new ArrayList<String>();

	public void readFile() throws IOException {
		String arrayOfStrings[] = new String[73];

		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream("vzs.lev"), "UTF-8"));

			String line = "";

			int counter = 1;

			while (((line = reader.readLine()) != null)) {
				arrayOfStrings[counter] = line;

				if (counter % 3 == 0) {
					message.add(arrayOfStrings[counter - 2]
							+ arrayOfStrings[counter - 1]
							+ arrayOfStrings[counter]);
				}

				counter++;
			}

			reader.close();
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

}
