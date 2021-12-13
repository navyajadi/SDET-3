package com.vTiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.genericUtil.ExcelUtil;

public class NewDataProvider {

	ExcelUtil excel = new ExcelUtil();

	@Test(dataProvider = "getValue")

	public void print(String value1, String value2) {
		System.out.println(value1 + " " + value2);

	}

	@DataProvider()

	public Object[][] getValue() throws EncryptedDocumentException, IOException {
		int lastrow = excel.getlastRow();

		Object arr[][] = new Object[lastrow + 1][2];

		for (int i = 0; i < lastrow + 1; i++) {

			arr[i][0] = excel.readDatafromExcelFile("Sheet3", i, 0);
			arr[i][1] = excel.readDatafromExcelFile("Sheet3", i, 1);

		}
		return arr;

	}

	
//	@DataProvider()
//
//	public Object[][] getValue() {
//		Object arr[][] = new Object[4][2];
//
//		arr[0][0] = "TYSS";
//		arr[0][1] = "HYD";
//
//		arr[1][0] = "Qsp";
//		arr[1][1] = "Banglr";
//
//		arr[2][0] = "Jsp";
//		arr[2][1] = "Channai";
//
//		arr[3][0] = "Pysp";
//		arr[3][1] = "Nodia";
//
//		return arr;
//
//	}
}
