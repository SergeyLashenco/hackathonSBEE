package com.example.hackathonsbee.pages;

import io.qameta.allure.Step;
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

    @Step("Проверить отображения ссылки Sign in / Register на странице ")
    public boolean checkHrefSignInRegister(){
         return hrefSignInRegister.isDisplayed();
    }

}
