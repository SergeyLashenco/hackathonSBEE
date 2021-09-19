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

    @FindBy(id = "js-site-search-input")
    private WebElement inputSearch;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = ".//div[@class='results']")
    private WebElement resultString;

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
        step("Проверить что при наведении курсора на категорию “Snow” появляется список с товарами для мужчин/женщин/молодежи, экипировкой", () -> {
            for (String gen : gendersName) {
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

    @Step("В поле поиска ввести название товара")
    public MainPage sendProductsNameInTheSearchFiled(String productName) {
        actionsWithOurElements.enterTextInToElement(inputSearch, productName);
        return this;
    }

    @Step("Нажать на кнопу поиска")
    public MainPage clickButtonSearch() {
        actionsWithOurElements.clickOnElement(buttonSearch);
        return this;
    }

    @Step("Проверить что открылась страцица из товаром от Фирмы по которой проводился поиск")
    public String getNameFirmsOnSearchPage() {
        String resultSearchOnPage = resultString.getText();
        String[] res = resultSearchOnPage.split("\"");
        return res[1];
    }

    @Step("Перейти на страницу регистрации нажатием на ссылку Sign in / Register")
    public RegistrationPage goToRegistrationPage(){
        actionsWithOurElements.clickOnElement(hrefSignInRegister);
        return new RegistrationPage(webDriver);
    }
}