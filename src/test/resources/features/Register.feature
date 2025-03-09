Feature: User Registration 

Scenario: Register with mandatory fields
Given User navigate to Register Account page
When User enters the details into the below fields
|firstName    |yahvi                  |
|lastName      |Singal                 |
|phoneNumber   |1234567890             |
|password      |12345                  |
And User selects Privacy policy field
And User clicks on continue button
Then User account should get created successfully 

Scenario: User creats an account with all fields
Given User navigate to Register Account page
When User enters the details into the below fields
|firstName    |Raveena                   |
|lastName      |Singal                    |
|phoneNumber   |1234567890                |
|password      |12345                     |
And User select Yes for Newsletter
And User selects Privacy policy field
And User clicks on continue button
Then User account should get created successfully 

Scenario: User creates a duplicate account
Given User navigate to Register Account page
When User enters the details into the below fields with duplicate email
|firstName    |Raveena                   |
|lastName      |Singal                    |
|email         |raveenasingal21@gmail.com |
|phoneNumber   |1234567890                |
|password      |12345                     |
And User select Yes for Newsletter
And User selects Privacy policy field
And User clicks on continue button
Then User should get a proper warning about duplicate email 

Scenario: User creates an account without filling any fields
Given User navigate to Register Account page
When User dont enter any details into any field
And  User clicks on continue button
Then User should get a proper Warning messages for all the mandatory fields





