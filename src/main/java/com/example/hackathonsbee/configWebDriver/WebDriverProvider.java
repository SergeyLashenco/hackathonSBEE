package com.example.hackathonsbee.configWebDriver;

import com.example.hackathonsbee.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {
    @Override
    public WebDriver get() {
        final WebDriverConfig config = ConfigFactory.newInstance().create(WebDriverConfig.class);

        if (config.remote()) {
            switch (config.browser()) {
                case CHROME:
                case FIREFOX:
                    return new RemoteWebDriver(config.remoteURL(), getBrowserRemoteDC(config.browser()));//DesiredCapabilities.chrome()
                default:
                    throw new RuntimeException("Unknown remote browser " + config.browser());
            }
        } else {
            switch (config.browser()) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                default:
                    throw new RuntimeException("Unknown browser " + config.browser());
            }
        }
    }

    private DesiredCapabilities getBrowserRemoteDC(Browser browser) {
        if (browser.equals(Browser.CHROME)) {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName(browser.name());
            dc.setCapability("enableVNC", true);
            dc.setCapability("enableVideo", true);
            dc.setCapability("sessionTimeout", "4m");
            dc.setCapability("videoFrameRate", 24);
            dc.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
            return dc;
        } else {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName(browser.name());
            dc.setCapability("enableVNC", true);
            dc.setCapability("enableVideo", true);
            dc.setCapability("sessionTimeout", "4m");
            dc.setCapability(FirefoxOptions.FIREFOX_OPTIONS, getFirefoxOptions());
            return dc;
        }
    }

    private FirefoxOptions getFirefoxOptions() {
        return new FirefoxOptions();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--lang=ru");
        return chromeOptions;
    }
}
