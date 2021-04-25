package com.automation.poc.common;

import com.automation.poc.LoginPage;
import com.automation.poc.config.StartBrowser;
import com.automation.poc.custom.ActionDriver;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CommonUtility {
    public WebDriver webDriver;
    public ActionDriver actionDriver;

    public CommonUtility() {
        this.webDriver = StartBrowser.webDriver;
        this.actionDriver = new ActionDriver();
    }

    public void login() throws IOException {
        StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to facebook application");
        actionDriver.navigateToApplication(StartBrowser.HTTPS_URL);
        actionDriver.type(LoginPage.username, "hnnayan@yahoo.com", "Username textbox");
        actionDriver.type(LoginPage.password, "nayanideal29990", "Password textbox");
        actionDriver.click(LoginPage.btnLogin, "Signin button");
        actionDriver.click(LoginPage.btnDrop, "Dropdown button");
        actionDriver.click(LoginPage.btnLogout, "Logout button");
    }
}
