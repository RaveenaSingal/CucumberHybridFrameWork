package stepdefinitions;

import java.sql.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	private RegisterPage registerpage;
	private AccountSuccessPage accountsuccesspage;
	private CommonUtils commonutils;
	
	
	@Given("User navigate to Register Account page")
	public void user_navigate_to_register_account_page() {
		
		
		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage = homepage.selectRegisterOption();
		
	   
	}

	@When("User enters the details into the below fields")
	public void user_enters_the_details_into_the_below_fields(DataTable dataTable) {
		
	    Map<String, String> datamap = dataTable.asMap(String.class, String.class);
	    registerpage.enterFirstName(datamap.get("firstName"));
	    registerpage.enterLastName(datamap.get("lastName"));
	    commonutils = new CommonUtils();
	    registerpage.enterEmailAdress(commonutils.getEmailWithTimeStamp());
	    registerpage.enterTelephoneNumber(datamap.get("phoneNumber"));
	    registerpage.enterPassword(datamap.get("password"));
	    registerpage.enterConfirmPassword(datamap.get("password"));
	    
	}
	
	@When("User enters the details into the below fields with duplicate email")
	public void User_enters_the_details_into_the_below_fields_with_duplicate_email(DataTable dataTable) {
		
		Map<String, String> datamap = dataTable.asMap(String.class, String.class);
	    registerpage.enterFirstName(datamap.get("firstName"));
	    registerpage.enterLastName(datamap.get("lastName"));
	    registerpage.enterEmailAdress(datamap.get("email"));
	    registerpage.enterTelephoneNumber(datamap.get("phoneNumber"));
	    registerpage.enterPassword(datamap.get("password"));
	    registerpage.enterConfirmPassword(datamap.get("password"));	   
	}
	

	@When("User selects Privacy policy field")
	public void user_selects_privacy_policy_field() {
		
		registerpage.selectPrivacyPolicy();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		accountsuccesspage = registerpage.clickOnContinueButton();
		
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
	   Assert.assertEquals("Your Account Has Been Created!",accountsuccesspage.getPageHeading());
		
	}
	
	/*@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	    Assert.assertEquals(accountsuccesspage.getPageHeading());
	}*/

	@When("User select Yes for Newsletter")
	public void user_select_yes_for_newsletter() {
		
		registerpage.selectNewSletterOption();	
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	    
	}

	@When("User dont enter any details into any field")
	public void user_dont_enter_any_details_into_any_field() {
		//Intentionaly kept blank
	    
	}

	@Then("User should get a proper Warning messages for all the mandatory fields")
	public void user_should_get_a_proper_warning_messages_for_all_the_mandatory_fields() {
	    Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
        Assert.assertTrue(registerpage.getFirstNameWarning().contains("First Name must be between 1 and 32 characters!"));
	    Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getLastNameWarning());
	    Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getEmailWarning());
	    Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.getTelephoneWarning());
	    Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getPasswordWarning());
	   
	}
	
	

	

   }



