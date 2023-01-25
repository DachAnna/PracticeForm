package com.annadach.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.annadach.tests.TestData.firstName;
import static com.annadach.tests.TestData.lastName;

public class StudentRegistrationFormTest extends TestBase{

    @Test
    void fillFormTest() {
        //заполнение формы
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
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
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        //клик по кнопке Submit
        $("#submit").click();

        //Проверка соответствия введенных данных в таблице
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
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
