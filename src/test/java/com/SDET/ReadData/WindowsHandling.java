package com.SDET.ReadData;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.genericUtil.WebDriverUtil;


public class WindowsHandling {
	public static WebDriver driver;

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.naukri.com/");

		WebDriverUtil WebDriverUtil = new WebDriverUtil(driver);
		WebDriverUtil.maximizeWndw();
		WebDriverUtil.pageloadWait();
		
		Set<String> windId = driver.getWindowHandles();

		for (String id : windId) {

			String Title = driver.switchTo().window(id).getTitle();
			System.out.println(Title);

			if (Title.equalsIgnoreCase("Cognizant")) {
				driver.close();
			}
		}

	}
}
