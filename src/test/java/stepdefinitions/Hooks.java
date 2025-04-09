package stepdefinitions;

import core.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ExtentReportManager;

public class Hooks {
    @Before
    public void setUp() {
        DriverManager.setUpBrowser();
        ExtentReportManager.initReport();
    }

    @After
    public void tearDown() {
        ExtentReportManager.flushReport();
        DriverManager.closeBrowser();
    }
}
