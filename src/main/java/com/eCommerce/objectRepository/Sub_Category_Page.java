package com.eCommerce.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orgName.genericUtility.UtilityClass;

public class Sub_Category_Page {

	@FindBy (name = "category")
	private WebElement categoryDD;
	
	@FindBy (xpath = "//div/input[@name='subcategory']")
	private WebElement subCategoryTF;
	
	@FindBy (name = "submit")
	private WebElement createButton;
	
	@FindBy (xpath = "//div/strong")
	private WebElement confirmationMessage;
	
	
	public Sub_Category_Page() {
		PageFactory.initElements(UtilityClass.getDriver(), this);
	}
	
	public void createSubCategory(String subCategoryName,int index, int time) {
		UtilityClass.getSeleniumActions().selectDropDown(categoryDD, index);
		UtilityClass.getSeleniumActions().explicitlyWait(time);
		subCategoryTF.sendKeys(subCategoryName);
		createButton.click();
		String createdMessage = confirmationMessage.getText();
		Assert.assertEquals(createdMessage, "Well done!");
		System.out.println("Sub Category created successfully!!!");
	}
}
