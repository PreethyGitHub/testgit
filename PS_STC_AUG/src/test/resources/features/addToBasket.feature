Feature: Add product to basket
  
  As a User 
  I want to search for a product and add to the basket
  So that product is available in the basket

  @addToBasket
  Scenario Outline: Verify that when a user searches for a valid product and adds to the basket – product should be available in the basket.
  
    Given that user is on the search page
    When the user searches for "<Product>"
    And adds product to the basket
    Then the added "<Product>" should be available in the basket

    Examples: 
      | Product             |
      | LR44 Button Battery |
