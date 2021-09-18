package com.example.hackathonsbee.appManager;

import com.example.hackathonsbee.configWebDriver.WebDriverProvider;
import com.example.hackathonsbee.pages.MainPage;
import com.example.hackathonsbee.pages.ParentPage;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.PrimitiveIterator;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private String browser;

    private WebDriver driver;

    private MainPage mainPage;

    private SessionHelper sessionHelper;

    private NavigationHelper navigationHelper;

//    private ParentPage parentPage;

    public ApplicationManager() {

    }

    public void init() {
        driver = new WebDriverProvider().get();
        //  driver.manage().window().maximize(); "1330x1080";1280x800
        driver.manage().window().setSize( new Dimension(1330, 1080));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.jetbrains.com/");

/**
 * Instance for pages
 */
        mainPage = new MainPage(driver);
        sessionHelper = new SessionHelper(driver);
        navigationHelper = new NavigationHelper(driver);
      //  parentPage = new ParentPage(driver);
    }


    public void stop() {
        driver.quit();
    }

    public MainPage getMainPage(){
        return mainPage;
    }

    public SessionHelper getSessionHelper(){
        return sessionHelper;
    }

    public NavigationHelper getNavigationHelper(){
        return navigationHelper;
    }
}
