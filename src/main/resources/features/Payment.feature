Feature: Visa credit card payment

  Scenario: Payment is complete with valid Visa credit card
    Given user pays for the Cart
    When user input valid Visa credit card number
    And Expiration date
    And CVV code
    Then Payment is accept by service provider
    And user is redirected to mainwebsite
    And user receives email with payment confirmation

