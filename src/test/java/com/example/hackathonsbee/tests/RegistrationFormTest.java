package com.example.hackathonsbee.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest extends TestBase{


    @DisplayName("Проверка формы регистрации , а также регистрации пользователя ")
    @Description(

            "1. Перейти по ссылке: https://apparel-uk.local:9002/ucstorefront/en\n" +
                    "2. В правом верхнем углу нажать “SIGN IN/REGISTER” /ОР:успешный переход на страницу регистрации, отображение “Create an Account”.\n" +
                    "3. Заполнить поля регистрации:" +
                    " TITLE-MR/  FIRST NAME-IVAN/ LAST NAME-IVANOV/ EMAIL ADDRESS-IVANIVAN@GMAIL.COM/ PASSWORD-123456789/ CONFIRM PASSWORD-123456789/.\n" +
                    "4. Кликнуть по чекбоксу соглашению с правилами сайта и обновления\n." +
                    "5. Нажать на кнопку “REGISTER”\n" +
                    "6. Успешная регистрация на сайте"
    )
    @Test
    public void registrationFormTest(){
        app.getMainPage().goToRegistrationPage();
    }
}
