package com.example.hackathonsbee.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchProductTest extends TestBase{

    @DisplayName("Проверка категории товаров - Snow ")
    @Description(

                    "1. Перейти по ссылке: https://apparel-uk.local:9002/ucstorefront/en\n" +
                    "2. В левом верхнем углу, в строке поиска товара ввести “Vans”.\n" +
                    "3. Нажать на кнопку поиска.\n" +
                    "4. Открывается страница результата поиска товаров, на данной странице отображены товары фирмы “Vans” " +
                            "и надпись You searched for \"имя искомой фирмы\"\n."
    )
    @Test
    public void searchProductsTest(){
        String nameNeededFirmsForSearch = "Adidas";
        app.getMainPage()
                .sendProductsNameInTheSearchFiled(nameNeededFirmsForSearch)
                .clickButtonSearch();
        Assertions.assertEquals(app.getMainPage().getNameFirmsOnSearchPage(), nameNeededFirmsForSearch);
    }
}
