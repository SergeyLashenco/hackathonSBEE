package com.example.hackathonsbee.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends TestBase {

    @DisplayName("Проверка авторизации пользователя на платформе")
    @Description(

            "1. Перейти по ссылке: https://apparel-uk.local:9002/ucstorefront/en\n" +
                    "2. В правом верхнем углу нажать “SIGN IN/REGISTER” /ОР:успешный переход на страницу регистрации, отображение “Create an Account”.\n" +
                    "3. 3.С правой стороны в форме Авторизации заполнить поля: EMAIL ADDRESS-IVANIVAN@GMAIL.COM/ PASSWORD-123456789.\n" +
                    "4. Кликнуть на “LOG IN”\n" +
                    "5. Проверить отображения ссылки Sign Out"
    )

    @Test
    public void validLoginTest() {
        app.getMainPage().goToRegistrationPage();
        assertTrue(app.getRegistrationPage().checkTextReturningCustomer());
        app.getRegistrationPage()
                .enterTextToInputEmail("IVANIVAN@GMAIL.COM")
                .enterTextToInputPass("123456789")
                .clickOnButtonLogIn();
        assertTrue(app.getMainPage().checkHrefSignOut());

    }
}

