  @Login
  Feature: Swag Labs login Functionality

    Scenario Outline: Login successful on swag labs
      Given User launches the Swag Labs URL
      When User enters the "<username>" in username field
      And User enters the "<password>" in the password field
      And User clicks on the login button

      Examples:
      | username | password |
      | standard_user | secret_sauce |