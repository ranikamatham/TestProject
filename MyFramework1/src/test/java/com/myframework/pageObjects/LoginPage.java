package com.myframework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// here we will have only page objects not any logic

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "/html/body/header/div/div[2]/div/ul[2]/li/a\r\n" + "")
	WebElement btnLogin;
	
	@FindBy(xpath = "//*[@id=\"inputEmail\"]\r\n" + 
			"")
	WebElement txtUserName;

	@FindBy(xpath = "//*[@id=\"inputPassword\"]")
	WebElement txtPassWord;

	/*@FindBy(xpath = "//*[@id=\"recaptcha-anchor-label\"]")
	WebElement recap;*/

	@FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")
	WebElement checkBox;

	@FindBy(xpath = "//*[@id=\"login\"]\r\n" + "")
	WebElement btnSIGN;
	
	public void clickSubmit()

	{
		btnLogin.click();
		System.out.println("userrrrrrrrrr"+btnLogin.getText());
	}
	
	public void setUserName(String uname) {
		
		//txtUserName.click();
		txtUserName.sendKeys(uname);
		System.out.println("***username****"+txtUserName.getText());
		

	}

	public void setPassWord(String pwd) {
		txtPassWord.sendKeys(pwd);
	}
	
	/*public void reCaptcha() {
		recap.click();
	}*/
	
	public void check() {
		checkBox.click();
	}
	
	public void clickLogin()

	{
		btnSIGN.click();
	}
}
