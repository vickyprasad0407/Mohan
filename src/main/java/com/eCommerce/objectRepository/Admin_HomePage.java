package com.eCommerce.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgName.genericUtility.UtilityClass;

public class Admin_HomePage {

	@FindBy (xpath = "//a[contains(.,'Create Category')]")
	private WebElement createCategoryLink;
	
	@FindBy (xpath = "//a[contains(.,'Sub Category')]")
	private WebElement subCategoryLink;
	
	@FindBy (xpath = "//a[contains(.,'Insert Product')]")
	private WebElement insertProductLink;
	
	@FindBy (xpath = "//a[contains(.,'Manage Products')]")
	private WebElement manageProductsLink;
	
	@FindBy (xpath = "//a[contains(.,'Manage users')]")
	private WebElement manageUsersLink;
	
	@FindBy (xpath = "//a[contains(.,'Order Management')]")
	private WebElement orderManagementLink;
	
	@FindBy (xpath = "//div[@class='sidebar']/descendant::a[contains(.,'Logout')]")
	private WebElement logOutOption;
	
	public Admin_HomePage( ) {
		PageFactory.initElements(UtilityClass.getDriver(), this);
	}
	
	public void clickOncreateCategoryLink() {
		createCategoryLink.click();
	}
	
	public void clickOnSubCategory() {
		subCategoryLink.click();
	}
	
	public void clickOnInsertProduct() {
		insertProductLink.click();
	}
	
}
