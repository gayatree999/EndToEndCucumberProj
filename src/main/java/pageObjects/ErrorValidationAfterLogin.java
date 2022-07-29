package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorValidationAfterLogin {
	public WebDriver driver;
	
	By errorMessage = By.className("div.alert-danger");
	public ErrorValidationAfterLogin(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getErrorMsg() {
		// TODO Auto-generated method stub
		return driver.findElement(errorMessage);
		//return null;
	}
}
