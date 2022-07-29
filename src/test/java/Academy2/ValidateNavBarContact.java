package Academy2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavBarContact extends base {
	
	public WebDriver driver;
	
	@BeforeTest
	public void initializer() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@SuppressWarnings("deprecation")
	@Test()
	public void basePageNavigation() throws IOException {
		
		//we can access functions in 2 ways
		///by Inheritance
		//creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		//compare the text  from browser with actual text- and send error if it fails
		
		Assert.assertTrue(l.getNavBarContact().isDisplayed());
		//Assert.assertFalse(false);
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
