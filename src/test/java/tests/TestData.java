package tests;

import com.github.javafaker.Faker;

public class TestData {

    static Faker faker = new Faker();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            userNumber = faker.numerify("##########"),
            currentAddress = faker.address().fullAddress(),
            gender = genderMath(),
            day = faker.date().birthday().toString().substring(8, 10),
            monthDate = getMonthNumber(),
            year = faker.date().birthday().toString().substring(24, 28),
            state = stateMath(),
            city = cityMath(state),
            monthRevert = monthRevert(monthDate);

    public static String genderMath() {
        int ramdomN = faker.number().numberBetween(0, 3);
        String sex;
        if (ramdomN == 0) {
            sex = "Male";
        } else if (ramdomN == 1) {
            sex = "Female";
        } else {
            sex = "Other";
        }
        return sex;
    }

    public static String getMonthNumber() {
        String month = faker.date().birthday().toString().substring(4, 7);
        switch (month) {
            case "Jan":
                month = "0";
                break;
            case "Feb":
                month = "1";
                break;
            case "Mar":
                month = "2";
                break;
            case "Apr":
                month = "3";
                break;
            case "May":
                month = "4";
                break;
            case "Jun":
                month = "5";
                break;
            case "Jul":
                month = "6";
                break;
            case "Aug":
                month = "7";
                break;
            case "Sep":
                month = "8";
                break;
            case "Oct":
                month = "9";
                break;
            case "Nov":
                month = "10";
                break;
            case "Dec":
                month = "11";
                break;
        }
        return month;
    }

    public static String stateMath() {
        int ramdomN = faker.number().numberBetween(0, 5);
        String stateMath;
        if (ramdomN == 0) {
            stateMath = "NCR";
        } else if (ramdomN == 1) {
            stateMath = "Uttar Pradesh";
        } else if (ramdomN == 2) {
            stateMath = "Haryana";
        } else {
            stateMath = "Rajasthan";
        }
        return stateMath;
    }

    public static String cityMath(String state) {
        String cityMath = "";
        switch (state) {
            case "NCR": {
                int ramdomN = faker.number().numberBetween(0, 3);
                if (ramdomN == 0) {
                    cityMath = "Delhi";
                } else if (ramdomN == 1) {
                    cityMath = "Gurgaon";
                } else {
                    cityMath = "Noida";
                }
            }
            break;
            case "Uttar Pradesh": {
                int ramdomN = faker.number().numberBetween(0, 3);
                if (ramdomN == 0) {
                    cityMath = "Agra";
                } else if (ramdomN == 1) {
                    cityMath = "Lucknow";
                } else {
                    cityMath = "Merrut";
                }
            }
            break;
            case "Haryana": {
                int ramdomN = faker.number().numberBetween(0, 2);
                if (ramdomN == 0) {
                    cityMath = "Karnal";
                } else {
                    cityMath = "Panipat";
                }
            }
            break;
            case "Rajasthan": {
                int ramdomN = faker.number().numberBetween(0, 2);
                if (ramdomN == 0) {
                    cityMath = "Jaipur";
                } else {
                    cityMath = "Jaiselmer";
                }
            }
            break;
        }
        return cityMath;
    }

    public static String monthRevert(String monthDate) {
        String monthRevert = "";
        switch (monthDate) {
            case "0":
                monthRevert = "January";
                break;
            case "1":
                monthRevert = "February";
                break;
            case "2":
                monthRevert = "March";
                break;
            case "3":
                monthRevert = "April";
                break;
            case "4":
                monthRevert = "May";
                break;
            case "5":
                monthRevert = "June";
                break;
            case "6":
                monthRevert = "July";
                break;
            case "7":
                monthRevert = "August";
                break;
            case "8":
                monthRevert = "September";
                break;
            case "9":
                monthRevert = "October";
                break;
            case "10":
                monthRevert = "November";
                break;
            case "11":
                monthRevert = "December";
                break;
        }
        return monthRevert;
    }
}