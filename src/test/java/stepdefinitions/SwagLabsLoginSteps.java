package stepdefinitions;

import config.Configurations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import pages.BasePage;
import pages.SwagLabsLogin;
import utils.ExtentReportManager;
import utils.LoggerUtil;

public class SwagLabsLoginSteps extends BasePage {
    SwagLabsLogin login = new SwagLabsLogin();
    private static final Logger logger = LoggerUtil.getLogger(SwagLabsLogin.class);

    @Given("User launches the Swag Labs URL")
    public void user_launches_the_swag_labs_url() {
        ExtentReportManager.createTest("Swag Labs Login Test");
        launchBrowser(Configurations.swagLabsApp);
        log.info("Browser launched successfully");

    }
    @When("User enters the {string} in username field")
    public void user_enters_the_in_username_field(String username)
    {
        login.enterUsername(username);
    }

    @And("User enters the {string} in the password field")
    public void user_enters_the_in_the_password_field(String password) {
        login.enterPassword(password);

    }
    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        login.login();
        log.info("Login successfully completed");
        ExtentReportManager.log("pass", "Swag Labs Login Test Passed");
    }

}
