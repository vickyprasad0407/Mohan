package com.appName.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgName.genericUtility.UtilityClass;
import com.orgName.genericUtility.SeleniumActions;


public class CreateNewOrganizationPage {
	
	@FindBy(name ="accountname")
	private WebElement accountnameTxt;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath ="//select[@name='industry']")
	private WebElement industryDropdown;
	
	@FindBy(xpath ="//select[@name='accounttype']")
	private WebElement typeDropdown;
	

	@FindBy(xpath ="//span[@class='lvtHeaderText']")
	private WebElement headerText;
	

	public CreateNewOrganizationPage() {
		PageFactory.initElements(UtilityClass.getDriver(), this);
		}
		
		public void createOrgnization(String oranizationName) {
			accountnameTxt.sendKeys(oranizationName);
			saveBtn.click();
		}
		
		public void createOrgnization(String oranizationName, String industryName, String typeName) {
			SeleniumActions seleniumActions = UtilityClass.getSeleniumActions();
			
			accountnameTxt.sendKeys(oranizationName);
			seleniumActions.selectDropDown(industryDropdown, industryName);
			seleniumActions.selectDropDown(typeDropdown, typeName);
			saveBtn.click();
		}
		public String getHeaderText() {
			return headerText.getText();
		}
}
