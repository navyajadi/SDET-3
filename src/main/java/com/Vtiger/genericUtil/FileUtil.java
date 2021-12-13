package com.Vtiger.genericUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	
	private FileUtil() {
		
	}
	
	/**
	 * @author jagad
	 * Description:This methods creates an Object for FileUtil
	 * @return
	 */

	public static FileUtil objforFileUtil() {
		FileUtil fu = new FileUtil();
		return fu;
	}

	public String readDataFrompropFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IAutoConstants.propfilepath);
		Properties pro= new Properties();
		pro.load(fis);
		return pro.getProperty(key);
		
	}
	
}
