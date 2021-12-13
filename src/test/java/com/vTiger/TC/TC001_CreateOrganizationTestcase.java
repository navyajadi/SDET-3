package com.vTiger.TC;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.LoginPage;
import com.Vtiger.POMClasses.OrgznCreatePage;
import com.Vtiger.POMClasses.OrgznInfoPage;
import com.Vtiger.genericUtil.FileUtil;
import com.Vtiger.genericUtil.JavaUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class TC001_CreateOrganizationTestcase {
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

		HomePage hp = new HomePage(driver);
		hp.getOrgnslink();
		String organiname = JavaUtil.ObjforJavaUtil().getFirstName() + JavaUtil.ObjforJavaUtil().generateRandomNumber();
		OrgznInfoPage OIP = new OrgznInfoPage(driver);
		OIP.getCreateorgnsimg().click();
		OIP.getClickingorgnbox().click();

		OrgznCreatePage Ocp = new OrgznCreatePage(driver);
		Ocp.OrgCreateContact(organiname);
		Ocp.getSavecontactbtn();
		WebDriverUtil.pageloadWait();;

		// refresh the page
		Thread.sleep(3000);
		driver.navigate().refresh();

		// again clicking the Organization
		OIP.getSearchfororgnsfld();

		// selecting the Dropdown
		OIP.getSearchfororgndd();
		OIP.getSearchNowbtn();

		// Validation the Create Organization
		OIP.getCreateorgnsimg().click();

		try {
			WebElement fe = driver.findElement(By.xpath("//a[@title='Organizations' and text()='" + organiname + "']"));
			System.out.println(fe.isDisplayed());
			
			if (fe.getText().equalsIgnoreCase(organiname)) {
				System.out.println("Pass");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		} 
		finally {
			hp.logOutfromApp();
			Thread.sleep(1000);
		}

	}
}
