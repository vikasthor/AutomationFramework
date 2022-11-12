package TestCases;

import org.testng.annotations.Test;

import PageObjectModel.BaseClass;
import PageObjectModel.LoginPage;

public class LoginTestCRM extends BaseClass {
     
	@Test (priority=1)
	public void loginApp() 
	{
		logger = report.createTest("Login to CRM");
	
		LoginPage loginpage = new LoginPage(driver);
		
		logger.info("Starting Application");
		
		loginpage.logintoCRM (excel.getStringData1("login", 0, 0),excel.getStringData1("login", 0, 1));
	     
		logger.pass("Login Successfully");
		
	}
	@Test (priority=2)
	public void logout() 
	{
		logger = report.createTest("Login to CRM");
	
		logger.fail("Logout failed");
		
	}
	
}
