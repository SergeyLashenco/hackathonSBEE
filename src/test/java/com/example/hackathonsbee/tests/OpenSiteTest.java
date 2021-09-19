package com.example.hackathonsbee.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class OpenSiteTest extends TestBase {

    @Test
    @DisplayName("Проверка открытия сайта")
    @Description(
            "1. Перейти по ссылке: https://apparel-uk.local:9002/ucstorefront/en\n" +
            "2. В случае если открывается страница \"Подключение не защищено\" , нажать на кнопку Дополнительные\n" +
            "3. После чего нажать на ссылку \"Перейти на сайт небезопасно\"\n" +
            "4. Проверить отображения ссылки Sign in / Register на странице"
    )
    public void openSiteTest() {
        step("Обновить страницу" , ()->{
            app.getNavigationHelper().refreshPage();
        });
        Assertions.assertTrue(app.getMainPage().checkHrefSignInRegister());
    }
}
