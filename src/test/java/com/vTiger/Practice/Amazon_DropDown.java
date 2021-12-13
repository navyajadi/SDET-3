package com.vTiger.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.Vtiger.genericUtil.FileUtil;
import com.Vtiger.genericUtil.WebDriverUtil;


public class Amazon_DropDown {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		// to Launch the Browser

		String browser = FileUtil.objforFileUtil().readDataFrompropFile("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("opera")) {
			driver = new OperaDriver();
		} else {
			driver = new ChromeDriver();
		}
		WebDriverUtil WebDriverUtil = new WebDriverUtil(driver);
		WebDriverUtil.maximizeWndw();;
		WebDriverUtil.pageloadWait();

		driver.get(FileUtil.objforFileUtil().readDataFrompropFile("url2"));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles below 15000", Keys.ENTER);
		//driver.findElement(By.name("class=\"nav-input nav-progressive-attribute\"");
		

	}
}
