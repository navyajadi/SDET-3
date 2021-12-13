package com.Vtiger.POMClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.JavaUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class CreateContactPage {
	
	WebDriver driver;
	
	@FindBy(name="salutationtype")
	private WebElement nametagdd;
	
	@FindBy(name="firstname")
	private WebElement Fsrtname;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement insideSelectbnt;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savecontactbtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getsalutation() {
		return nametagdd;
	}

	public WebElement getFsrtname() {
		return Fsrtname;
	}
 
	public WebElement getlastname() {
		return lastname;
	}
	public WebElement getInsideSelectbnt() {
		return insideSelectbnt;
	}

	public WebElement getSaveoncontactbtn() {
		return savecontactbtn;
	}
	
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	
	public String CreateContact(String salutation) throws EncryptedDocumentException, IOException
	{
		WebDriverUtil util=new WebDriverUtil(driver);
		util.selectFromDropdown(salutation, nametagdd);
		String Fname = JavaUtil.ObjforJavaUtil().getFirstName();
		String Lname = JavaUtil.ObjforJavaUtil().getLastName();
		Fsrtname.sendKeys(Fname);
		lastname.sendKeys(Lname);
		return Fname;
		
	}
	
}


