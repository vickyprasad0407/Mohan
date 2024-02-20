package com.appName.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgName.genericUtility.UtilityClass;

public class OrganizationsPage {
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationLookUpImg;
	
	@FindBy(className ="hdrLink")
	private WebElement OrganizationHeaderLink;
	
	public OrganizationsPage() {
		PageFactory.initElements(UtilityClass.getDriver(), this);
	}
	
	public void clickCreateOrganizationLookUpImg() {
		createOrganizationLookUpImg.click();
	}
	
	public void clickOrganizationHeaderLink() {
		OrganizationHeaderLink.click();
	}
}
