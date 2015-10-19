package hf5_2;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static ArrayList<String> names_receiver = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		ByLetterNumber byLetter = new ByLetterNumber();
		ReadFile read = new ReadFile();
		read.readFile();
		// System.out.println(read.message.get(1));
		for (int i = 0; i != read.message.size(); i++) {
			GetWords.kombajn(read.message.get(i));
		}
		for (int i = 0; i != GetWords.message.size(); i++) {
			Tokenize.judge(GetWords.message.get(i));
		}
		for (int i = 0; i != Tokenize.splitted.size(); i++) {
			names_receiver.add(Tokenize.splitted.get(i));
		}
		byLetter.byLetterNumber();

		for (int i = 0; i != GetWords.message.size(); i++) {
			FindIroning.isContainVasal(GetWords.message.get(i), "vasal");
		}
		System.out.println("Összesen: " + FindIroning.j
				+ " vasaló szakkörös jelentkezés van.");
	}

}
