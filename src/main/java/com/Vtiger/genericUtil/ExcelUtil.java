package com.Vtiger.genericUtil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static ExcelUtil objforExcelUtil() {
		ExcelUtil eu = new ExcelUtil();
		return eu;
	}

	public String readDatafromExcelFile(String key, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IAutoConstants.Excelfilepath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet("Sheet3");
		DataFormatter format = new DataFormatter();
		return format.formatCellValue(sh.getRow(row).getCell(cell)); 
	}

	public int getLastRow(String sheetname) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IAutoConstants.Excelfilepath);

		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		return sheet.getLastRowNum();
	}
	
	public int getlastRow() throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IAutoConstants.Excelfilepath);

		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet3");
		return sheet.getLastRowNum();
	}

	public String selectValueforDropDown(String sheetname, int cell, String j)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IAutoConstants.Excelfilepath);

		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet(sheetname);
		int lastrow = sheet.getLastRowNum();
		String value = "Null";

		for (int i = 0; i <= lastrow; i++) {

			value = sheet.getRow(i).getCell(cell).getStringCellValue();
			if (value.equalsIgnoreCase(j)) {
				break;
			}
		}

		return value;
	}

}
