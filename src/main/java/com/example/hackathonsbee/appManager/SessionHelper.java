package com.example.hackathonsbee.appManager;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.qameta.allure.Allure.step;


public class SessionHelper extends ActionsWithOurElements {

    public SessionHelper(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Перейти по адресу {urlSite}")
    public void openSite(String urlSite) {
        webDriver.get(urlSite);
        step("В случае если открывается страница \"Подключение не защищено\" , нажать на кнопку Дополнительные и ссылку " +
                " \"Перейти на сайт небезопасно\"", () -> {
            if (isElementPresent(By.id("details-button"))) {
                webDriver.findElement(By.id("details-button")).click();
                webDriver.findElement(By.id("proceed-link")).click();
            }
        });
    }

    public void login(String userName, String password) {
    }
}
