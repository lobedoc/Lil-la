package par;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Munawwar
 */
public class XlsxtoCSV {
	String csvwebFile = Gui.webfileName.toString();
	public static ArrayList<String> curr_webfilename = new ArrayList<String>();

    public static void echoAsCSV(Sheet sheet) {
        Row row = null;
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.print(row.getCell(j) + ";");
            }
            System.out.println();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void convert() {
        InputStream inp = null;
        try {
            inp = new FileInputStream(Gui.webfileName.toString());
            curr_webfilename.add(Gui.webfileName.toString());
            Workbook wb = WorkbookFactory.create(inp);

            for(int i=0;i<wb.getNumberOfSheets();i++) {
            	System.setOut(new PrintStream(new FileOutputStream(curr_webfilename.get(0) + ".txt")));
                //System.out.println(wb.getSheetAt(i).getSheetName());
                echoAsCSV(wb.getSheetAt(i));
            }
            
        } catch (InvalidFormatException ex) {
            Logger.getLogger(XlsxtoCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XlsxtoCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XlsxtoCSV.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
             PrintStream out1 = new PrintStream(new TextAreaOutputStream(Gui.textArea));
       		 System.setOut(out1);
       		 System.setErr(out1);
                inp.close();     
            } catch (IOException ex) {
                Logger.getLogger(XlsxtoCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Webesbol CSV kesz!");
        }
    }
}