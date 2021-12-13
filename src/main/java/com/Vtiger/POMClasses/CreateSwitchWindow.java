package com.Vtiger.POMClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.ExcelUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class CreateSwitchWindow {

	WebDriver driver;

	@FindBy(id = "search_txt")
	private WebElement searchtext;

	@FindBy(name = "search_field")
	private WebElement Organizationnamedd;

	@FindBy(name = "search")
	private WebElement searchname;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchtext() {
		return searchtext;
	}

	public WebElement getOrganizationnamedd() {
		return Organizationnamedd;
	}

	public WebElement getSearchname() {
		return searchname;
	}

	public CreateSwitchWindow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void SwitchnewWindow() throws EncryptedDocumentException, IOException {
		String orgname = ExcelUtil.objforExcelUtil().readDatafromExcelFile("Sheet2", 8, 0);
		searchtext.sendKeys(orgname);

		WebDriverUtil util = new WebDriverUtil (driver);
		util.selectFromDropdown(orgname, Organizationnamedd);
		searchname.click();
	}

}