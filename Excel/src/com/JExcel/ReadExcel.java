package com.JExcel;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

	public static void main(String[] args) throws BiffException, IOException {
			File src=new File("./ExcelData/Data.xls");
			Workbook wb=Workbook.getWorkbook(src);
			String data00 = wb.getSheet(0).getCell(0,0).getContents();
			System.out.println("Data from Row 0 Column 0 : "+data00);
			String data01 = wb.getSheet(0).getCell(0,1).getContents();
			System.out.println("Data from Row 0 Column 1 : "+data01);
			int rows = wb.getSheet(0).getRows();
			System.out.println("Total no.of rows in Sheet1 are: "+rows);
			int columns = wb.getSheet(0).getColumns();
			System.out.println("Total no.of columns in Sheet1 are: "+columns);
	}

}
