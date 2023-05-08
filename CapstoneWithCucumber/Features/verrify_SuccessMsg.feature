Feature: Verrify Success Message
Scenario: The user successfully purchase and see the success message
Given The user is on the main webpage
When The user enter with his/her username
And The user enter his/her password
And the User click on login button further
And the User sort the item based on price Low_to_High
And User add the first itme to the cart
And the user verrify the selected product
And Click on the checkout button
And User enter Fist Name
And User Enter Last Name
And User enter the postal code
And User click on the continue button to the page
And User click on Finish button
And User veriffy the usccess message Thank you for your order!
Then user close the browser