package Util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static int rows;
	static int cols;
	public ExcelUtils(String path,String sheetName) throws IOException
	{
		try
		{
			workbook=new XSSFWorkbook(path);
			sheet=workbook.getSheet(sheetName);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public static void getRowCount()
	{
		rows=sheet.getPhysicalNumberOfRows()-1;
		cols=sheet.getRow(0).getLastCellNum();
		System.out.println("No of rows:" +rows+"\t and Columns"+cols);
	}
	public static void getCellData()
	{
		String value=sheet.getRow(2).getCell(0).getStringCellValue();
		String value1=sheet.getRow(2).getCell(1).getStringCellValue();
		System.out.println(value+"\t"+value1);
	}
	public static void getCellDetaDetails()
	{
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
			}
			System.out.println();
		}
	}


}
