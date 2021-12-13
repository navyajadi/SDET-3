package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.JavaUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class OrgznCreatePage {

	WebDriver driver;

	@FindBy(name = "accountname")
	private WebElement givingOrgznname;

	@FindBy(name = "industry")
	private WebElement orgindustrydd;

	@FindBy(name = "accounttype")
	private WebElement orgtypedd;

	@FindBy(name = "rating")
	private WebElement orgratingdd;
	
	@FindBy(id="phone")
	private WebElement Phonenumber;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement Savecontactbtn;

	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getGivingOrgznname() {
		return givingOrgznname;
	}

	public WebElement getOrgindustrydd() {
		return orgindustrydd;
	}

	public WebElement getOrgtypedd() {
		return orgtypedd;
	}

	public WebElement getOrgratingdd() {
		return orgratingdd;
	}

	public WebElement getPhonenumber() {
		return Phonenumber;
	}

	public WebElement getSavecontactbtn() {
		return Savecontactbtn;
	}

	public OrgznCreatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void OrgCreateContact(String organiname) {
		givingOrgznname.sendKeys(organiname);
	
	}
	
	public void OrgCreatdd(String organiname, String industry,String type,String rating) {
		givingOrgznname.sendKeys(organiname);
		WebDriverUtil util = new WebDriverUtil(driver);
		util.selectFromDropdown(industry, getOrgindustrydd());
		util.selectFromDropdown(type, getOrgtypedd());
		util.selectFromDropdown(rating, getOrgratingdd());
		Savecontactbtn.click();
	}
	
	public void PhoneNo(String text) {
		Phonenumber.sendKeys(JavaUtil.ObjforJavaUtil().getphoneNumber());	
	}
}