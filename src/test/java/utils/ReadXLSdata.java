package utils;
 
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
 
public class ReadXLSdata {
	@DataProvider(name="testdata")
	public String[][] getdata(Method m) throws Exception {
		String excelSheetName = m.getName();
		File f = new File("C:\\Users\\saumyapatel\\eclipse-workspace\\ExitTest\\src\\test\\java\\readData\\testsheet.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);
		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][1]; 

		for (int i = 1; i <= totalRows; i++) {
		    testData[i - 1][0] = format.formatCellValue(sheetName.getRow(i).getCell(0));
		    System.out.println(testData[i - 1][0]);
		}
		return testData;
	}

}
