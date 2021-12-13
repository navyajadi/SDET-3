package com.SDET.ReadData;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadData_JSON {
	public static void main(String[] args) throws IOException, ParseException {
		String dire = System.getProperty("user.dir");
		String jsonpath = dire + "/SDET_1.json";
		FileReader fr=new FileReader(jsonpath);
		JSONParser jp=new JSONParser();
		Object data = jp.parse(fr);
		HashMap jobj=(HashMap) data;
		String value = jobj.get("username").toString();
		System.out.println(value);
		
	}

}
