package com.annadach.tests;

import com.annadach.helpers.Attach;
import com.annadach.tests.config.Config;
import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;

import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;


public class TestBase {

    @BeforeAll
    static void setup() {

        String environment = System.getProperty("environment", "remote");

        if (environment.equals("remote")) {
            System.setProperty("remote", "environment");
            Config config = ConfigFactory.create(Config.class, System.getProperties());

            String browserSize = config.getSize();
            String browser = config.getBrowser();
            String browserVersion = config.getVersion();
            String baseUrl = config.getBaseUrl();
            String remoteUrl = config.getRemoteUrl();
            String login = config.getLogin();
            String password = config.getPassword();


            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

            Configuration.browserCapabilities = capabilities;
            Configuration.browserSize = browserSize;
            Configuration.browser = browser;
            Configuration.browserVersion = browserVersion;
            Configuration.baseUrl = baseUrl;
            Configuration.remote = remoteUrl;
            Configuration.remote = format("https://%s:%s@%s", login, password, remoteUrl);

        } else {
            System.setProperty("environment", "local");
            Config config = ConfigFactory.create(Config.class, System.getProperties());

            String browserSize = config.getSize();
            String browser = config.getBrowser();
            String baseUrl = config.getBaseUrl();
            String remoteUrl = config.getRemoteUrl();

            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVideo", true);

            Configuration.browserCapabilities = capabilities;
            Configuration.browserSize = browserSize;
            Configuration.browser = browser;
            Configuration.baseUrl = baseUrl;
            Configuration.remote = remoteUrl;
        }
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
