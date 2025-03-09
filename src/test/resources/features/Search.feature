Feature: Search functionality

  Scenario: User searches for a valid product
    Given User opens the application
   When User enters valid product "HP" into the search box field 
    And User clicks on the search button
    Then User should get valid product displayed in search result

  Scenario: Search for a non-existing product
    Given User opens the application
    When User enters invalid product into the search box field "Honda"
    And User clicks on the search button
    Then User should get a message about no product matching

  Scenario: User searches without any product
    Given User opens the application
    When User doesnt enter any product name into the search box field
    And User clicks on the search button
    Then User should get a message about no product matching
