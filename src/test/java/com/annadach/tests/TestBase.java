package com.annadach.tests;

import com.annadach.helpers.Attach;
import com.annadach.tests.config.CredentialsConfig;
import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;

import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;


public class TestBase {

    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void setup() {
        String browserSize = System.getProperty("browserSize", "2100x1080");
        String browser = System.getProperty("browser", "chrome");
        String login = credentials.login();
        String password = credentials.password();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = browserSize;
        Configuration.browser = browser;
        Configuration.remote = format("https://%s:%s@selenoid.autotests.cloud/wd/hub/", login, password);
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
