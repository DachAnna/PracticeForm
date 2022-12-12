package pages;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
       // Configuration.browserSize = "2100x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
