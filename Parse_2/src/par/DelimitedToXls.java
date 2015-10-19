package par;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DelimitedToXls {
	public static ArrayList<String> pirositani = new ArrayList<String>();
	@SuppressWarnings({ "deprecation", "resource" })
	public void run() throws IOException {
		ArrayList<ArrayList<String>> allRowAndColData = null;
		ArrayList<String> oneRowData = null;
		String fName = ReadCVS.curr_filename.get(0);

		File userFile = new File(ReadCVS.szovi.get(0) + "_" + fName);
		String filename = userFile.getName();
		

		String currentLine;
		BufferedReader br = new BufferedReader(new InputStreamReader(
			    new FileInputStream(fName), "UTF-8"));

		allRowAndColData = new ArrayList<ArrayList<String>>();
		while ((currentLine = br.readLine()) != null) {
			oneRowData = new ArrayList<String>();
			String oneRowArray[] = currentLine.split(";");
			for (int j = 0; j < oneRowArray.length; j++) {
				oneRowData.add(oneRowArray[j]);
			}
			allRowAndColData.add(oneRowData);
			System.out.println();
		}

		try {
			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet sheet = workBook.createSheet("sheet1");
			
			for (int i1 = 0; i1 < allRowAndColData.size(); i1++) {
				ArrayList<?> ardata = (ArrayList<?>) allRowAndColData.get(i1);
				HSSFRow row = sheet.createRow((short) 0 + i1);
				for (int k = 0; k < ardata.size(); k++) {
					System.out.print(ardata.get(k));
					HSSFCell cell = row.createCell((short) k);

					cell.setCellValue(ardata.get(k).toString());
				}
				System.out.println();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(
					filename.substring(0, filename.lastIndexOf(".") + 1)+ "xls");
			pirositani.add(filename.substring(0, filename.lastIndexOf(".") + 1)+ "xls");

			workBook.write(fileOutputStream);
			fileOutputStream.close();
			
		} catch (Exception ex) {
		}
	}
}
