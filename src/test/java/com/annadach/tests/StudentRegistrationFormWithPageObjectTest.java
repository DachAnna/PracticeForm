package com.annadach.tests;

import com.annadach.pages.RegistrationPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.annadach.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormWithPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("properties")
    void fillFormTest() {
        //заполнение формы
        step("Открываем главную страницу с формой", () -> {
            registrationPage.openPage();
        });
        step("Заполняем имя", () -> {
            registrationPage.typeFirstName(firstName);
        });
        step("Заполняем фамилию", () -> {
            registrationPage.typeLastName(lastName);
        });
        step("Заполняем адрес эл.почты", () -> {
            registrationPage.typeMail(email);
        });
        step("Выбираем пол", () -> {
            registrationPage.typeGenderWrapper(gender);
        });
        step("Вводим номер телефона", () -> {
            registrationPage.typeUserNumber(userNumber);
        });
        step("Выбираем дату рождения", () -> {
            RegistrationPage.calendar.setDate(monthDate, day, year);
        });
        step("Выбираем предмет", () -> {
            registrationPage.typeSubjectsInput("h");
        });
        step("Выбираем хобби", () -> {
            registrationPage.typeHobbiesWrapper("Reading");
            registrationPage.typeHobbiesWrapper("Music");
        });
        step("Загружаем файл", () -> {
            registrationPage.uploadFile();
        });
        step("Вводим адрес", () -> {
            registrationPage.typeCurrentAddress(currentAddress);
        });
        step("Выбираем область и город", () -> {
            $("div").scrollIntoView(false);
            $("#state").click();
            registrationPage.typeStateCityWrapper("NCR");
            $("#city").click();
            registrationPage.typeStateCityWrapper("Delhi");
        });

        step("Нажимаем на кнопку отправки формы", () -> {
            //скролл до кнопки для jenkins
            $("#submit").scrollIntoView(false);
            //клик по кнопке Submit
            $("#submit").click();
        });
        step("Проверяем соответствие введенных данных", () -> {
            //Проверка соответствия введенных данных в таблице
            registrationPage.checkResultsValue("Student Name", firstName + " " + lastName);
            registrationPage.checkResultsValue("Student Email", email);
            registrationPage.checkResultsValue("Gender", gender);
            registrationPage.checkResultsValue("Mobile", userNumber);
            registrationPage.checkResultsValue("Date of Birth", day + " " + monthRevert + "," + year);
            registrationPage.checkResultsValue("Subjects", "Hindi");
            registrationPage.checkResultsValue("Hobbies", "Reading, Music");
            registrationPage.checkResultsValue("Picture", "text.txt");
            registrationPage.checkResultsValue("Address", currentAddress);
            registrationPage.checkResultsValue("State and City", "NCR Delhi");
        });
    }
}
