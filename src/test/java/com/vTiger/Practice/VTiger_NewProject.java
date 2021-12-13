package com.vTiger.Practice;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.Vtiger.POMClasses.LoginPage;
import com.Vtiger.genericUtil.FileUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class VTiger_NewProject {

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
		WebDriverUtil.pageloadWait();;

		driver.get(FileUtil.objforFileUtil().readDataFrompropFile("url"));

		// login into application
		LoginPage Lp = new LoginPage(driver);
		Lp.loginApp();

		driver.findElement(By.id("qccombo")).click();
		List<WebElement> ddsearch = driver.findElements(By.xpath("//select[@id='qccombo']//option"));

		System.out.println(ddsearch.size());

		for (int i = 0; i < ddsearch.size(); i++) {
			WebElement add = ddsearch.get(i);
			String text = add.getText();
			System.out.println(add.isDisplayed());
			if (text.equalsIgnoreCase("New Project")) {

				add.click();
			} else {

				System.out.println("Fail");
			}
		}

	}
}
