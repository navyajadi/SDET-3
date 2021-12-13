package com.Vtiger.POMClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.FileUtil;

public class LoginPage 
{
	WebDriver driver;
	
	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement Loginbtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginPage() {
		return Loginbtn;
	}
	
	
	public LoginPage (WebDriver driver) {
		this.driver=driver;
       PageFactory.initElements(driver, this);
	}
	
	public void loginApp() throws IOException {
		
		username.sendKeys(FileUtil.objforFileUtil().readDataFrompropFile("username"));
		password.sendKeys(FileUtil.objforFileUtil().readDataFrompropFile("password"));
		Loginbtn.click();;
	}
	
	public void loginApp(String newusername, String newpassword) {
		
		username.sendKeys(newusername);
		password.sendKeys(newpassword);
		Loginbtn.click();
	}

	
}








