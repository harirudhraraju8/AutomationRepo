Feature: Login Functionality

Scenario: Login with login credentials
Given User navigates to login page
When User enteres valid emails address "amotooricap9@gmail.com" into email field
And User enteres valid password "12345" into password field
And User clicks on Login button
Then User should get successfully logged in


Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid emaild address "amotooricap90@gmail.com" into email field
And User enters valid password "1234512345" into password field
And User clicks on Login button
Then User should get proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid emaild address "amotooricap9@gmail.com" into email field
And User enters invalid password "1234512345" into password field
And User clicks on Login button
Then User should get proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid emaild address "amotooricap90@gmail.com" into email field
And User enteres valid password "12345" into password field
And User clicks on Login button
Then User should get proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter email address into email field
And  User dont enter password into password field
And User clicks on Login button
Then User should get proper warning message about credentials mismatch
