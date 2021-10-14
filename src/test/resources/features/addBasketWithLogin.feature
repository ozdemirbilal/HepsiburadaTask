@smoke
Feature: Add product to cart with Login

  @scenario1
  Scenario: User should be able to add 2 product to cart with Login
    Given Navigate to home page
    When Go to login page
    When Send valid "email" and "password"
    And Verify that user can login
    And Search to buy a "tablet"
    And Choose one product on search page
    And Add the product to basket from 2 vendor
    Then Verify that 2 product in basket


