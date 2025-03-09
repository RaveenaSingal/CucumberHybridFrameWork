package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private CommonUtils commonutils;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		driver =DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage =homepage.selectLoginOption();//return karega login page
		
	}

	@When("User enter valid email address {string} into email field")
	public void user_enter_valid_email_address(String emailText) {
		
		loginpage.enterEmailAddress(emailText);;
	} 

	@And("Enter valid password {string} into password field")
	public void enter_valid_password(String passwordText) {
		
		loginpage.enterPassword(passwordText);
	}

	@And("Click on login button")
	public void click_on_login_button() {
		
		accountpage = loginpage.clickOnLoginButton();
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
		
    accountpage = new AccountPage(driver);
	Assert.assertTrue(accountpage.displayStatusOfEditYourAccountInformationOption());

	}

	 @When("User enter invalid email address")
	  public void user_enter_invalid_email_address() {
		 
		commonutils = new CommonUtils();
		loginpage.enterEmailAddress(commonutils.getEmailWithTimeStamp());
       //driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
	    }

	@When("Enter invalid password {string}")
	public void enter_invalid_password(String invalidPasswordText) {
		
		loginpage.enterPassword(invalidPasswordText);
     	}

	@Then("User get a proper warning message")
	public void user_get_a_proper_warning_message() {
		Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@When("User dont enter any credentials in email address field")
	public void user_dont_enter_any_credentials_in_email_address_field() {
		
		
		loginpage.enterEmailAddress("");
		
	}

	@When("User dont eneter any credentials in password field")
	public void User_dont_eneter_any_credentials_in_password_field() {
		
		loginpage.enterPassword("");
		
	}
	

}
