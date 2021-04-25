package com.automation.poc;

import org.openqa.selenium.By;

public class LoginPage {

    public static By username = By.name("email");
    public static By password = By.name("pass");
    public static By btnLogin = By.name("login");

    public static By btnDrop = By.xpath("//*[@aria-label='Account']");
    public static By btnLogout = By.xpath("//*[@data-nocookies='true']");


}
