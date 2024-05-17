package readData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelSheet {
	@Test
	public void dataReadTest() throws Exception {
		File src = new File("C:\\Users\\saumyapatel\\Desktop\\ExitTestData.xlsx\\");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fis);
		//for .xls files
		//HSSFWorkbook xsf = new HSSFWorkbook(fis);
		XSSFSheet sheet =xsf.getSheetAt(0);
		String entry1 = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println("The data in the boxes" + entry1);
		xsf.close();
	}
}
