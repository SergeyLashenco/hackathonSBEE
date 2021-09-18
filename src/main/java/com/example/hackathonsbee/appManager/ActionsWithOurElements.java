package com.example.hackathonsbee.appManager;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {

    WebDriver webDriver;
    public WebDriverWait wait10, wait50;


    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 30);
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

    public void enterTextInToElement(By locator, String text) {
        try {
            clickOnElement(locator);
            if (text != null){
                String existingText = webDriver.findElement(locator).getAttribute("value");
                if (!text.equals(existingText)){
                    webDriver.findElement(locator).clear();
                    webDriver.findElement(locator).sendKeys(text);
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
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

    public void hoverYourMouseOverTheElement(WebElement element) {
        try {
            Actions builder = new Actions(webDriver);
            builder.moveToElement(element).build().perform();
            System.out.println("Element selected");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean searchForItems(By xpath) {
        try {
            return searchForItems(webDriver.findElement(xpath));
        } catch (Exception e){
            return false;
        }
    }

    public void clickOnElement(By xpath) {
        try {
            clickOnElement(webDriver.findElement(xpath));
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
    public void selectValueInDD(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            System.out.println(element + "Was selected inn DD ");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
    public void workWithCheckBox(WebElement element, String status) {
        if ("check".equals(status)|| "uncheck".equals(status)){
            try {
                if (element.isSelected()&& "check".equals(status)){
                    System.out.println("Already check");
                }else if (!element.isSelected() && "check".equals(status)){
                    element.click();
                    System.out.println("check box checked");
                }else if (element.isSelected() && "uncheck".equals(status)){
                    element.click();
                    System.out.println("check box deselected");
                }else if (!element.isSelected() && "uncheck".equals(status)){
                    System.out.println("check box is already unchecked");
                }
            }catch (Exception e){
                printErrorAndStopTest(e);
            }
        }else {
            System.out.println("State should be 'check' or 'uncheck'");
            Assertions.fail("State should be 'check' or 'uncheck'");
        }
    }

    public boolean checkButtonDisabled(WebElement element) {
        wait50.until(ExpectedConditions.visibilityOf(element));
        try {
            if (element.isEnabled()) {
                System.out.println("Element is active");
                Assertions.fail("Element is active");
            } else if (!element.isEnabled()) {
                System.out.println("Element is not Active");
                return !element.isEnabled();
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
        return false;
    }


    private void printErrorAndStopTest(Exception e) {
        System.out.println("Cannot work with element" + " " + e);
        Assertions.fail("Cannot work with element" + e);

    }

    public boolean isElementPresent(By locator) {
        try {
            webDriver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

}
