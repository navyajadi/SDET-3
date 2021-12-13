package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;


public class ContactinfoPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createbtn;
	
	@FindBy(name="search_text")
	private WebElement clickonSearchbtn;
	
	@FindBy(id="bas_searchfield")
    private WebElement clickonddbtn;
	
	
	@FindBy(name="submit")
	private WebElement  SearchNowbtn;


	public WebElement getCreatebtn() {
		return createbtn;
	}


	public WebElement getClickonSearchbtn() {
		return clickonSearchbtn;
	}


	public WebElement getClickonddbtn() {
		return clickonddbtn;
	}


	public WebElement getSearchNowbtn() {
		return SearchNowbtn;
	}
	
	public ContactinfoPage(WebDriver driver) {
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	
	}
	
	
	public void searchForConct(String organiname,  String text) {
		clickonSearchbtn.sendKeys(organiname);
		WebDriverUtil util=new WebDriverUtil(driver);
		util.selectFromDropdown(text, getClickonddbtn());
		SearchNowbtn.click();
	}
	
}
