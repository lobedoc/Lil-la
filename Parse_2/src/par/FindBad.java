package par;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class FindBad {
	
	@SuppressWarnings("null")
	public static void Findbad() throws Exception {
        String filename = DelimitedToXls.pirositani.get(0);
        
        PrintStream out1 = new PrintStream(new TextAreaOutputStream(Gui.textArea));
		System.setOut(out1);
		System.setErr(out1);
		
        FileInputStream fis = null;
        try {

            fis = new FileInputStream(filename);
 
            @SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
 
            //
            // Read a cell the first cell on the sheet.
            //
           // HSSFCell cell = sheet.getRow(0).getCell(0);
            for(Row myrow : sheet)
            {
            	for (Cell mycell : myrow) {
            if (mycell.getStringCellValue().contains("!!!")) {
            	HSSFCellStyle style = workbook.createCellStyle();
            	style.setFillForegroundColor(HSSFColor.WHITE.index);
            	style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            	HSSFFont font = workbook.createFont();
            	font.setColor(HSSFColor.RED.index);
            	style.setFont(font);

            	mycell.setCellStyle(style);
            	FileOutputStream out = new FileOutputStream(filename);
            	workbook.write(out);
            	out.close();
                //System.out.println("Cell type for date data type is numeric.");
            }
            }
            }
 
            Cell mycell = null;
			//
            // Using HSSFDateUtil to check if a cell contains a date.
            //
            if (HSSFDateUtil.isCellDateFormatted(mycell)) {
                System.out.println("The cell contains a date value: " + mycell.getDateCellValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}
