package com.vTiger.TCbase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.ContactinfoPage;
import com.Vtiger.POMClasses.CreateContactPage;
import com.Vtiger.POMClasses.CreateSwitchWindow;
import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.ExcelUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class TC003_CreateContactsBaseTest extends BaseClass {
	
	@Test(groups="smoketesting")
	public void CreateContactwithOrg() throws EncryptedDocumentException, IOException, InterruptedException {
	
		HomePage hp = new HomePage(driver);
		hp.getcreatecontaclink().click();

		ContactinfoPage CIP = new ContactinfoPage(driver);
		CIP.getCreatebtn().click();

		CreateContactPage ContactCreate = new CreateContactPage(driver);

		String nametag = ContactCreate.CreateContact("Ms.");

		ContactCreate.getInsideSelectbnt().click();

		String parent = driver.getWindowHandle();
		WebDriverUtil WebDriverUtil = new WebDriverUtil(driver);

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
		}
	}
	
	
	@Test(groups="regressiontesting")
	public void CreateContact(){
		
		HomePage hp = new HomePage(driver);
		hp.getcreatecontaclink().click();

		ContactinfoPage CIP = new ContactinfoPage(driver);
		CIP.getCreatebtn().click();
		
		CreateContactPage ContactCreate = new CreateContactPage(driver);
		ContactCreate.getlastname();
		WebElement fe = driver.findElement(By.xpath("//a[text()='Contacts']"));

		fe.isDisplayed();

		if (fe.getText().equals("SDET")) {

			System.out.println("Pass");
		} else {

			System.out.println("fail");
		}
	
    }
}

	
