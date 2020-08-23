package Util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderWithExcel {
	public Object[][] getExcelData(String excelLocation, String sheetName) {
		try {
			Object dataSets[][] = null;
			// 1. Create a instance of file and location.
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// 2. Create a instance of work book.
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			// 3. Assign a sheet name of work book.
			XSSFSheet sheet = workBook.getSheet(sheetName);

			// 4. Count active rows.
			int totalRows = sheet.getLastRowNum();
			System.out.println(totalRows);
			// 5. Count active columns of row.
			int totalColumns = sheet.getRow(0).getLastCellNum();
			System.out.println(totalColumns);

			// 6. Assign rows and col's to data sets.
			dataSets = new Object[totalRows][totalColumns];
			for (int i=1;i<=totalRows;i++)
			{
				for(int j=0;j<totalColumns;j++)
				{
					System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
				}
				System.out.println();
			}
			return dataSets;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*public static void main(String[] args) {
		DataProviderWithExcel excel=new DataProviderWithExcel();
		String path="./data/TestData.xlsx";
		String sheet1="sheet1";
		Object[][] data=excel.getExcelData(path, sheet1);
		
		System.out.println("Done, Read excel data from sheet.");
		 
	}
*/
}
