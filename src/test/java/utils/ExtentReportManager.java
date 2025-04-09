package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReport() {
        extent = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("Reports/extent-report.html");
        extent.attachReporter(htmlReporter);
    }

    public static void createTest(String name) {
        test = extent.createTest(name);
    }

    public static void log(String status, String message) {
        switch (status.toLowerCase()) {
            case "pass": test.pass(message); break;
            case "fail": test.fail(message); break;
            default: test.info(message); break;
        }
    }

    public static void flushReport() {
        extent.flush();
    }
}
