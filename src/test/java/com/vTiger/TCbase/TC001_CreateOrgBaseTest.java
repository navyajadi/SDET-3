package com.vTiger.TCbase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.OrgznCreatePage;
import com.Vtiger.POMClasses.OrgznInfoPage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.JavaUtil;

public class TC001_CreateOrgBaseTest extends BaseClass {
	@Test(groups = "smoketesting", retryAnalyzer = com.Vtiger.genericUtil.RetryAnalyzer.class)

	public void createOrg() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.getOrgnslink().click();

		String organiname = JavaUtil.ObjforJavaUtil().getFirstName() + JavaUtil.ObjforJavaUtil().generateRandomNumber();
		OrgznInfoPage OIP = new OrgznInfoPage(driver);
		OIP.getCreateorgnsimg().click();
		OIP.getClickingorgnbox().click();

		OrgznCreatePage Ocp = new OrgznCreatePage(driver);
		Ocp.OrgCreateContact(organiname);
		Ocp.getSavecontactbtn();

		// refresh the page
		Thread.sleep(3000);
		driver.navigate().refresh();

		// again clicking the Organization
		hp.getOrgnslink().click();

		OIP.searchForOrg(organiname, "Organization Name");

		try {
			String fe = driver.findElement(By.xpath("//a[@title='Organizations' and text()='" + organiname + "']"))
					.getText();
			System.out.println(fe);

			if (fe.equalsIgnoreCase(organiname)) {
				System.out.println("Pass");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
	}

	@Test(groups = "regressiontesting", retryAnalyzer = com.Vtiger.genericUtil.RetryAnalyzer.class)
	public void createOrgPhoneNumner() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.getOrgnslink().click();
		String organiname = JavaUtil.ObjforJavaUtil().getFirstName() + JavaUtil.ObjforJavaUtil().generateRandomNumber();
		String phnmber = JavaUtil.ObjforJavaUtil().getphoneNumber();
		OrgznInfoPage OIP = new OrgznInfoPage(driver);
		OIP.getCreateorgnsimg().click();
		OIP.getClickingorgnbox().click();
		OrgznCreatePage Ocp = new OrgznCreatePage(driver);
		Ocp.OrgCreateContact(organiname);
		Ocp.PhoneNo(phnmber);
		Ocp.getSavecontactbtn();

		OIP.getCreateorgnsimg().click();
		OIP.searchForOrg(organiname, "Organization Name");

		try {
			String fe = driver.findElement(By.xpath("//a[@title='Organizations' and text()='" + organiname + "']"))
					.getText();
			System.out.println(fe);

			if (fe.equalsIgnoreCase(organiname)) {
				System.out.println("Pass");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
	}
}
