package com.example.hackathonsbee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//a[@href='/ucstorefront/en/login']")
    public WebElement hrefSignInRegister;

    public boolean checkHrefSignInRegister(){
         return hrefSignInRegister.isDisplayed();
    }
}
