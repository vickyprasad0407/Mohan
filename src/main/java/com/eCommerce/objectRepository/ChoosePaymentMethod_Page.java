package com.eCommerce.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgName.genericUtility.UtilityClass;

public class ChoosePaymentMethod_Page {

	@FindBy (xpath = "//form/input[@value='COD']")
	private WebElement CashOnDeliveryRadioButton;
	
	@FindBy (xpath = "//form/input[@value='Internet Banking']")
	private WebElement internetBankingRadioButton;
	
	@FindBy (xpath = "//form/input[@value='Debit / Credit card']")
	private WebElement debitCreditCardradioButton;
	
	@FindBy (xpath = "//input[@name='submit']")
	private WebElement submitButton;
	
	@FindBy (xpath = "//table/tbody/descendant::td/a[@title='Track order']")
	private WebElement trackLink;
	
	public ChoosePaymentMethod_Page() {
		PageFactory.initElements(UtilityClass.getDriver(), this);
	}
	
	public void placeOrderUsingCOD() {
		CashOnDeliveryRadioButton.click();
		submitButton.click();
		if (trackLink.isDisplayed()) {
			System.out.println("Product has been ordered successfully");
		} else {
			System.out.println("Product has not been ordered successfully");
		}
	}
}
