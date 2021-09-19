package com.example.hackathonsbee.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryOfGoodsTest extends TestBase {


    @DisplayName("Проверка отображения списка при наведении курсора на  категорию товаров - Snow ")
    @Description(
            "1. Перейти по ссылке: https://apparel-uk.local:9002/ucstorefront/en\n" +
                    "2. Навестись курсором на категорию “Snow”\n" +
                    " Проверить что при наведении курсора на категорию “Snow” появляется список с товарами для мужчин/женщин/молодежи, экипировкой"
    )
    @Test
    public void testCategorySnow() {
        app.getMainPage()
                .hoverOnCategoryGoods("Snow");
        assertEquals(app.getMainPage().getResultCategoryGoodsSnow(), 4);
        assertTrue(app.getMainPage().checkGenderSplitLists("Men", "Women", "Youth", "Kit"));
    }
}
