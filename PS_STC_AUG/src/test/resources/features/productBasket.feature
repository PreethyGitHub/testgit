Feature: Add product to basket
  
  As a User 
  I want to search for a product and add to the basket
  So that product is available in the basket

  @adaToBasket
  Scenario Outline: Verify that when a user searches for a valid product and adds to the basket – product should be available in the basket.
    Given that I am on the home page
    When I enter "searchTextBox" as "<Product>" 
    And I click "searchButton"
    And I click "firstProductLink"
    And I click add "addToBasketButton" and close "popup"
    Then product in "basket" should be "<Expected_Result>"

    Examples: 
      | Product   | Expected_Result |
      | Batteries | 1 |