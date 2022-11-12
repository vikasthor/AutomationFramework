package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WithoutFrameworkTestClass {

	
	@Test 
	
	public void test()
	{
		System.setProperty ("webdriver.chrome.driver","C:\\Automation\\Chrome106\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get ("https://ui.cogmento.com/");
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 driver.findElement(By.name("email")).sendKeys("thoratvikas1992@gmail.com");
		 driver.findElement(By.name("password")).sendKeys("Vikas@1545");
		 driver.findElement(By.xpath("//div[text()='Login']")).click();
		 driver.quit();
		 
		
	}
	
	
	
}
