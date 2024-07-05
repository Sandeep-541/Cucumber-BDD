Feature: Login functionality for opencart E-commerce Website
  As a User of the Opencart Website
  I want to be able to log in with my account
  so that i can access my account-related features and manage my orders

  Background:
    Given I am on the Opencart login page

    Scenario: Successful login with valid credentials
      Given I have entered a valid username and password
      When  I click on the login button
      Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username          | password        | error_message                        |
      | invalid@email.com | invalidPassword | No match for E-Mail and/or Password. |
      | abcccc            | validPassword   | No match for E-Mail and/or Password. |
      | valid@email.com   | abccc           | No match for E-Mail and/or Password. |

  Scenario: Navigating to the forgotten password page
      When I click on the "Forgotten Password" link
      Then I should be redirected to the password reset page