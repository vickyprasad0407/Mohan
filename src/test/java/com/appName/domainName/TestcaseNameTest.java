package com.appName.domainName;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appName.objectRepository.CreateNewOrganizationPage;
import com.appName.objectRepository.OrganizationInformationPage;
import com.appName.objectRepository.OrganizationsPage;
import com.orgName.genericUtility.MainClass;
import com.orgName.genericUtility.UtilityClass;

public class TestcaseNameTest extends MainClass{

	@Test
	public void testCaseName() {
		//read all the testdata
		String orgName=UtilityClass.getExcelLibrary().getData("module1", "orgName12",getClass().getSimpleName())+UtilityClass.getRandomNumber();
	System.out.println(orgName);
		
		//create object for POM class instance
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage();
		OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage();
		OrganizationsPage organizationsPage=new OrganizationsPage();

		//homePage.clickOrganizations();
		organizationsPage.clickCreateOrganizationLookUpImg();
		createNewOrganizationPage.createOrgnization(orgName);
		Assert.assertEquals(organizationInformationPage.getorganizationName(), orgName);
		//UtilityClass.getJavaUtility().printStatement("TC PASS");
	}

}
