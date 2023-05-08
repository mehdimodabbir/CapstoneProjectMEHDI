Feature: Verrify Error Message
Scenario: A user should be able to verrify the given error message 
Given The user should navigate to the website https://www.saucedemo.com
When A user enter the username locked_out_user in the username
And A user enter the required password secret_sauce
And A user click on the login button
And A user verrify the message Epic sadface: Sorry, this user has been locked out.
Then close the application