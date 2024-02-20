package com.orgName.genericUtility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.appName.objectRepository.HomePage;
import com.appName.objectRepository.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.eCommerce.objectRepository.Admin_HomePage;
import com.eCommerce.objectRepository.Admin_LogIn_Page;
import com.eCommerce.objectRepository.Home_Page;
import com.eCommerce.objectRepository.Login_Page;

/**
 * This class contains implementation of all basic configuration annotations
 * @author MOHAN GOWDA
 * It is a base Class of all the classes
 */
public class MainClass {

	private static String username;
	private static String password;
	protected Admin_LogIn_Page adminLoginPage;
	protected Admin_HomePage adminHomePage;
	private ExtentReports report;
	private ExtentTest test;
	
	@BeforeTest
	public void testSetUp() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentReport.html");
		spark.config().setDocumentTitle("DocumentTitle");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReportName");
	
	
	report=new ExtentReports();
	
		report.attachReporter(spark);
		
		report.setSystemInfo("Envirnoment", "Testing Envirnoment");
		report.setSystemInfo("Reporter Name", "MOHAN GOWDA");
		report.setSystemInfo("Platform", "Windows 10");
		report.setSystemInfo("Unit testing tool", "TESTNG");
		report.setSystemInfo("Build Management Tool", "Maven");
		report.setSystemInfo("Automation Tool", "Selenium");
		test = report.createTest("GLOBAL INTIALLIZATION");
		UtilityClass.setTest(test); 
	}
	
	
	/**
	 * In this annotation we fetch the common data from the property file 
	 * create the instance for all generic utility
	 * launch browser
	 * do the browser setting (maximize, implicit wait, action class initialization, explicit wait instance initialization)
	 * create the instance for common object repository class
	 * @throws IOException 
	 */

	@BeforeClass(groups = "baseclass")
	public void beforeClass1Test(/*String browser*/) throws IOException {
		UtilityClass.setExcelLibrary(new ExcelLibrary());
		UtilityClass.setJavaLibrary(new JavaLibrary());
		UtilityClass.setSeleniumActions(new SeleniumActions());

		ExcelLibrary ExcelLibrary = UtilityClass.getExcelLibrary();
		JavaLibrary JavaLibrary=UtilityClass.getJavaLibrary();
		SeleniumActions SeleniumActions= UtilityClass.getSeleniumActions();
		//intiallize the Excel file and Property file
		ExcelLibrary.openExcel(FilePath.EXCELFILEPATH);
		//read the data from propery file
		Map<String, String> commonData = UtilityClass.getExcelLibrary().getCommonData();
		String url = commonData.get("url");
		String timeout = commonData.get("timeout");
		username = commonData.get("userName");
		password = commonData.get("password");
		String browser = commonData.get("browser");
		UtilityClass.setTimeout(JavaLibrary.stringToLong(timeout));
		UtilityClass.setRandomNumber(JavaLibrary.getRandomNumber(1000));
		SeleniumActions.launchBrowser(browser);

		//navigate to the application
		SeleniumActions.navigateApp(url);
		//browser settings(maximize, implicit wait, action class initialization, explicit wait instance initialization)
		SeleniumActions.maximizeBrowser();
		SeleniumActions.waitTillPageLoad(UtilityClass.getTimeout());
		SeleniumActions.intiallizeActions(UtilityClass.getDriver());
		SeleniumActions.explicitlyWait(UtilityClass.getTimeout());

		//create the instance for common object repository class
		adminLoginPage = new Admin_LogIn_Page();
		adminHomePage = new Admin_HomePage();

	}



	/**
	 * In this annotation we will do login action
	 * @throws IOException 
	 */
	@BeforeMethod(groups = "baseclass")
	public void beforeMethod1Test(Method mtd) {
		 test = report.createTest(mtd.getName());
		 UtilityClass.setTest(test);
		//open database if it is required
		 String usernameAdmin = UtilityClass.getExcelLibrary().getData("adminCommonData", 1, 1);
		 String password = UtilityClass.getExcelLibrary().getData("adminCommonData", 2, 1);
		 adminLoginPage.loginAsAdmin(usernameAdmin, password);
	}

	/**
	 * In this annotation we will do signout action
	 */

	@AfterMethod(groups = "baseclass")
	public void afterMethod1Test(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS, result.getMethod().getMethodName()+" is pass");
         }
         else if(result.getStatus() == ITestResult.FAILURE){

     		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
     		test.log(Status.FAIL, result.getThrowable());
     		
     		
     		try {
     			test.addScreenCaptureFromPath(UtilityClass.getSeleniumActions()
     					.takeScreenShot(result.getMethod().getMethodName(), 
     					UtilityClass.getJavaLibrary()));
     		} catch (IOException e) {
     			e.printStackTrace();
     		}
     		}
         else if(result.getStatus() == ITestResult.SKIP ){
        	 test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
     		test.log(Status.SKIP, result.getThrowable());
     	}
		//signout action
		//homePage.signout();
		UtilityClass.getExcelLibrary().saveExcelData(FilePath.EXCELFILEPATH);


	}

	/**
	 * In this annotation we will close the browser instance
	 */
	@AfterClass(groups = "baseclass")
	public void afterCass1Test() {

		UtilityClass.getSeleniumActions().quitBrowser();


	}

	/**
	 * In this annotation close database
	 * close excel sheet
	 * save excel data
	 */
	@AfterSuite(groups = "baseclass")
	public void aftersuite1Test() {
		//close database connection code
		UtilityClass.getExcelLibrary().closeExcel();
		report.flush();
	}
}
