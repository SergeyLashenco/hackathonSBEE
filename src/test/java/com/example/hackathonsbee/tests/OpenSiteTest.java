package com.example.hackathonsbee.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpenSiteTest extends TestBase {

    @Test
    public void openSiteTest() {
        app.getSessionHelper().openSite("https://apparel-uk.local:9002/ucstorefront/en");
        app.getNavigationHelper().refreshPage();
        app.getNavigationHelper().clickButtonDetalis();
        Assertions.assertTrue(app.getMainPage().checkHrefSignInRegister());
    }
}
