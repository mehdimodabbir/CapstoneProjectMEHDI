Feature: TextBox Error
Scenario: The user is required to enter the last name
Given the user is on the https://www.saucedemo.com/ webpage
When A user enter the username problem_user
And A user enter the password secret_sauce in the webpage
And A user click on the login button of page
And User add the 1st product to the cart
And The user click further on the cart icon top right corner
And The user click on checkout button
And User enter the First Name
And User enter the Last Name
And user enter the Postal code
And User click on the continue button
And Error messeged occured Error: Last Name is required
Then close the webpage