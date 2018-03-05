package com.writeData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteSheet {

	public static void main(String[] args) throws IOException {
		File src=new File("./ExcelData/ExcelData.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		sheet1.getRow(0).createCell(2).setCellValue("Uma");
		sheet1.getRow(1).createCell(2).setCellValue(5958);
		sheet1.getRow(2).createCell(2).setCellValue(14.12);
		FileOutputStream fout=new FileOutputStream(src);//To Write File
		wb.write(fout);//To save WorkBook
		wb.close();
	}

}
