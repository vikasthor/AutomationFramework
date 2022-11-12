package PageObjectModel;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utility.BrowserFactory;
import Utility.ConfigDataProvider;
import Utility.ExcelDataProvider;
import Utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuit()
	{
		Reporter.log("Setting up Testing and Test is ready" , true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider ();
		
		File reportPath= new File("./Reports/Vikas_"+Helper.getCurrentDateTime()+".html");
		ExtentHtmlReporter extent = new ExtentHtmlReporter (reportPath);
		 report = new ExtentReports();
		 report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Setting up Browser and Test is ready" , true);
	driver = BrowserFactory.startApp(driver,config.getDataBrowser(),config.getStagingUrl());
	Reporter.log("Browser loading and Testing started" , true);
	}
	
	@AfterClass
	public void ClosedBrowser()
	{
	BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void closedMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test about to end" , true);
		if (result.getStatus()==ITestResult.FAILURE)
		{
			
			logger.fail("Test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
		
		Reporter.log("Test completed>>>>> Reoprt is Generated" , true);
	}
}
