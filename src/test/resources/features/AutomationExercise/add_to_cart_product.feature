  @Test
  Feature: Add the selected product in the shopping cart

    Scenario Outline: Search the product successfully on home page
      Given User launches the automation exercise app Url
      And User clicks and open the login page
      When User enters the email in user email field
        | user_email | demotest991@gmail.com |
      And User enters the password in user password field
        | user_password | demotest123 |
      And User clicks on login button on login page
      When User clicks on the products section on home page
      And User enters the "<productName>" in the search products
      And User clicks on the search submit button
      When User clicks on the view T-Shirt product details
      And User enters the T-Shirt "<quantity>" in Quantity
      And User clicks on the add to cart button
      And User clicks on the view shopping cart

      Examples:
        | productName | quantity |
        | tshirts     |  2 |