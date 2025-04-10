package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultsPage;
import utils.ExtentReportManager;
import utils.Log;

public class SearchResultsPageSteps {
    SearchResultsPage searchResultPage = new SearchResultsPage();

    @When("User clicks on the view T-Shirt product details")
    public void userClicksOnTheViewTShirtProductDetails() {
        ExtentReportManager.createTest("Product Add to Cart Test");
        ExtentReportManager.log("default", "T-Shirt product is selected to add in cart");
        Log.startTestCase("Product Add to Cart");
        searchResultPage.clickTshirtProduct();
    }

    @And("User enters the T-Shirt {string} in Quantity")
    public void userEntersTheTShirtInQuantity(String quantity) {
        searchResultPage.enterTshirtQuantity(quantity);
    }

    @And("User clicks on the add to cart button")
    public void userClicksOnTheAddToCartButton() {
        searchResultPage.clickAddToCartBtn();
    }

    @And("User clicks on the view shopping cart")
    public void userClicksOnTheViewShoppingCart() {
        searchResultPage.clickViewShoppingCartBtn();
        ExtentReportManager.log("default", "Product has been successfully added in Shopping Cart");
        Log.info("Product has been successfully added in Shopping Cart");
    }
}
