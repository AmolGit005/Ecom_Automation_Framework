package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.HashMap;

public class SwagLabsLogin extends BasePage
{

    private HashMap<String, String> locatorMap = new HashMap<>();
    private HashMap<String, String> infoMap = new HashMap<>();


    public SwagLabsLogin()
    {
        //Locators
        locatorMap.put("username","//input[@id='user-name']");
        locatorMap.put("password","//input[@id='password']");
        locatorMap.put("loginbutton","//input[@id='login-button']");

        //Info Messages for All Locators
        infoMap.put("username","Login Username");
        infoMap.put("password","Login Password");
        infoMap.put("loginbutton","Login Button");
    }

    public void login()
    {
        try
        {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN"))
                    .click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enterUsername(String username)
    {
        try
        {
            page.getByPlaceholder("Username").fill(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enterPassword(String password)
    {
        try
        {
            page.getByPlaceholder("Password").fill(password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
