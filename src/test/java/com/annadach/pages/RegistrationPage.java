package com.annadach.pages;

import com.codeborne.selenide.SelenideElement;
import com.annadach.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            genderWrapper = $("#genterWrapper"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            stateCityWrapper = $("#stateCity-wrapper"),
            uploadFile = $("#uploadPicture");



    public static CalendarComponent calendar = new CalendarComponent();

    private final String FORM_TITLE = "Student Registration Form";

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void typeMail(String value) {
        emailInput.setValue(value);
    }

    public void typeUserNumber(String value) {
        userNumberInput.setValue(value);
    }

    public void typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
    }

    public void typeGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
    }

    public void typeSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
    }

    public void typeHobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();
    }

    public void typeStateCityWrapper(String value) {
        stateCityWrapper.$(byText(value)).click();
    }

    public void checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']").parent()
                .shouldHave(text(value));
    }

    public void uploadFile () {
        uploadFile.uploadFromClasspath("text.txt");
    }
}
