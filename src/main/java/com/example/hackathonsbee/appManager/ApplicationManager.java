package com.example.hackathonsbee.appManager;

import com.example.hackathonsbee.configWebDriver.WebDriverProvider;
import com.example.hackathonsbee.pages.MainPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private String browser;

    private WebDriver driver;

    private MainPage mainPage;

    private SessionHelper sessionHelper;

    private NavigationHelper navigationHelper;

    public ApplicationManager() {

    }

    public void init() {
        driver = new WebDriverProvider().get();
        //  driver.manage().window().maximize(); "1330x1080";1280x800
        driver.manage().window().setSize(new Dimension(1330, 1080));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.openSite("https://apparel-uk.local:9002/ucstorefront/en");

/**
 * Instance for pages
 */
        mainPage = new MainPage(driver);
        navigationHelper = new NavigationHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
