package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By NavBarContact = By.xpath("//a[contains(text(),'Contact')]");
	private By pageHeader = By.cssSelector("div[class*=video-banner] h3");
	By popup= By.xpath("//button[text()='NO THANKS']");
	
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage lp= new LoginPage(driver);
		return lp;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavBarContact() {
		System.out.println("Trying to identify navigation bar");
		return driver.findElement(NavBarContact);
	}
	
	public WebElement getPageHearder() {
		System.out.println("Page Header-");
		return driver.findElement(pageHeader);
	}
	
	public int getPopupSize() {
		return driver.findElements(popup).size();
	}
	
	public WebElement getPopup() {
		return driver.findElement(popup);
	}

}
