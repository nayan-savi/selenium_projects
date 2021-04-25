package com.automation.poc.config;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class StartBrowser {

    public static final String HTTPS_URL = "https://www.facebook.com/";
    public static WebDriver webDriver;
    public ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest parentTest;
    public static ExtentTest childTest;

    @BeforeTest
    public void report() {
        extentHtmlReporter = new ExtentHtmlReporter("src/main/resources/reports/MyReports.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

    }

    @BeforeMethod
    public void method(Method method) {
        parentTest = extentReports.createTest(method.getName());
    }

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        //webDriver.quit();
        extentReports.flush();
    }
}
