package com.example.hackathonsbee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(css = "a.wt-button_mode_primary")
    public WebElement seeAllToolsButton;

    @FindBy(xpath = "//div[contains(@class, 'menu-main__item') and text() = 'Developer Tools']")
    public WebElement toolsMenu;

    @FindBy(css = "[data-test='site-header-search-action']")
    public WebElement searchButton;

    @FindBy(css = "[data-test='search-input']")
    public WebElement searchField;

    @FindBy(css = "button[data-test='full-search-button']")
    public WebElement submitButton;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void sendTextForFieldSearch(String test){
        searchField.sendKeys(test);
    }

    public void submitButtonClick(){
        submitButton.click();
    }
}


/*
 WebElement searchField = driver.findElement(By.cssSelector("[data-test='search-input']"));
        searchField.sendKeys("Selenium");

        WebElement submitButton = driver.findElement(By.cssSelector("button[data-test='full-search-button']"));
        submitButton.click();
 */