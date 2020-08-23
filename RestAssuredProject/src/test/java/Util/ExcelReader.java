package Util;

public class ExcelReader {
	static String path="./data/TestData.xlsx";
	static String sheet="sheet1";
	public static void main(String[] args)  {
		try{
			ExcelUtils excel=new ExcelUtils(path, sheet);
			excel.getRowCount();
			excel.getCellData();
			excel.getCellDetaDetails();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}
}
