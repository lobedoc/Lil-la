package par;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
 
public class GetDataFromXls {
	String csvFile = Gui.fileName.toString();
	public static ArrayList<String> curr_filename_web = new ArrayList<String>();
	public static ArrayList<String> hibasak = new ArrayList<String>();
  public void run() throws UnsupportedEncodingException {

	ArrayList<String> other_data_osszeg = new ArrayList<String>();
	
	String filename = null;
	//String csvFile = "Geo.txt";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ";";
	PrintStream out = null;
	//PrintStream stdout = System.out;
	try {
	
		Random r = new Random();
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		filename = "WebOut" + r.nextInt(99) + "_" + (date) + ".txt";
		out = new PrintStream(new FileOutputStream(filename), false, "UTF-8");
		curr_filename_web.add(filename);
	} catch (FileNotFoundException e1) {
		System.out.println("Kimeneti file hiba!");
		e1.printStackTrace();
	}
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
 
			String[] oszlop = line.split(cvsSplitBy);
			GetData2e.getdata(oszlop[11].toString());
			//other_data_nev.add(oszlop[4].toString()); 
			other_data_osszeg.add(oszlop[6].toString());
			//other_data_szamla.add(oszlop[10].toString());
			hibasak.add(oszlop[11].toString());
			for(int i=0; i != GetData2e.list.size(); i++)
			{
			if(GetData2e.list.get(i).equals(" !!! "))
			{
				GetData2e.list.set(i, " !!! " + hibasak.get(i).toString() + " !!! ");
			}
			}
		}
		for(int i=0; i != GetData2e.list.size(); i++)
		{
	    System.setProperty("file.encoding", "UTF-8");
		System.setOut(out);
		System.out.println(other_data_osszeg.get(i).toString() + ";" + GetData2e.list.get(i).toString().toUpperCase() + ";");
		}
		
		PrintStream out1 = new PrintStream(new TextAreaOutputStream(Gui.textArea));
		System.setOut(out1);
		System.setErr(out1);
		
		//System.setOut(stdout);
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	System.out.println("Webes Kesz!");
  } 
}