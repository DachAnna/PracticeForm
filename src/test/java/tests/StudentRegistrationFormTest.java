package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2100x1080";
}

    @Test
    void fillFormTest() {
        //заполнение формы
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("alex@qaguru.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8652154357");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("5");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day.react-datepicker__day--013").click();
        $("#subjectsInput").setValue("h").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("text.txt");
        $("#currentAddress").setValue("some street 1");
        $("div").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        //клик по кнопке Submit
        $("#submit").click();

        //Проверка соответствия введенных данных в таблице
        $(".table-responsive").shouldHave(text("Alex Petrov"),
                text("alex@qaguru.com"),
                text("8652154357"),
                text("13 June,1992"),
                text("Hindi"),
                text("Reading, Music"),
                text("text.txt"),
                text("some street 1"),
                text("Haryana Karnal"));
    }
}
