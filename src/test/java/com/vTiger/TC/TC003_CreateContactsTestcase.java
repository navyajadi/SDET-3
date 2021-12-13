package com.vTiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.Vtiger.POMClasses.ContactinfoPage;
import com.Vtiger.POMClasses.CreateContactPage;
import com.Vtiger.POMClasses.CreateSwitchWindow;
import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.LoginPage;
import com.Vtiger.genericUtil.FileUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class TC003_CreateContactsTestcase {

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

		driver.get(FileUtil.objforFileUtil().readDataFrompropFile("url"));

		WebDriverUtil WebDriverUtil = new WebDriverUtil(driver);
		WebDriverUtil.maximizeWndw();
		WebDriverUtil.pageloadWait();
		LoginPage Lp = new LoginPage(driver);
		Lp.loginApp();

		HomePage hp = new HomePage(driver);
		hp.getcreatecontaclink().click();

		ContactinfoPage CIP = new ContactinfoPage(driver);
		CIP.getCreatebtn().click();

		CreateContactPage ContactCreate = new CreateContactPage(driver);

		String nametag = ContactCreate.CreateContact("Ms.");

		ContactCreate.getInsideSelectbnt().click();

		String parent = driver.getWindowHandle();

		WebDriverUtil.switchWndwHandle("Accounts&action");

		CreateSwitchWindow CSW = new CreateSwitchWindow(driver);
		Thread.sleep(2000);
		
		CSW.getSearchtext().sendKeys("Layne478");

		CSW.getSearchname().click();
		driver.switchTo().window(parent);

		Thread.sleep(2000);
		driver.navigate().refresh();

		try {
			String fe = driver.findElement(By.xpath("//a[text()='Contacts']")).getText();
			System.out.println(fe);

			if (fe.equalsIgnoreCase(nametag)) {
				System.out.println("Pass");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		} finally {
			hp.logOutfromApp();
			Thread.sleep(1000);
		}


	}
}
