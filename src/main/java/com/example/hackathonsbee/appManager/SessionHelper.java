package com.example.hackathonsbee.appManager;

import org.openqa.selenium.WebDriver;


public class SessionHelper extends ActionsWithOurElements{

    public SessionHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void openSite(String urlSite){
        webDriver.get(urlSite);
    }

    public void login(String userName, String password) {

    }
}
