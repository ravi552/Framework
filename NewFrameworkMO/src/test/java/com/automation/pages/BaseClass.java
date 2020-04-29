 package com.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		 
		Reporter.log("setting up report and test started", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/FreeCRM"+Helper.getCurrentDateTime()+".html");
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("settings done- test can be started", true);
	}
	
	@BeforeClass
	public void setUp() {
		Reporter.log("trying to start browser and application ready", true);
		driver=BrowserFactory.startBrowser(driver,config.getBrowser(),config.getStagingUrl());
		Reporter.log("browser and application ready", true);
	}
	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BrowserFactory.quitBrowser(driver); 
	}
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {
		Reporter.log("test is about to end", true);
		if(result.getStatus()==ITestResult.FAILURE) {
			//Helper.captureScreenShot(driver);
			logger.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}else if(result.getStatus()==ITestResult.SUCCESS){
			logger.pass("test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
	
		}
//		else if(result.getStatus()==ITestResult.SKIP) {
//			
//		}
		
		report.flush();	
		Reporter.log("test completed >> reports generated", true);
	}
}
