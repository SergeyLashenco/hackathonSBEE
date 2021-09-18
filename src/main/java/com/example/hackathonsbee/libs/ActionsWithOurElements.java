package com.example.hackathonsbee.libs;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {

    WebDriver webDriver;
    public WebDriverWait wait10, wait50;


    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 20);
        wait50 = new WebDriverWait(webDriver, 50);
    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            System.out.println(text + " Was input in to element ");
        } catch (Exception e) {

        }
    }

    public void clickOnElement(WebElement element) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            System.out.println("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean searchForItems(WebElement element) {
        try {
            wait10.until(ExpectedConditions.visibilityOf(element));
            boolean isDisplayed = element.isDisplayed();
            System.out.println("Element is displayed -> " + isDisplayed);
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Element is displayed -> false" + " " + e);
            System.out.println("Element is displayed -> false");
            return false;
        }
    }


    private void printErrorAndStopTest(Exception e) {
        System.out.println("Cannot work with element" + " " + e);
        Assertions.fail("Cannot work with element" + e);

    }
}
