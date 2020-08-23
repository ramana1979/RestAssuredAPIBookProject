package Util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.semantics.SymbolChecks;

public class ExcelUtilsArray {
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	static int rows;
	static int cols;
	
	
	public Object[][] excelReadData(String path1,String sh)
	{
		try
		{
		Object dataSets[][]=null;
		workBook=new XSSFWorkbook(path1);
		sheet=workBook.getSheet(sh);
		 rows=sheet.getLastRowNum();
		 cols=sheet.getRow(0).getLastCellNum();
		 System.out.println("Rows "+rows);
		 System.out.println("Cols "+cols);
		 dataSets=new Object[rows][cols];
		 for(int i=1;i<rows;i++)
		 {
			 for(int j=0;i<cols;j++)
			 {
				 System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
			 }
			 System.out.println(); 
		 }
		 return dataSets;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
			return null;
		}
		
	}
	public static void main(String[] args) {
		 String path="./data/TestData.xlsx";
		 String sheet1="sheet1";
		ExcelUtilsArray excel=new ExcelUtilsArray();
		Object data[][]=excel.excelReadData(path, sheet1);
	}

}
