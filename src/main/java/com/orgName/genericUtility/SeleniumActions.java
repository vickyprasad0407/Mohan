package com.orgName.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This is class is used to maintain all webdriver common actions 
 * @author MOHAN GOWDA
 *
 */
public final class SeleniumActions {
	private WebDriverWait wait;
	private Actions act;
	private WebDriver driver;
	private Select select;
	private JavascriptExecutor js;

	/*
	 * This method is used to initialize and launch the browser
	 * @param browser
	 */
	public void launchBrowser(String browser) {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory",  System.getProperty("user.dir")+ File.separator + "externalFiles" + File.separator + "downloadFiles");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);


		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			UtilityClass.setDriver(new ChromeDriver(options));
			UtilityClass.getTest().info("Chrome Driver Launced SuccessFully");
			break;
		case "firefox":
			UtilityClass.setDriver(WebDriverManager.firefoxdriver().create());
			UtilityClass.getTest().info("FireFox Driver Launced SuccessFully");
			break;
		case "edge":
			UtilityClass.setDriver(WebDriverManager.edgedriver().create());
			UtilityClass.getTest().info("Edge Driver Launced SuccessFully");
			break;
		case "ie":
			UtilityClass.getTest().info("Internet Explorer Driver Launced SuccessFully");
			UtilityClass.setDriver(WebDriverManager.iedriver().create());
			break;
		default:
			UtilityClass.getTest().info("please specify proper browser key");
			WebDriverManager.chromedriver().setup();
			UtilityClass.getTest().info("Chrome Driver Launced SuccessFully");
			UtilityClass.setDriver(new ChromeDriver(options));
			break;
		}
		driver=UtilityClass.getDriver();
	}

	/**
	 * This method is used to navigate to the application
	 * @param url
	 */
	public  void navigateApp(String url) {
		driver.get(url);
		UtilityClass.getTest().info("Application Navigated SuccessFully");
	}

	/**
	 * This method is used to return/fetch the title of the webpage
	 * @param driver
	 * @return
	 */
	public  String getTitle() {
		String title = driver.getTitle();
		UtilityClass.getTest().info("Title of the WebPage SuccessFully");
		return title;
	}



	/**
	 * This method is used to maximize the browser
	 * 
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
		UtilityClass.getTest().info("Browser Maximized Successfully");
	}

	/**
	 * This method is used to implicitly wait till page Load
	 * @param longTimeOut
	 */
	public  void waitTillPageLoad(long longTimeOut) {
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		UtilityClass.getTest().info("Implicit wait Applied");
	}

	/**
	 * This method is used to intiallize the actions class variable
	 * @param driver
	 */
	public  void intiallizeActions(WebDriver driver) {
		act=new Actions(driver);
		UtilityClass.getTest().info("Actions class intiallized");
	}

	/**
	 * This method is used to mouse hover on the element
	 * @param moreLink
	 */
	public  void mouseHoverOntheElement(WebElement moreLink) {
		act.moveToElement(moreLink).perform();
		UtilityClass.getTest().info("Mouse Hover Action is Performed on the Element");
	}

	/**
	 * Perform double click action on  webelement
	 * @param moreLink
	 */
	public  void doubleClick(WebElement moreLink) {
		act.doubleClick(moreLink).perform();
		UtilityClass.getTest().info("Double Click Action is Performed Succefully");
	}

	/**
	 * Perform double click action on  webpage
	 */
	public  void doubleClick() {
		act.doubleClick().perform();
		UtilityClass.getTest().info("Double Click Action is Performed Succefully");
	}


	/**
	 * This method is used to close the browser instance
	 * @param driver
	 */
	public void quitBrowser() {
		driver.quit();
		UtilityClass.getTest().info("Browser Closed Succefully");
	}

	/**
	 * This method is used to wait the control till the particular element is clickable
	 * @param driver
	 * @param timeOut
	 * @param element
	 */
	public  void waitUntillElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		UtilityClass.getTest().info("Controller waiting till the element to be clickable");
	}


	/**
	 * This method is used to wait the control till the particular element is visible
	 * @param driver
	 * @param timeOut
	 * @param element
	 */
	public  void waitUntillElementVisible( WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		UtilityClass.getTest().info("Controller waiting till the element visible");
	}

	/**
	 * This method is used to intiallize wait instance
	 * @param driver
	 * @param timeOut
	 */
	public  void explicitlyWait(long timeOut) {
		wait=new WebDriverWait(driver, timeOut);
		UtilityClass.getTest().info("Explicit wait is intiallized");
	}

	/**
	 * This method is used to switch the window based on title
	 * @param driver
	 * @param partialText
	 */
	public  void switchToWindowBasedOnTitle(String partialText) {
		Set<String> sessionIDs = driver.getWindowHandles();
		for(String id:sessionIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				UtilityClass.getTest().info("Window Switched Successfully Based on title");
				break;
			}

		}
	}

	/**
	 * This method is used to handle dropdown by value
	 * @param element
	 * @param value
	 */
	public  void selectDropDown(WebElement element, String value) {
		select=new Select(element);
		select.selectByValue(value);
		UtilityClass.getTest().info("Dropdown selected based on the value");
	}

	/**
	 * This method is used to handle dropdown by index
	 * @param element
	 * @param index
	 */
	public  void selectDropDown(WebElement element, int index) {
		select=new Select(element);
		select.selectByIndex(index);
		UtilityClass.getTest().info("Dropdown selected based on the index");
	}

	/**
	 * This method is used to handle dropdown by visible text
	 * @param visibleText
	 * @param element
	 */
	public  void selectDropDown(String visibleText, WebElement element) {
		select=new Select(element);
		select.selectByVisibleText(visibleText);
		UtilityClass.getTest().info("Dropdown selected based on the visible text");
	}

	/**
	 * This method is used to switch the frame by index
	 * @param driver
	 * @param index
	 */
	public  void swithToFrame( int index) {
		driver.switchTo().frame(index);
		UtilityClass.getTest().info("Frame Switched Successfully based on the index");
	}

	/**
	 * This method is used to switch the frame by nameOrId
	 * @param driver
	 * @param nameOrId
	 */
	public void swithToFrame( String nameOrId) {
		driver.switchTo().frame(nameOrId);
		UtilityClass.getTest().info("Frame Switched Successfully based on the name/id");
	}

	/**
	 * This method is used to switch the frame by frame Element
	 * @param driver
	 * @param element
	 */
	public  void swithToFrame(WebElement element) {
		driver.switchTo().frame(element);
		UtilityClass.getTest().info("Frame Switched Successfully based on the element address");
	}

	/**
	 * This method is used to switch Back to main Web page
	 * @param driver
	 */
	public void swithBackToHomeWebPage() {
		driver.switchTo().defaultContent();
		UtilityClass.getTest().info("Frame Switch back to the parent web page Successfully");
	}

	/**
	 * This method is used to intiallize the javascriptexecutor interface variable
	 * @param driver
	 */
	public void intiallizeJs() {
		js=(JavascriptExecutor) driver;
		UtilityClass.getTest().info("Java Script Executor Intiallization successfully");
	}

	/**
	 * This method is used to enter the data inside the textfield through the javascript executor
	 * @param element
	 * @param data
	 */
	public void enterDataThroughJs( WebElement element, String data) {
		js.executeScript("arguments[0].value=arguments[1]", element, data);
		UtilityClass.getTest().info("Data entered into the element Successfully through JavaScript Executor");
	}

	/**
	 * This method is used to click on the element through javascript excecutor
	 * @param element
	 */
	public void clickThroughJs( WebElement element) {
		js.executeScript("arguments[0].click()", element);
		UtilityClass.getTest().info("Element clicked Successfully through JavaScript Executor");
	}

	/**
	 * This method is used to navigate the application through the javascript
	 * @param url
	 */
	public void navigateApplicationThroughJs(String url) {
		js.executeScript("window.location=arguments[0]", url);
		UtilityClass.getTest().info("Application Navigated Successfully through JavaScript Executor");
	}

	/**
	 * This method is used to scroll the webpage till specified height
	 * @param height
	 */
	public  void scroolToSpecifiedHeight(String height) {
		js.executeScript("window.scrollBy(0,"+height+")");
		UtilityClass.getTest().info("WebPage Scrolled till the specified height");
	}

	/**
	 * This method is used to scroll till the bottom of the page
	 */
	public void scroolToBottom() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		UtilityClass.getTest().info("WebPage Scrolled till the end of page");
	}

	/**
	 * This method is used to scroll till the element is alligned to top
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()",element);
		UtilityClass.getTest().info("WebPage Scrolled till the element visible");
	}


	/**
	 * This method is used to take the screen shot
	 * @param fileName
	 * @param driver
	 * @return 
	 * @throws IOException
	 */
	public String takeScreenShot(String fileName, JavaLibrary jutil) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/"+fileName+"_"+jutil.getDateTimeInFormat()+".png");
		FileUtils.copyFile(src, dst);
		UtilityClass.getTest().info("ScreenShot taken Successfully");
		return dst.getAbsolutePath();
	}

	/**
	 * This method is used to accept the alert popup
	 * @param driver
	 */
	public void alertAccept() {
		driver.switchTo().alert().accept();
		UtilityClass.getTest().info("Accept the Alert Popup Successfully");
	}

	/**
	 * This method is used to dismiss/close the alert popup
	 * @param driver
	 */
	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
		UtilityClass.getTest().info("Dismiss the Alert Popup Successfully");
	}

	/**
	 * This method is used to send the data to the alert popup
	 * @param driver
	 */
	public void alertsendData(String data) {
		driver.switchTo().alert().sendKeys(data);
		UtilityClass.getTest().info("Send the Data to the Alert Popup Successfully");
	}

	/**
	 * This method is used to get/fetch the text from the alert popup
	 * @param driver
	 */
	public String getalertText() {
		String data = driver.switchTo().alert().getText();
		UtilityClass.getTest().info("Fetch the Data from the Alert Popup Successfully");
		return data;
	}

	/**
	 * This method is used to perform right click action on webpage
	 * @param driver
	 */
	public  void rightClick() {
		act.contextClick().perform();
	}
	/**
	 * This method is used to perform right click action on element
	 * @param driver
	 */
	public  void rightClick(WebElement element) {
		act.contextClick(element).perform();
	}

}
