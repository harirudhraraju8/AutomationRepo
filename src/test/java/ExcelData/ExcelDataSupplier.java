package ExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataSupplier {

	public static void main(String[] args) throws IOException {

		File excelFile=new File("./resources/excel/Test.xlsx");
		System.out.println(excelFile.exists());
		FileInputStream fis=new FileInputStream(excelFile);

		
		
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int noOfRows=sheet.getPhysicalNumberOfRows();
		int noOfCols=sheet.getRow(0).getLastCellNum();

		for(int i=1; i<noOfRows;i++) {
			for(int j=0;j<noOfCols;j++) {
			System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
			System.out.println();
		}  



		workbook.close();
		fis.close();



	}

}
