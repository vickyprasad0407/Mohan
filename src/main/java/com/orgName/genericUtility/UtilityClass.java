package com.orgName.genericUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClass {

	private static ThreadLocal<ExtentTest> testTL=new ThreadLocal<>();
	private static ThreadLocal<WebDriver> driverTL=new ThreadLocal<>();
	private static ThreadLocal<ExcelLibrary> ExcelLibraryTL=new ThreadLocal<>();
	private static ThreadLocal<JavaLibrary> JavaLibraryTL=new ThreadLocal<>();
	private static ThreadLocal<SeleniumActions> SeleniumActionsTL=new ThreadLocal<>();
	private static ThreadLocal<Integer> randomNumberTL=new ThreadLocal<>();
	private static ThreadLocal<Long> timeoutTL=new ThreadLocal<>();


	public static ExtentTest getTest() {
		return testTL.get();
	}
	public static WebDriver getDriver() {
		return driverTL.get();
	}

	public static ExcelLibrary getExcelLibrary() {
		return ExcelLibraryTL.get();
	}
	public static JavaLibrary getJavaLibrary() {
		return JavaLibraryTL.get();
	}
	public static SeleniumActions getSeleniumActions() {
		return SeleniumActionsTL.get();
	}
	public static int getRandomNumber() {
		return randomNumberTL.get();
	}
	public static long getTimeout() {
		return timeoutTL.get();
	}

	public static void setDriver(WebDriver driver) {
		driverTL.set(driver);
	}
	public static void setExcelLibrary(ExcelLibrary ExcelLibrary) {
		ExcelLibraryTL.set(ExcelLibrary);
	}
	public static void setJavaLibrary(JavaLibrary JavaLibrary) {
		JavaLibraryTL.set(JavaLibrary);
	}
	public static void setSeleniumActions(SeleniumActions SeleniumActions) {
		SeleniumActionsTL.set(SeleniumActions);
	}


	public static void setTest(ExtentTest test) {
		testTL.set(test);
	}

	public static void setRandomNumber(int randomNumber) {
		randomNumberTL.set(randomNumber);
	}

	public static void setTimeout(long timeout) {
		timeoutTL.set(timeout);
	}
}
