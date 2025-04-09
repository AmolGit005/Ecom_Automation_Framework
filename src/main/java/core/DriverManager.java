package core;

import com.microsoft.playwright.*;

public class DriverManager
{
    private static Playwright playwright;
    private static Browser browser;

    public static void setUpBrowser() {

        // Get headless and browser type properties
        String headless = System.getProperty("headless", "false");
        Boolean enableHeadless = headless.equalsIgnoreCase("true");

        String browserType = System.getProperty("browser", "chromium");

        playwright = Playwright.create();

        //Configure & Launch the selected browser

        switch (browserType.toLowerCase()) {

            case "firefox":
                browser = playwright.firefox()
                        .launch(new BrowserType.LaunchOptions().setHeadless(enableHeadless).setTimeout(60000));
                break;

            case "webkit":
                browser = playwright.webkit()
                        .launch(new BrowserType.LaunchOptions().setHeadless(enableHeadless).setTimeout(60000));
                break;

            case "chromium":

            default:
                browser = playwright.chromium()
                        .launch(new BrowserType.LaunchOptions().setHeadless(enableHeadless).setTimeout(60000));
                break;
        }
        //Use browser object for further actions
    }

    public static void closeBrowser() {
        if (browser != null) {
            browser.contexts().clear();
            browser.close();
            browser = null;
        }
    }

    public static Browser getBrowser() {
        return browser;
    }

}
