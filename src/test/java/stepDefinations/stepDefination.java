package stepDefinations;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ErrorValidationAfterLogin;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class stepDefination extends base {

@Given("Initialise the browser with chrome")
public void initialise_the_browser_eith_chrome() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	driver = initializeDriver();
	
}

@After
public void teardown() {
	driver.quit();
}


@Given("Navigate to {string} site")
public void navigate_to_site(String stringArg1) {
    // Write code here that turns the phrase above into concrete actions
	driver.get(stringArg1);
	
}
@Given("Click on Login link in home page to land on Secure sign in Page")
public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() {
	LandingPage l = new LandingPage(driver);
	if(l.getPopupSize()>0)
	{
		l.getPopup().click();
	}
	l.getLogin();
	
}


@When("^User enters (.+) and (.+) and logs in$")
public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
	LoginPage lp= new LoginPage(driver);
	lp.getEmail().sendKeys(username);
	lp.getPassword().sendKeys(password);	
	lp.getLogin().click();
}


@Then("Verify that user is succesfully logged in")
public void verify_that_user_is_succesfully_logged_in() {
    // Write code here that turns the phrase above into concrete actions
	ErrorValidationAfterLogin p = new ErrorValidationAfterLogin(driver);
	Assert.assertTrue(p.getErrorMsg().isDisplayed());
}
	

}
