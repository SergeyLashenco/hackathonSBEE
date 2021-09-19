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

    @FindBy(xpath = ".//div[@class='login-page__headline']")
    private WebElement textReturningCustomer;

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

    @FindBy(xpath = ".//input[@name='j_username']")
    private WebElement emailForAuth;

    @FindBy(xpath = ".//input[@name='j_password']")
    private WebElement passForAuth;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-block']")
    private WebElement buttonLogIn;

    @Step("Проверить отображения текста Create an Account")
    public boolean checkTextCreateAnAccount() {
        return textCreateAnAccount.isDisplayed();
    }

    @Step("Проверить отображение текста Returning Customer")
    public boolean checkTextReturningCustomer() {
        return textReturningCustomer.isDisplayed();
    }

    @Step("Заполнить поле firstName {firstsName} ")
    public RegistrationPage fillInFiledFirstName(String firstsName) {
        actionsWithOurElements.enterTextInToElement(firstName, firstsName);
        return this;
    }

    @Step("Заполнить поле lastName {lasName} ")
    public RegistrationPage fillInFiledLastName(String lasName) {
        actionsWithOurElements.enterTextInToElement(lastName, lasName);
        return this;
    }

    @Step("Заполнить поле Email {emailVal}")
    public RegistrationPage fillInFiledEmail(String emailVal) {
        actionsWithOurElements.enterTextInToElement(email, emailVal);
        return this;
    }

    @Step("Заполнить поле Password {pass}")
    public RegistrationPage fillInFiledPassword(String pass) {
        actionsWithOurElements.enterTextInToElement(pwd, pass);
        return this;
    }

    @Step("Заполнить поле CheckPwd {cPass}")
    public RegistrationPage fillInFiledCheckPwd(String cPass) {
        actionsWithOurElements.enterTextInToElement(checkPwd, cPass);
        return this;
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

    @Step("Заполнить поле EMAIL ADDRESS для авторизации")
    public RegistrationPage enterTextToInputEmail(String email) {
        actionsWithOurElements.enterTextInToElement(emailForAuth, email);
        return this;
    }

    @Step("Заполнить поле PASSWORD для авторизации")
    public RegistrationPage enterTextToInputPass(String pass) {
        actionsWithOurElements.enterTextInToElement(passForAuth, pass);
        return this;
    }

    @Step("Нажать на кнопку Log in")
    public RegistrationPage clickOnButtonLogIn() {
        actionsWithOurElements.clickOnElement(buttonLogIn);
        return this;
    }

    @Step("Fill Registration forms: \n" +
            "firstsName - {firstsName}\n " +
            "lastName - {lasName}\n " +
            "emailVal - {emailVal}\n " +
            "pass - {pass}\n " +
            "cPass - {cPass}\n ")
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

