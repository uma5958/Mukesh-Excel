package com.library;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	public ExcelDataConfig(String execelPath) {
		try {
			File src=new File("./ExcelData/ExcelData.xlsx");
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}	
public String getData(int sheetnumber, int row, int column) {
	sheet1=wb.getSheetAt(sheetnumber);
	String data = sheet1.getRow(row).getCell(column).getStringCellValue();
	return data;
	}
}