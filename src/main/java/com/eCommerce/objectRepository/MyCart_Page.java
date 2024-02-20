package com.eCommerce.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgName.genericUtility.UtilityClass;

public class MyCart_Page {

	
	@FindBy (xpath = "//table/tbody/descendant::td/h4/a")
	private List<WebElement> namesOfProducts;
	
	@FindBy (xpath = "//table/tbody/descendant::td/h4/a")
	private WebElement nameOfProduct;
	
	@FindBy (xpath = "//textarea[@name='billingaddress']")
	private WebElement billingAddressTA;
	
	@FindBy (id = "bilingstate")
	private WebElement billingStateTF;
	
	@FindBy (id = "billingcity")
	private WebElement billingCityTF;
	
	@FindBy (id = "billingpincode")
	private WebElement billingpincodeTF;
	
	@FindBy (name = "shippingaddress")
	private WebElement shippingAddressTA;
	
	@FindBy (id = "shippingstate")
	private WebElement shippingstateTF;
	
	@FindBy (id = "shippingcity")
	private WebElement shippingcityTF;
	
	@FindBy (id = "shippingpincode")
	private WebElement shippingpincodeTF;
	
	@FindBy (name = "ordersubmit")
	private WebElement proceedToCheckOutButton;
	
	
	public MyCart_Page() {
		PageFactory.initElements(UtilityClass.getDriver(), this);
	}
	
	
	public void nameOfProduct() {
		String productName = nameOfProduct.getText();
		System.out.println(productName);
		if (productName.contains(UtilityClass.getExcelLibrary().getData("CommonData", 8, 1))) {
			System.out.println("Product has been successfully added to cart and it is verified");
		} else {
			System.out.println("Test Case failed");
		}
	}
	
	public void placeOrder(String billingAddress, String billingState,String billingCity,String billingPinCode,String shippingAddress,String shippingState,String shippingCity,String shippingPincode  ) {
		billingAddressTA.sendKeys(billingAddress);
		billingStateTF.sendKeys(billingState);
		billingCityTF.sendKeys(billingCity);
		billingpincodeTF.sendKeys(billingPinCode);
		shippingAddressTA.sendKeys(shippingAddress);
		shippingstateTF.sendKeys(shippingState);
		shippingcityTF.sendKeys(shippingCity);
		shippingpincodeTF.sendKeys(shippingPincode);
		proceedToCheckOutButton.click();
	}
}
