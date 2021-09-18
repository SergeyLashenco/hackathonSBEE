package com.example.hackathonsbee.libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {

    WebDriver webDriver;

    public WebDriverWait wait10, wait50;


    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 20);
        wait50 = new WebDriverWait(webDriver, 50);
    }
}
