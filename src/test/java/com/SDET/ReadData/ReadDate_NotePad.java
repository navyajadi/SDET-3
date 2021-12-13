package com.SDET.ReadData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDate_NotePad {
	public static void main(String[] args) throws IOException {
		String dire = System.getProperty("user.dir");
		String path = dire + "/notepad.PROPERTIES";
		FileInputStream fis = new FileInputStream(path);
		Properties Prop = new Properties();
		Prop.load(fis);
		String value = Prop.getProperty("username");
		System.out.println(value);

	}

}
