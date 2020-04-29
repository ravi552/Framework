package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver= driver;
	}
	
	@FindBy(name="email") WebElement username;
	
	@FindBy(name="password") WebElement password;
	
	@FindBy(xpath="//div[text()='Login']") WebElement btnLogin;
	
	public void loginToCRM(String userName, String Pwd) {
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			
		}
		username.sendKeys(userName);
		password.sendKeys(Pwd);
		btnLogin.click();;
	}
}
