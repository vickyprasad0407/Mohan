package com.eCommerce.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAccountPage {
	WebDriver driver;
	
	@FindBy(id="fullname")
	private WebElement fullNameTF;
	
	@FindBy(name="emailid")
	private WebElement mailTF;
	
	@FindBy(id="contactno")
	private WebElement contactNoTF;
	
	@FindBy(id="password")
	private WebElement passwordTF;
	
	@FindBy(id="confirmpassword")
	private WebElement confirmPasswordTF;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitBtn;

	
	public CreateNewAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getFullNameTF() {				/*getters*/
		return fullNameTF;
	}

	public WebElement getMailTF() {
		return mailTF;
	}

	public WebElement getContactNoTF() {
		return contactNoTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getConfirmPasswordTF() {
		return confirmPasswordTF;
	}
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public  void CreateNewAccount(String name, String mail, String contactNo, String password, String confirmPw) {		/*business library*/
		fullNameTF.sendKeys(name);
		mailTF.sendKeys(mail);
		contactNoTF.sendKeys(contactNo);
		passwordTF.sendKeys(password);
		confirmPasswordTF.sendKeys(confirmPw);
		submitBtn.click();
	}
}
