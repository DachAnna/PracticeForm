package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;
import static tests.TestData.*;

public class StudentRegistrationFormWithPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        //заполнение формы
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeMail(email);
        registrationPage.typeGenderWrapper(gender);
        registrationPage.typeUserNumber(userNumber);
        RegistrationPage.calendar.setDate(monthDate, day, year);
        registrationPage.typeSubjectsInput("h");
        registrationPage.typeHobbiesWrapper("Reading");
        registrationPage.typeHobbiesWrapper("Music");
        $("#uploadPicture").uploadFromClasspath("text.txt");
        registrationPage.typeCurrentAddress(currentAddress);
        $("div").scrollTo();
        $("#state").click();
        registrationPage.typeStateCityWrapper(state);
        $("#city").click();
        registrationPage.typeStateCityWrapper(city);

        //клик по кнопке Submit
        $("#submit").click();

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
        registrationPage.checkResultsValue("State and City", state + " " + city);
    }
}
