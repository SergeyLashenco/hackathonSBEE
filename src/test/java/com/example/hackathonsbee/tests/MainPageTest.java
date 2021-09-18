package com.example.hackathonsbee.tests;

import org.junit.jupiter.api.Test;

public class MainPageTest extends TestBase {

    @Test
    public void search() {
        app.getMainPage().clickSearchButton();
        app.getMainPage().sendTextForFieldSearch("Selenium");
        app.getMainPage().submitButtonClick();
    }
}
