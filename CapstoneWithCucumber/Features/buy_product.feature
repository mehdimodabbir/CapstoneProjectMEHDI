Feature: Purchasing Product
Scenario: A user could be able to verify the success message
Given A user is on the landing page of saucedemo
When Enter the username standard_user
And password secret_sauce
And click on Login button
And Add the first two products to the cart from list
And click on the cart icon at top right corner
And Click on Checkout button
And Enter your first name in First Name textbox
And nter your last name in Last Name textbox
And Enter Postal Code in Postal Code textbox
And Click on Continue button
And Click on Finish button on the next page
And Verify the success message Your order has been dispatched and will arrive just as fast as the pony can get there!
Then Close the browser