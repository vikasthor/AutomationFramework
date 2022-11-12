package Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	//Screenshot,alert,frames,windows,sync issue,javaScreiptExecutor
	
	public static String captureScreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String path = System.getProperty ("user.dir")+"/Screenshots/vikas_"+getCurrentDateTime()+".png";
		
		System.out.println("Captured Screenshot Succesfully");
		try {
			
			FileHandler.copy(src,new File(path));
		} catch (IOException e) {
			System.out.println("Unable to capture Screenshot"+e.getMessage());
		}
		return path;
	}
	
	
	public static String getCurrentDateTime()
	{
		DateFormat customformat=new SimpleDateFormat ("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		
		return customformat.format(currentDate);
	}
}
