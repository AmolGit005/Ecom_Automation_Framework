package stepdefinitions;

import config.Configurations;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginPageSteps extends BasePage
{
    LoginPage loginPage = new LoginPage();

    @Given("User launches the automation exercise app Url")
    public void userLaunchesTheAutomationExerciseAppUrl() {
        ExtentReportManager.createTest("Automation Exercise App Login Test");
        Log.startTestCase("Automation Exercise App Login");
        launchBrowser(Configurations.automationExerciseApp);
        Log.info("Automation Exercise App launched successfully");
    }

    @And("User clicks and open the login page")
    public void userClicksAndOpenTheLoginPage() {
        loginPage.clickLoginSignUpButton();
    }

    @When("User enters the email in user email field")
    public void userEntersTheEmailInUserEmailField(DataTable userEmail) {
        loginPage.enterUserEmail(userEmail);
    }

    @And("User enters the password in user password field")
    public void userEntersThePasswordInUserPasswordField(DataTable userPassword) {
        loginPage.enterUserPassword(userPassword);
    }

    @And("User clicks on login button on login page")
    public void userClicksOnLoginButtonOnLoginPage() {
        loginPage.clickLogin();
        ExtentReportManager.log("pass", "Automation Exercise App Login Test Passed");
        Log.endTestCase("Automation Exercise App Login");
    }

}
