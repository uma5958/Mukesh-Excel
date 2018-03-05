package com.readExcelData;

import com.library.ExcelDataConfig;

public class ReadUsingLibrary {

	public static void main(String[] args) {
		ExcelDataConfig excel=new ExcelDataConfig("./ExcelData/ExcelData.xlsx");
		System.out.println(excel.getData(0, 0, 0)); // To Read data from Sheet1, row1, column0
		System.out.println(excel.getData(1, 0, 1));	// To Read data from Sheet2, row1, column2
		System.out.println(excel.getData(2, 1, 1)); // To Read data from Sheet3, row2, column2
	}
}
