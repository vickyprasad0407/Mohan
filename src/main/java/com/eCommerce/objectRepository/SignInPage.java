package com.eCommerce.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage{

	WebDriver driver;
	
	@FindBy(name="email")
	private  WebElement emailTF;
	
	@FindBy(name="password")
	private  WebElement passwordTF;
	
	@FindBy(name="login")
	private  WebElement loginBtn;

	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailTF() {
		return emailTF;						/*getters*/
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}
			
	public  void signIn(String mail, String pw) {		/*business library*/
		emailTF.sendKeys(mail);
		passwordTF.sendKeys(pw);
		loginBtn.click();
	}
}
