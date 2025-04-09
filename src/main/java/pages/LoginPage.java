package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.Map;

import static pages.BasePage.log;
import static pages.BasePage.page;

public class LoginPage
{
    private HashMap<String, String> locatorMap = new HashMap<>();
    private HashMap<String, String> infoMap = new HashMap<>();

    public LoginPage()
    {
        //Locators
        locatorMap.put("loginSignUpBtn", "//a[normalize-space()='Signup / Login']");
        locatorMap.put("userEmail", "//input[@data-qa='login-email']");
        locatorMap.put("userPassword", "//input[@placeholder='Password']");
        locatorMap.put("loginButton", "//button[@data-qa='login-button']");

        //Info Messages for All Locators
        infoMap.put("loginSignUpBtn","Login and Sign Up Button");
        infoMap.put("userEmail","User Email Field");
        infoMap.put("userPassword","User Password Field");
        infoMap.put("loginButton","Login Button");
    }

    public void enterUserEmail(DataTable dataTable) {
        try {
            Map<String, String> columns = dataTable.asMap(String.class, String.class);
            String userEmail = columns.get("user_email");

            Locator UserEmail = page.locator("//input[@data-qa='login-email']");
            UserEmail.fill(userEmail);

        } catch (Exception e) {
            log.info("Failed to enter the user email");
            throw new RuntimeException(e);
        }
    }

    public void enterUserPassword(DataTable dataTable) {
        try {
            Map<String, String> columns = dataTable.asMap(String.class, String.class);
            String userPassword = columns.get("user_password");

            Locator UserPassword = page.getByPlaceholder("Password");
            UserPassword.fill(userPassword);

        } catch (Exception e) {
            log.info("Failed to enter the user password");
            throw new RuntimeException(e);
        }
    }

    public void clickLogin() {
        try {
            //Locator loginButton = page.getByText("Login");
            Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
            loginButton.click();
        } catch (Exception e) {
            log.info("Failed to click on the Login Button");
            throw new RuntimeException(e);
        }
    }

    public void clickLoginSignUpButton() {
        try {
            Locator loginSignUpButton = page.locator("//a[normalize-space()='Signup / Login']");
            loginSignUpButton.click();
        } catch (Exception e) {
            log.info("Failed to click on the Login SignUpButton");
            throw new RuntimeException(e);
        }
    }

}
