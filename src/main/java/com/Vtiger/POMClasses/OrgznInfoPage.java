package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;

public class OrgznInfoPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Organizations']") 
	private WebElement createorgnsimg;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
			private WebElement Createorgn;
	
	@FindBy(name="search_text")
	private WebElement searchfororgnsfld;
	
	@FindBy(name="search_field")
	private WebElement searchfororgndd;
	
	@FindBy(name="submit")
	private WebElement searchNowbtn;

	public WebElement getClickingorgnbox() {
		return Createorgn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateorgnsimg() {
		return createorgnsimg;
	}

	public WebElement getSearchfororgnsfld() {
		return searchfororgnsfld;
	}

	public WebElement getSearchfororgndd() {
		return searchfororgndd;
	}

	public WebElement getSearchNowbtn() {
		return searchNowbtn;
	}
	
	public OrgznInfoPage(WebDriver driver) {
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void searchForOrg(String organiname,  String text) {
		searchfororgnsfld.sendKeys(organiname);
		WebDriverUtil util=new WebDriverUtil(driver);
		util.selectFromDropdown(text, getSearchfororgndd());
		searchNowbtn.click();
	}
	
}
