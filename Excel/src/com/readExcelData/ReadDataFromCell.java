package com.readExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromCell {

	public static void main(String[] args) throws IOException {
		File src=new File("./ExcelData/ExcelData.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis); // for reading ".xlsx" files
		//HSSFWorkbook wb=new HSSFWorkbook(fis); // for reading ".xls" files
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Data from excel is: "+data0);
		String data1 = sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Data from excel is: "+data1);
		wb.close(); //To close the resource for avoiding memoty leak
	}
}
