Feature: Registration Functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register account page
When  User enters the details into below fields
|FirstName |Arun                      |
|LastName  |Mottori                   |
|Email     |amotoori24122022@gmail.com|
|TelePhone |1234567890                |
|Password  |12345                     |
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully 

Scenario: User creates an account with all fields
Given User navigates to Register account page
When  User enters the details into below fields
|FirstName |Arun                      |
|LastName  |Mottori                   |
|Email     |amotoori24122022@gmail.com|
|TelePhone |1234567890                |
|Password  |12345                     |
And User selects Yes for Newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates a duplicate account
Given User navigates to Register account page
When  User enters the details into below fields
|FirstName |Arun                      |
|LastName  |Mottori                   | 
|Email     |amotoori24122022@gmail.com|
|TelePhone |1234567890                |
|Password  |12345                     |
And User selects Yes for Newsletter
And User selects privacy policy
And User clicks on continue button
Then User should get a proper warning about duplicate email


Scenario: User creates an account without filling any details
Given User navigates to Register account page
When User dont enter any details into fields
And Clicks on continue button
Then User should get proper warning messages for every mandatory fileds 
 