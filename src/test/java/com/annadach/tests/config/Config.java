package com.annadach.tests.config;


@Config.Sources({"classpath:config/${environment}.properties"})
public interface Config extends org.aeonbits.owner.Config {

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("browserName")
    String getBrowser();

    @Key("browserVersion")
    String getVersion();

    @Key("browserSize")
    String getSize();

}
