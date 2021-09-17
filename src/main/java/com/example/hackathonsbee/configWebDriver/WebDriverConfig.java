package com.example.hackathonsbee.configWebDriver;

import com.example.hackathonsbee.enums.Browser;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:webdriver.properties")
public interface WebDriverConfig extends Config {

    @DefaultValue("false")
    @Key("webdriver.remote.url")
    URL remoteURL();

    @DefaultValue("false")
    @Key("webdriver.remote")
    boolean remote();

    @DefaultValue("CHROME")
    @Key("webdriver.browser")
    Browser browser();
}
