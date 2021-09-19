package com.example.hackathonsbee.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static io.qameta.allure.Allure.step;

public class MainPage extends ParentPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final List<WebElement> resultsSearchCategoryGoodsSnow = webDriver.findElements(By.xpath(".//div[@class='sub-navigation-section col-md-3']"));

    @FindBy(xpath = ".//a[@href='/ucstorefront/en/login']")
    public WebElement hrefSignInRegister;

    @Step("Проверить отображения ссылки Sign in / Register на странице ")
    public boolean checkHrefSignInRegister() {
        return hrefSignInRegister.isDisplayed();
    }

    @Step("Навести курсор мыши на нужную категорию товаров, в данном случае  {categoryGoods}")
    public MainPage hoverOnCategoryGoods(String categoryGoods) {
        String xpathCategoryGoods = String.format(".//a[@title='%s']", categoryGoods);
        WebElement needCategoryGoods = webDriver.findElement(By.xpath(xpathCategoryGoods));
        actionsWithOurElements.hoverYourMouseOverTheElement(needCategoryGoods);
        return this;
    }

    @Step("Получить количество списков с товарами ")
    public int getResultCategoryGoodsSnow() {
        return resultsSearchCategoryGoodsSnow.size();
    }

    public boolean checkGenderSplitLists(String... gendersName) {
        AtomicBoolean resultCheck = new AtomicBoolean(false);
        step("Проверить что при наведении курсора на категорию “Snow” появляется список с товарами для мужчин/женщин/молодежи, экипировкой", ()->{
            for (String gen : gendersName){
                String xpathForGenderName = String.format("//div[contains(text(),'%s')]", gen);
                resultCheck.set(resultsSearchCategoryGoodsSnow.stream()
                        .map(webElement -> webElement.findElement(By.xpath(xpathForGenderName)))
                        .findAny()
                        .get()
                        .isDisplayed());
            }
        });
        return resultCheck.get();
    }
}