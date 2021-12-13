package com.SDET.ReadData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData_Excel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	String dire = System.getProperty("user.dir");
	String path = dire+"/src/SDET.xlsx";
	FileInputStream fis=new FileInputStream(path);
	Workbook book = WorkbookFactory.create(fis);
	Sheet sheet = book.getSheet("Sheet1");
	Row Row = sheet.getRow(1);
	String value = Row.getCell(1).getStringCellValue();
	int a = Integer.parseInt(value);
	System.out.println(a);

}
}