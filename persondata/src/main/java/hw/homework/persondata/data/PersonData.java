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
    private Number phone;
    // дата рождения
    private LocalDate birthDate;
    // пол
    private String gender;

    public PersonData() {
        this("", "", "", 0, null, "");
    }

    public PersonData(String surName, String firstName, String secondName, Number phone, LocalDate birthDate, String gender) {
        this.surName = surName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.birthDate = birthDate;
        this.gender = gender;
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

    public Number getPhone() {
        return phone;
    }

    public void setPhone(Number phone) {
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
