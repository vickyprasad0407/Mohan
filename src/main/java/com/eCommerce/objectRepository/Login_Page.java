package com.eCommerce.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgName.genericUtility.UtilityClass;

public class Login_Page {

	@FindBy (id = "exampleInputEmail1")
	private WebElement signInEmailAddressTF;
	
	@FindBy (id = "exampleInputPassword1")
	private WebElement signInPasswordTF;
	
	@FindBy (linkText = "Forgot your Password?")
	private WebElement signInForgotPasswordLink;
	
	@FindBy (name = "login")
	private WebElement LoginButton;
	
	@FindBy (id = "fullname")
	private WebElement fullnameTFNewAccount;
	
	@FindBy(id = "email" )
	private WebElement emailAddressTFNewAccount;
	
	@FindBy (id = "contactno")
	private WebElement contactNumberTF;
	
	@FindBy (id = "password")
	private WebElement CreateNewAccountPasswordTF;
	
	@FindBy (id = "confirmpassword")
	private WebElement CreateNewAccountConfirmPasswordTF;
	
	@FindBy (id = "submit")
	private WebElement signUPButton;
	
	public Login_Page() {
		PageFactory.initElements(UtilityClass.getDriver(), this);
	}
	
	public void signUp(String Fullname, String email, String contactNo, String Password ) {
		fullnameTFNewAccount.sendKeys(Fullname);
		emailAddressTFNewAccount.sendKeys(email);
		contactNumberTF.sendKeys(contactNo);
		CreateNewAccountPasswordTF.sendKeys(Password);
		CreateNewAccountConfirmPasswordTF.sendKeys(Password);
		signUPButton.click();
	}
	
	public void signIn(String email, String password) {
		signInEmailAddressTF.sendKeys(email);
		signInPasswordTF.sendKeys(password);
		LoginButton.click();
	}
}
