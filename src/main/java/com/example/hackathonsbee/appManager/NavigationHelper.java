package com.example.hackathonsbee.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends ActionsWithOurElements {
    public NavigationHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void refreshPage(){
        webDriver.navigate().refresh();
    }

    public void clickButtonDetalis(){
        if (isElementPresent(By.id("details-button"))){
            webDriver.findElement(By.id("details-button")).click();
            webDriver.findElement(By.id("proceed-link")).click();
        }
    }
}
