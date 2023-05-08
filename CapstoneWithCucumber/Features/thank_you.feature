Feature: Thank You
Scenario: User successfully purchase the product and see thank you message
Given User should be on the WebPage
When User type hi/her login username
And user type his/her password
And User could click on the green login button
And User add the first and third items to the cart
And user should remove the first item from the cart
And user click on the right corner cart button
And User verrify the title
And user should be able click on continue button
And User Sort the items from High to Low
And User add most expensive item to the cart
And User click on the cart icon
And Verrify there are two items added to cart
And checkout button
And User enter fist_name
And user Enter Last Name
And user enter postal code
And Click on the continue button
And click on the finish button
And Verrify the success message Thank you for your order!
Then close the browser of sucedemo