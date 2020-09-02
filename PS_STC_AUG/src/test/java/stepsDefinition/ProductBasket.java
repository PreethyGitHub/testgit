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

public class ProductBasket extends BaseUtil {

	public BaseUtil base;

	public ProductBasket(BaseUtil base) {
		this.base = base;
	}

	@Given("that I am on the home page")
	public void that_I_am_on_the_home_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@And("I click add {string} and close {string}")
	public void I_click_add(String object, String popup) throws InterruptedException {
		base.keyword.waitUntilElementIsVisible(object);
		base.log.info("* And user clicks..");
		base.keyword.sleep(5);
		boolean popupresult = base.keyword.checkElementExists(popup);
		if(popupresult) {
			base.keyword.click(popup);
			base.keyword.sleep(5);
		}
		base.keyword.click(object);
		base.keyword.sleep(10);
	}

	@Then("product in {string} should be {string}")
	public void product_in_should_be(String object, String text) {
		try {
			// assertion
			boolean result = base.keyword.verifyText(object, text);
			Assert.assertTrue(result);
			base.log.info("Product is added to the basket");
		} catch (Exception e) {
			base.log.fatal("Exception - Product is not added to the basket");
			Assert.fail(e.getMessage());
		} catch (AssertionError e) {
			base.log.error("Exception - Product is not added to the basket");
			Assert.fail(e.getMessage());
		}
	}

}
