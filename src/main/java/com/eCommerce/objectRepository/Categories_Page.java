package com.eCommerce.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orgName.genericUtility.UtilityClass;

public class Categories_Page {

	@FindBy (xpath = "//table/tbody/descendant::td[.='Jewellery']/parent::tr/child::td/a[contains(@href,'edit-category.php')]")
	private WebElement booksCategoryEdit;
	
	@FindBy (xpath = "//table/tbody/descendant::td[.='Jewellery']/parent::tr/child::td/a[contains(@href,'delete')]")
	private WebElement booksCategoryRemove;
	
	@FindBy (xpath = "//div[@class='module-body']/descendant::div/strong")
	private WebElement removedMessage;
	 
	public Categories_Page() {
		PageFactory.initElements(UtilityClass.getDriver(), this);
	}
	
	public void edit() {
		booksCategoryEdit.click();
	}
	
	public void removeCategory() {
		booksCategoryRemove.click();
		UtilityClass.getDriver().switchTo().alert().accept();
		String removeMessage = removedMessage.getText();
		Assert.assertEquals(removeMessage, "Oh snap!");
		System.out.println("Category has been removed successfully");
	}
}
