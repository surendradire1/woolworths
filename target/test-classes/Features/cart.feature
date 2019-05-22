Feature: Cart items addition and deletion

Scenario: verify item is added in the cart
 Given user is already at home page
 When user Enters the text in search box
 And user clicks on search button
 And user opens fist link of the book
 And user clicks on add to cart button
 And user clicks on go to cart button
 Then user verifies book is added in the cart
 When user clicks remove button
 Then user verifies book is removed from the cart