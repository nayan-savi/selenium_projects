package com.automation.poc.script;

import com.automation.poc.common.CommonUtility;
import com.automation.poc.config.StartBrowser;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC1 extends StartBrowser {

    @Test
    public void loginLogout() throws IOException {
        CommonUtility commonUtility = new CommonUtility();
        commonUtility.login();
    }
}

