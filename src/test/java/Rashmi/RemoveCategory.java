package Rashmi;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.eCommerce.objectRepository.AdminSignInPage;

public class RemoveCategory {
	@Test
	public void removeCategory() throws Throwable
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
		
		/*Click on the "X" icon under Manage categories(Action)*/
		driver.findElement(By.xpath("//td[@class=' ']/a/i[@class='icon-remove-sign']")).click();
		
		/*Click on "OK" from the confirmation POP-UP*/
		driver.getWindowHandles();
		driver.switchTo().alert().accept();
		
		/*Verify the message "Oh snap! Category deleted !!" should be displayed*/
		String text = driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();
		
		/*Verifying the message*/
		if(text.contains("Category Updated"))
			System.out.println("Category removed succesfully");
		else
			System.out.println("Category not removed");
	}
}
