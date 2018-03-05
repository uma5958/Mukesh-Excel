package com.readExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTotalRowData {

	public static void main(String[] args) throws IOException {
		File src=new File("./ExcelData/ExcelData.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis); 
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int rowcount = sheet1.getLastRowNum(); //for counting total number of Rows
		System.out.println("Total rows are: "+rowcount+1);
		for(int i=0; i<rowcount; i++) {
			String data0=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Data from Row "+i+" is: "+data0);
		}
		wb.close(); 
	}
}
