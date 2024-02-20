package com.eCommerce.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSignInPage {

WebDriver driver;
	
	@FindBy(id="inputEmail")
	private  WebElement usernameTF;
	
	@FindBy(id="inputPassword")
	private  WebElement passwordTF;
	
	@FindBy(xpath="//button[text()='Login']")
	private  WebElement loginBtn;
	
	public AdminSignInPage() {
		PageFactory.initElements(driver, this); 
	}

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void AdminSignIn(String un, String pw)
	{
		usernameTF.sendKeys(un);
		passwordTF.sendKeys(pw);
		loginBtn.click();
	}
}
