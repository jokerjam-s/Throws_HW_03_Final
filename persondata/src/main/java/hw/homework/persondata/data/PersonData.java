package hw.homework.persondata.data;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

/**
 * Структура пользовательских данных, для привязки данных к отображению в
 * javaFX TsbleView используется Simple-***-Property
 */

public class PersonData {
    // Фамилия
    private SimpleStringProperty surName;
    // Имя
    private SimpleStringProperty firstName;
    // Отчество
    private SimpleStringProperty secondName;
    // Телефон
    private SimpleStringProperty phone;
    // дата рождения
    private SimpleObjectProperty<LocalDate> birthDate;
    // пол
    private SimpleStringProperty gender;

    public PersonData() {
        this("", "", "", "", null, "");
    }

    public PersonData(String surName, String firstName, String secondName, String phone, LocalDate birthDate, String gender) {
        this.surName = new SimpleStringProperty(surName);
        this.firstName = new SimpleStringProperty(firstName);
        this.secondName = new SimpleStringProperty(secondName);
        this.phone = new SimpleStringProperty(phone);
        this.birthDate = new SimpleObjectProperty<>(birthDate);
        this.gender = new SimpleStringProperty(gender);
    }

    public SimpleStringProperty surNameProperty() {
        return surName;
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public SimpleStringProperty secondNameProperty() {
        return secondName;
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public SimpleObjectProperty<LocalDate> birthDateProperty() {
        return birthDate;
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    @Override
    public String toString() {
        return "<" + surName.get() + ">" +
                "<" + firstName.get() + ">" +
                "<" + secondName.get() + ">" +
                "<" + birthDate.get().toString() + ">" +
                "<" + phone.get() + ">" +
                "<" + gender.get() + ">";
    }

    public String getSurName() {
        return surName.get();
    }

    public void setSurName(String surName) {
        this.surName.set(surName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getSecondName() {
        return secondName.get();
    }

    public void setSecondName(String secondName) {
        this.secondName.set(secondName);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public LocalDate getBirthDate() {
        return birthDate.get();
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate.set(birthDate);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }
}
