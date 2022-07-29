package Academy2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;

@SuppressWarnings("deprecation")
public class ValidateTitle extends base {
	
	public WebDriver driver;
	
	LandingPage l;
	
	@BeforeTest
	public void initializer() throws IOException
	{
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");
	}
	
	@Test()
	public void validateAppTitle() throws IOException {
		
		//we can access functions in 2 ways
		///by Inheritance
		//creating object to that class and invoke methods of it
		l = new LandingPage(driver);
		//compare the text  from browser with actual text- and send error if it fails
		Assert.assertEquals(l.getTitle().getText(), "FEATURED CO123URSES");
		System.out.println("Test Completed");
			
	}
	
	@Test
	public void validatePageHeader() throws IOException {
		Assert.assertEquals(l.getPageHearder().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
