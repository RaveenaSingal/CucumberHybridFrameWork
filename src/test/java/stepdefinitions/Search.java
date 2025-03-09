package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {
    WebDriver driver;
    private HomePage homepage;
    private SearchResultsPage searchresultspage ;
    
    
    @Given("User opens the application")
    public void user_opens_the_application() {
    	
    	
        driver = DriverFactory.getDriver();
    }
    
    @When("User enters valid product {string} into the search box field")
    public void user_enters_valid_product_into_the_search_box_field(String validProductText) {
       
        homepage = new HomePage(driver);
    	homepage.enterProductIntoSearchBox(validProductText);
    	
        System.out.println("Entering product: " + validProductText);
    }

    @When("User clicks on the search button")
    public void user_clicks_on_the_search_button() {
    	
    	searchresultspage = homepage.clickOnSearchButton();
          }

    @Then("User should get valid product displayed in search result")
    public void user_should_get_valid_product_displayed_in_search_result() {
    	
    	SearchResultsPage searchresultspage = new SearchResultsPage(driver);
        Assert.assertTrue(searchresultspage.displayStatusOfValidProduct());
        //Assert.fail();
    }

    // Step for entering invalid product (parameterized)
    @When("User enters invalid product into the search box field {string}")
    public void user_enters_invalid_product_into_the_search_box_field(String invalidProductText) {
    	
    	homepage= new HomePage(driver);
    	homepage.enterProductIntoSearchBox(invalidProductText);
        
    }

    @Then("User should get a message about no product matching")
    public void user_should_get_a_message_about_no_product_matching() {
    	
    	
        Assert.assertEquals("There is no product that matches the search criteria.",
        		searchresultspage.getMessageText());
    }

    // Step for no input in the search field
    @When("User doesnt enter any product name into the search box field")
    public void user_doesn_t_enter_any_product_name_into_the_search_box_field() {
        // Intentionally left blank as no product is entered
    	homepage = new HomePage(driver);
    }
}