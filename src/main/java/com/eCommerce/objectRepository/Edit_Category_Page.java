package com.eCommerce.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orgName.genericUtility.UtilityClass;

public class Edit_Category_Page {

	@FindBy (name = "category")
	private WebElement categoryNameTF;
	
	@FindBy (name =  "description")
	private WebElement descriptionTA;
	
	@FindBy (xpath = "//button[@name='submit']")
	private WebElement updateButton;
	
	@FindBy (xpath = "//div[@class='module-body']/descendant::div/strong")
	private WebElement updatedMessage;
	
	public Edit_Category_Page( ) {
		PageFactory.initElements(UtilityClass.getDriver(), this);
	}
	
	public void editCategoryInfo(String categoryName, String description) {
		categoryNameTF.sendKeys(categoryName);
		descriptionTA.sendKeys(description);
		updateButton.click();
		String upadteMessage = updatedMessage.getText();
		Assert.assertEquals(upadteMessage, "Well done!");
		System.out.println("Category has been successfully updated");
	}
}
