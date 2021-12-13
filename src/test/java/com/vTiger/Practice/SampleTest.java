package com.vTiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleTest {

	@Test

	public void cmdlineparameter() {

		WebDriver driver;
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		System.out.println(browser);
		System.out.println(url);
		
		if (browser.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		} 
		else {
			driver = new ChromeDriver();
		}
	}

}
