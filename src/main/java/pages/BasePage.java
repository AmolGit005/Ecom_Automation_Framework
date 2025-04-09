package pages;

import com.microsoft.playwright.*;
import core.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class BasePage
{
    protected Browser browser;
    protected BrowserContext context;
    public static Page page;
    public static boolean isScreenshotCapturedAfterFailure = true;
    public static boolean isAdditionalScreenshotsCaptured = true ;
    public static final Logger log = LogManager.getLogger(BasePage.class.getName());

    // Provide default implementations for HashMap
    public HashMap<String, String> getLocatorMap() {
        return new HashMap<>();
    }
    public HashMap<String, String> getInfoMap() {
        return new HashMap<>();
    }

    public BasePage()
    {
        this.browser = DriverManager.getBrowser();
        this.context = browser != null ? browser.newContext() : null;
    }

    public void waitAndClick(String locator)
    {
        try
        {
            wait(2000);
            page.locator(getLocatorMap().get(locator)).isVisible();
            page.locator(getLocatorMap().get(locator)).click();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enterText(String locator, String text) {

        try {
            Locator input = page.locator(getLocatorMap().get(locator));
            input.waitFor();
            input.fill(text);
        } catch (Exception e) {
            throw e;
        }
    }

    public void launchBrowser(String applicationUrl) {
        page = browser.newPage();
        String url = null;
        url = applicationUrl;

        if (url != null) {
            try {
                page.navigate(url);
            } catch (Exception e) {
                e.getMessage();
            }
        } else {
            System.out.println("Application URL is not valid");
        }

    }

}
