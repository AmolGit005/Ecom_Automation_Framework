  @LoginTest
  Feature: Perform user login functionality

    Scenario: User perform the successful login to application
      Given User launches the automation exercise app Url
      And User clicks and open the login page
      When User enters the email in user email field
           | user_email | demotest991@gmail.com |
      And User enters the password in user password field
           | user_password | demotest123 |
      And User clicks on login button on login page
