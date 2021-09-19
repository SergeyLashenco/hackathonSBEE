package com.example.hackathonsbee.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class RegistrationPage extends ParentPage {
    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    private HashMap<WebElement, String> mapForTextFields = new HashMap<>();

    @FindBy(xpath = ".//div[@class='user-register__headline']")
    private WebElement textCreateAnAccount;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "pwd")
    private WebElement pwd;

    @FindBy(name = "checkPwd")
    private WebElement checkPwd;

    @FindBy(name = "termsCheck")
    private WebElement checkBoxConfirming;

    @FindBy(xpath = ".//button[@class='btn btn-default btn-block']")
    private WebElement buttonRegister;

    @Step("Проверить отображения текста Create an Account")
    public boolean checkTextCreateAnAccount() {
        return textCreateAnAccount.isDisplayed();
    }

    @Step("Выбрать ЧекБокс Соглашения с правилами")
    public RegistrationPage clickButtonCheckBoxConfirm() {
        actionsWithOurElements.workWithCheckBox(checkBoxConfirming, "check");
        return this;
    }

    @Step("Нажать на кнопку REGISTER")
    public RegistrationPage clickButtonREGISTER() {
        actionsWithOurElements.clickOnElement(buttonRegister);
        return this;
    }

    @Step("Fill Registration forms")
    public RegistrationPage fillRegistrationFiled(String firstsName, String lasName, String emailVal, String pass, String cPass) {
        mapForTextFields.clear();
        mapForTextFields.put(firstName, firstsName);
        mapForTextFields.put(lastName, lasName);
        mapForTextFields.put(email, emailVal);
        mapForTextFields.put(pwd, pass);
        mapForTextFields.put(checkPwd, cPass);

        for (Map.Entry<WebElement, String> webElementStringEntry
                : mapForTextFields.entrySet()) {
            webElementStringEntry.getKey()
                    .sendKeys(webElementStringEntry.getValue());
        }
        return this;
    }
}
