package com.example.hackathonsbee.appManager;

import org.openqa.selenium.WebDriver;

public class NavigationHelper extends ActionsWithOurElements {
    public NavigationHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void refreshPage(){
        webDriver.navigate().refresh();
    }
}
