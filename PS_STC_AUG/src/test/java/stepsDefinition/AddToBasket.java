package stepsDefinition;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.BaseUtil;

public class AddToBasket extends BaseUtil {

	public BaseUtil base;

	public AddToBasket(BaseUtil base) {
		this.base = base;
	}

	@Given("that user is on the search page")
	public void that_user_is_on_the_search_page() throws InterruptedException {

		// Validate that the user is on the search page
		try {
			base.log.info("Get to Search Page and verify search box is found..");
			boolean result = base.keyword.checkElementExists("searchTextBox");
			Assert.assertTrue(result);
			base.log.info("User is on the Search page");
		} catch (Exception e) {
			base.log.fatal("Exception - User is NOT on the Search page");
			Assert.fail(e.getMessage());
		} catch (AssertionError e) {
			base.log.error("AssertionError - User is NOT on the Search in page");
			Assert.fail(e.getMessage());
		}
	}

	@When("the user searches for {string}")
	public void the_user_searches_for(String data) throws InterruptedException {

		// Enter product name and search for product
		try {
			base.log.info("Search for the product");
			base.keyword.searchforProduct(data);
		} catch (Exception e) {
			base.log.fatal("Exception - Unable to search product");
			base.log.fatal(e.getMessage());
		}
	}

	@And("adds product to the basket")
	public void adds_product_to_the_basket() {

		// Add product to the basket
		try {
			base.log.info("Add the first product from search results to the basket");
			base.keyword.addProductToBasket();
		} catch (Exception e) {
			base.log.fatal("Exception - Unable to add Product to basket");
			base.log.fatal(e.getMessage());
		}

	}

	@Then("the added {string} should be available in the basket")
	public void the_added_should_be_available_in_the_basket(String data) {

		// Validate that the product is available in the basket
		try {
			base.log.info("Open the basket to validate the results");
			base.keyword.getToBasket();
			boolean result = base.keyword.verifyPartialText("productNameBasketLabel", data);
			Assert.assertTrue(result);
			base.log.info("Product has been added successfully to the basket");
		} catch (Exception e) {
			base.log.fatal("Exception - Product not added to basket");
			Assert.fail(e.getMessage());
		} catch (AssertionError e) {
			base.log.error("AssertionError - Product not added to basket");
			Assert.fail(e.getMessage());
		}

	}

}
