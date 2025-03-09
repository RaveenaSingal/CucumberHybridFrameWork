Feature: User Login
Registered user should be able to login to access account details

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enter valid email address "<username>" into email field
And Enter valid password "<password>" into password field
And Click on login button
Then User should login successfully
Examples:
|username                  |password    |
|nilubhai20@gmail.com      |Raveena@1234|
|raveenasingal21@gmail.com |Raveena@1234|

Scenario: Login with invalid credentials
Given User navigates to login page
When User enter invalid email address 
And Enter invalid password "1234"
And Click on login button
Then User get a proper warning message

Scenario: Login with valid email address and invalid password
Given User navigates to login page
When User enter valid email address "raveenasingal21@gmail.com" into email field
And Enter invalid password "123433"
And Click on login button
Then User get a proper warning message

Scenario: Login with invalid email address and valid password
Given User navigates to login page
When User enter invalid email address 
And Enter valid password "Raveena@1234" into password field
And Click on login button
Then User get a proper warning message

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter any credentials in email address field
When User dont eneter any credentials in password field
And Click on login button
Then User get a proper warning message
