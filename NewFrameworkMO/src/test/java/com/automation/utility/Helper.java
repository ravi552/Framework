package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	//screenshot,alert,frames,window,sync issue, javscript executor
	public static String captureScreenShot(WebDriver driver) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath = System.getProperty("user.dir")+"/ScreenShots/FreeCRM_"+getCurrentDateTime()+".png";
		try {
			File destination = new File(screenShotPath);
			FileUtils.copyFile(file, destination);
			System.out.println("screenshot captured");
		} catch (IOException e) {
			System.out.println("unable to capture screenshot >>"+e.getMessage());
		}
		return screenShotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date cdate = new Date();
		return customformat.format(cdate);
	}
	
}
