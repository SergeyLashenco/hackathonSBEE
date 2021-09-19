package com.example.hackathonsbee.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends ParentPage  {
    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

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
    public boolean checkTextCreateAnAccount(){
        return textCreateAnAccount.isDisplayed();
    }

    @Step("Заполнить поле firstName {firstsName} ")
    public RegistrationPage fillInFiledFirstName(String firstsName){
        actionsWithOurElements.enterTextInToElement(firstName, firstsName);
        return this;
    }

    @Step("Заполнить поле lastName {lasName} ")
    public RegistrationPage fillInFiledLastName(String lasName){
        actionsWithOurElements.enterTextInToElement(lastName, lasName);
        return this;
    }

    @Step("Заполнить поле Email {emailVal}")
    public RegistrationPage fillInFiledEmail(String emailVal){
        actionsWithOurElements.enterTextInToElement(email, emailVal);
        return this;
    }

    @Step("Заполнить поле Password {pass}")
    public RegistrationPage fillInFiledPassword(String pass){
        actionsWithOurElements.enterTextInToElement(pwd, pass);
        return this;
    }

    @Step("Заполнить поле CheckPwd {cPass}")
    public RegistrationPage fillInFiledCheckPwd(String cPass){
        actionsWithOurElements.enterTextInToElement(checkPwd, cPass);
        return this;
    }

    @Step("Выбрать ЧекБокс Соглашения с правилами")
    public RegistrationPage clickButtonCheckBoxConfirm(){
        actionsWithOurElements.workWithCheckBox(checkBoxConfirming, "check");
        return this;
    }

    @Step("Нажать на кнопку REGISTER")
    public RegistrationPage clickButtonREGISTER(){
        actionsWithOurElements.clickOnElement(buttonRegister);
        return this;
    }

}
