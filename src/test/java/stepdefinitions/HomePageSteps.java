package stepdefinitions;

import config.Configurations;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class HomePageSteps extends BasePage
{
    HomePage homePage = new HomePage();

    @When("User clicks on the products section on home page")
    public void userClicksOnProductsSectionOnHomePage() {
        ExtentReportManager.createTest("Search Products Home Page");
        ExtentReportManager.log("default", "Search Products Home Page Test Started");
        Log.startTestCase("Search Products Home Page");
        homePage.clickProductsLinkBtn();
    }

    @And("User enters the {string} in the search products")
    public void userEntersTheInTheSearchProducts(String productName) {
        homePage.enterProductNameInSearchBox(productName);
        ExtentReportManager.log("default", "Product Name has been entered in Search Box");
        Log.info("Product Name has been entered in Search Box");
    }

    @And("User clicks on the search submit button")
    public void userClicksOnTheSearchSubmitButton() {
        homePage.clickSearchSubmitBtn();
        ExtentReportManager.log("default", "Product has been successfully searched");
        Log.info("Product has been successfully searched");
    }
}
