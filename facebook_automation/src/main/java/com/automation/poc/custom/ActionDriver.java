package com.automation.poc.custom;

import com.automation.poc.config.StartBrowser;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ActionDriver {

    public WebDriver webDriver;

    public ActionDriver() {
        this.webDriver = StartBrowser.webDriver;
    }

    public void navigateToApplication(String url) {
        try {
            webDriver.get(url);
            StartBrowser.childTest.pass("Successfully navigated to URL: " + url);
        } catch (Exception e) {
            StartBrowser.childTest.fail("Unable to navigated to URL: " + url);
            throw e;
        }
    }

    public void click(By locator, String element) throws IOException {
        try {
            webDriver.findElement(locator).click();
            StartBrowser.childTest.pass("Successfully performed click on: " + element);
        } catch (Exception e) {
            StartBrowser.childTest.fail("Unable to performed click on: " + element,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
            StartBrowser.childTest.info(e);

            throw e;
        }

    }

    public void type(By locator, String testData, String elementName) throws IOException {
        try {
            webDriver.findElement(locator).sendKeys(testData);
            StartBrowser.childTest.pass("Performed type in: " + elementName + "with data: " + testData);
        } catch (Exception e) {
            StartBrowser.childTest.fail("Unable to performed type action in: " + elementName + "with data" + testData,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
            StartBrowser.childTest.info(e);
        }
    }

    private String screenShot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
    }
}
