package com.Vtiger.genericUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage Lp;

	public static WebDriver sdriver;

	@BeforeSuite(groups = { "smoketesting", "regressiontesting" })
	public void setUp() {
		System.out.println("Connect with data base");
	}

	//@Parameters("BROWSER")

	@BeforeClass(groups = { "smoketesting", "regressiontesting" })
	public void LaunchBrower_URL() throws IOException {
		String browser = FileUtil.objforFileUtil().readDataFrompropFile("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		WebDriverUtil WebDriverUtil = new WebDriverUtil(driver);
		WebDriverUtil.maximizeWndw();
		WebDriverUtil.pageloadWait();

		driver.get(FileUtil.objforFileUtil().readDataFrompropFile("url"));
		Lp = new LoginPage(driver);
		sdriver = driver;
	}

	@BeforeMethod(groups = { "smoketesting", "regressiontesting" })
	public void logintoApp() throws IOException {

		Lp.loginApp();
	}

	@AfterMethod(groups = { "smoketesting", "regressiontesting" })
	public void logOutfromAppp() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.logOutfromApp();
	}

	@AfterClass(groups = { "smoketesting", "regressiontesting" })
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();

	}

	@AfterSuite(groups = { "smoketesting", "regressiontesting" })
	public void disconnectedfromDB() {
		System.out.println("Disconnected");
	}

	public static void takeScreenShot(String name) throws IOException {

		File srcfile = ((TakesScreenshot) sdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir") + "/Screenshots" + name + ".png";
		File finaldest = new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);

	}

}
