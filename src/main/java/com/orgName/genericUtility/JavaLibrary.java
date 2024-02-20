 package com.orgName.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * This class contains only java specific reusable methods
 * @author MOHAN GOWDA

 * This file is edited by mohan

 * This file edited by sanjay

 */
public class JavaLibrary {

	/**
	 * This method is used to Convert String value to long datatype
	 * @param value
	 * @return
	 */
	public   long stringToLong(String value) {
		long longData = Long.parseLong(value);
		UtilityClass.getTest().info("String data Changed to Long DataType");
		return longData;
	}
	
	/**
	 * This method is used to get the random Number
	 * @param limit
	 * @return
	 */
	public   int getRandomNumber(int limit) {
		 int ran = new Random().nextInt(limit);
		 UtilityClass.getTest().info("Random Number Generated Successfully");
		return ran;
	}
	
	/**
	 * This method is used to print the message
	 * @param message
	 */
	public  void printInConsole(String message) {
		System.out.println(message);
	}
	
	
	/**
	 * This method is used to wait untill element clickable
	 * @param element
	 * @param polingTime
	 * @param duration
	 * @throws InterruptedException
	 */
	public  void customWait(WebElement element, long polingTime, int duration) throws InterruptedException {
		int count=0;
		while(count<=duration) {
			try {
			element.click();
			break;
			}
			catch(Exception e) {
				Thread.sleep(polingTime);
				count++;
			}
		}
	}
	
	/**
	 * This method is used to fetch 
	 * @return
	 */
	public   String getDateTimeInFormat() {
		String currentDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
		UtilityClass.getTest().info("Current Date is Fetched SuccessFully");
		return currentDate;
	}
}
