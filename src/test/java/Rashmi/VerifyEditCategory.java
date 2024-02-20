package Rashmi;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.eCommerce.objectRepository.AdminSignInPage;

public class VerifyEditCategory {
	@Test
	public void EditCategory() throws Throwable
	{
		/*Launches the browser*/
		WebDriver driver = new ChromeDriver();
		/*Maximizes the screen*/
		driver.manage().window().maximize();	
		/*implicitly waits for 10 seconds*/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*fetches the WebPage*/
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");  
		Thread.sleep(2000);
		
		AdminSignInPage sign = new AdminSignInPage();
		/*Enters the username and password and clicks on SignIn button*/
		sign.AdminSignIn("admin", "Test@123");
		
		/*Clicks on Create Category Link*/
		driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
		
		/*Clicks on the Edit icon under Manage categories(Action)*/
		driver.findElement(By.xpath("//td[@class=' ']/a/i[@class='icon-edit']")).click();
		
		/*Updates the Category Name*/
		WebElement name = driver.findElement(By.xpath("//input[@name='category']"));
		
		/*clears the text field and enters Apple iPhone*/
		name.clear();
		name.sendKeys("Apple iPhone");
		
		/*Clicks on "Update" Button*/
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		/*Fetching the message after update*/
		String text = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		
		/*Verifying the message*/
		if(text.contains("Category Updated"))
			System.out.println("Edit Category is verified succesfully");
		else
			System.out.println("Edit Category is unsuccesful");
	}
}
