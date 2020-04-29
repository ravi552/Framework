package com.automation.testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;

public class LoginTestCRM extends BaseClass{
	
	
	@Test(priority=1)
	public void loginApp() {
		logger=report.createTest("Login to CRM");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("starting application");
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		logger.pass("Login done successfully");
		Helper.captureScreenShot(driver);

	}
	@Test(priority=2)
	public void loginApp1() {
		logger=report.createTest("Logout");
		logger.pass("Logout failed");
	}

}
