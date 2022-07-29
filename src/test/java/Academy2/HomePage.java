package Academy2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	public WebDriver driver;
	
	@BeforeTest
	public void initializer() throws IOException
	{
		driver = initializeDriver();
		
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {

		//we can access functions in 2 ways
		///by Inheritance
		//creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin();
		LoginPage lp = l.getLogin();//driver.findElement(By.css())
		//LoginPage lp= new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		System.out.println(text);
		
		lp.getLogin().click();
		ForgotPassword fp=lp.forgotPassword();
		fp.getEmail().sendKeys("test@email.com");
		fp.sendMeInstructions().click();
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() 
	{
		//row stands for how many diff data types test should run
		//column stands for how many values per each test
		Object[][] data = new Object[2][3];
		//0th row
		data[0][0]="restricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="restricet user";
		
		data[1][0]="nonrestricteduser@qw.com";
		data[1][1]="123456";
		data[1][2]="Nonrestricet user";
		
		return data;
		
	}
	

}
