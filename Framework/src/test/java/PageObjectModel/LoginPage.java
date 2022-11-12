package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage (WebDriver ldriver)
	{
		PageFactory.initElements(ldriver,this);
	}
	

	@FindBy (xpath="//input[@name='email']") WebElement userName;
	
	@FindBy (xpath="//input[@name='password']") WebElement password;
	
	@FindBy (xpath="//div[text()='Login']") WebElement login;
	
	
	public void logintoCRM(String uname,String pwd)
	{
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		login.click();
	}
	
	
	
	
}
