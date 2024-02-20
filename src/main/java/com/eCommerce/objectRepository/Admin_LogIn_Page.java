package com.eCommerce.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgName.genericUtility.UtilityClass;

public class Admin_LogIn_Page {

	@FindBy (name = "username")
	private WebElement usernameTF;
	
	@FindBy (name = "password")
	private WebElement passwordTF;
	
	@FindBy (name = "submit")
	private WebElement loginButton;
	
	public Admin_LogIn_Page( ) {
		PageFactory.initElements(UtilityClass.getDriver(), this);
	}
	
	public void loginAsAdmin(String username, String password) {
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginButton.click();
	}
}
