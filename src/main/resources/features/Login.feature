Feature: Login functionality

  Scenario: User logins with valid credentials
    Given the user is on login page
    When user enters valid username
    And user enters valid password
    Then user is succesfully logged
    And user is redirected to mainpage
