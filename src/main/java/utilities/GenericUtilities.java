package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenericUtilities {
	
	public static int PAGE_LOAD_TIME = 20;
	public static int IMPLICIT_WAIT_TIME =20;

	public Object[][] data = null;
	Workbook book;
	Row row;
	Cell cell = null;
	public Object[][] ReadExcel(String sheetname) throws IOException{
		File file = new File("E:\\Work\\JavaLearningClasses2\\AmazaonPOMAutomationTest\\src\\main\\java\\testData\\TestData.xlsx");
		FileInputStream stream = new FileInputStream(file);
		book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(sheetname);
		int noRows = sheet.getPhysicalNumberOfRows();
		
		data = new Object[noRows-1][3]; // To bypass header row
		for(int i=1;i<noRows;i++){
			row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				data[i-1][j] = cell.getStringCellValue();
				System.out.println("data["+(i-1)+"]["+j+"]="+data[i-1][j]);
			}
		}
				
		return data;
	}
	
}
