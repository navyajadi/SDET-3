package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;
public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement orgnslink;

	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactsLink;

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createcontaclink;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLink;

	@FindBy(xpath = "//img[@style='padding: 0px;padding-left:5px']")
	private WebElement LogoutLink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgnslink() {
		return orgnslink;
	}

	public WebElement getcreatecontaclink() {
		return contactsLink;
	}

	public WebElement getClickinlink() {
		return createcontaclink;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void logOutfromApp() throws InterruptedException {
		WebDriverUtil WebUtil = new WebDriverUtil(driver);
		WebUtil.mouseHover(LogoutLink);
		Thread.sleep(3000);
		signoutLink.click();
	}

}
