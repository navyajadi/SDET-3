package com.vTiger.TCbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.OrgznCreatePage;
import com.Vtiger.POMClasses.OrgznInfoPage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.JavaUtil;

public class TC002_CreateOrganizationFromBaseTest extends BaseClass {
	@Test(groups="smoketesting")

	public void createOrg() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.getOrgnslink().click();

		String organiname = JavaUtil.ObjforJavaUtil().getFirstName() + JavaUtil.ObjforJavaUtil().generateRandomNumber();
		OrgznInfoPage OIP = new OrgznInfoPage(driver);
		OIP.getCreateorgnsimg().click();
		OIP.getClickingorgnbox().click();
		
		OrgznCreatePage Ocp = new OrgznCreatePage(driver);

		Ocp.OrgCreatdd(organiname, "Construction", "Customer", "Active");
		Ocp.getSavecontactbtn();

		// refresh the page
		Thread.sleep(3000);
		driver.navigate().refresh();

		// again clicking the Organization
		hp.getOrgnslink().click();

		OIP.searchForOrg(organiname, "Organization Name");

		// refresh the page
		Thread.sleep(3000);
		driver.navigate().refresh();

		// again clicking the Organization
		OIP.getCreateorgnsimg().click();

		OIP.getSearchfororgnsfld();

		// Validation the Create Organization
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
	}
	
	

}
