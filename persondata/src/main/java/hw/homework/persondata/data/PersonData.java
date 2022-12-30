package hw.homework.persondata.data;

import java.time.LocalDate;

/**
 * Структура пользовательских данных
 */

public class PersonData {
    // Фамилия
    private String surName;
    // Имя
    private String firstName;
    // Отчество
    private String secondName;
    // Телефон
    private String phone;
    // дата рождения
    private LocalDate birthDate;
    // пол
    private String gender;

    public PersonData() {
        this("", "", "", "", null, "");
    }

    public PersonData(String surName, String firstName, String secondName, String phone, LocalDate birthDate, String gender) {
        this.surName = surName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "<" + surName + ">" +
                "<" + firstName + ">" +
                "<" + secondName + ">" +
                "<" + birthDate + ">" +
                "<" + phone + ">" +
                "<" + gender + ">";
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
