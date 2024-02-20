package com.eCommerce.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orgName.genericUtility.UtilityClass;

public class Insert_Product_Page {

	
	@FindBy (name = "category")
	private WebElement categoryDD;
	
	@FindBy (name = "subcategory")
	private WebElement subCategoryDD;
	
	@FindBy (name = "productName")
	private WebElement productNameTF;
	
	@FindBy (name ="productCompany")
	private WebElement productCompanyTF;
	
	@FindBy (name = "productpricebd")
	private WebElement productPriceBeforeDiscountTF;
	
	@FindBy (name = "productprice")
	private WebElement productPriceAfterDiscountTF;
	
	@FindBy (name = "productDescription")
	private WebElement productDescriptionTA;
	
	@FindBy (name = "productShippingcharge")
	private WebElement productShippingChargeTF;
	
	@FindBy (name = "productAvailability")
	private WebElement productAvailabilityDD;
	
	@FindBy (xpath = "//label[.='Product Image1']/parent::div/descendant::input[@type='file']")
	private WebElement productimage1Link;
	
	@FindBy (xpath = "//label[.='Product Image2']/parent::div/descendant::input[@type='file']")
	private WebElement productimage2Link;
	
	@FindBy (xpath = "//label[.='Product Image3']/parent::div/descendant::input[@type='file']")
	private WebElement productimage3Link;
	
	@FindBy (name = "submit")
	private WebElement insertButton;
	
	@FindBy (xpath = "//div/strong")
	private WebElement insertConfirmationMessage;
	
	public Insert_Product_Page( ) {
		PageFactory.initElements(UtilityClass.getDriver(), this);
	}
	
	public void insertProduct(int categoryNaameindex, int subCategoryNameindex, String productName,
			                  String productCompany, String ProductPriceBD, String productPriceAfterDiscount,
			                  String productDescription, String productShippingCharge, String productAvailability) {
		UtilityClass.getSeleniumActions().selectDropDown(categoryDD, categoryNaameindex);
		UtilityClass.getSeleniumActions().selectDropDown(subCategoryDD, subCategoryNameindex);
		productNameTF.sendKeys(productName);
		productCompanyTF.sendKeys(productCompany);
		productPriceBeforeDiscountTF.sendKeys(ProductPriceBD);
		productPriceAfterDiscountTF.sendKeys(productPriceAfterDiscount);
		productDescriptionTA.sendKeys(productDescription);
		productShippingChargeTF.sendKeys(productShippingCharge);
		UtilityClass.getSeleniumActions().selectDropDown(productAvailabilityDD, productAvailability);
	}
	
	public void uploadImage1(String pathofImage1, String pathofImage2, String pathofImage3) {
		productimage1Link.sendKeys(pathofImage1);
		productimage2Link.sendKeys(pathofImage2);
		productimage3Link.sendKeys(pathofImage3);
	}
	public void clickOnInsert() {
		insertButton.click();
		String confirmationMessage = insertConfirmationMessage.getText();
		Assert.assertEquals(confirmationMessage, "Well done!");
		System.out.println("Product has been inserted successfully!!!");
	}
}
