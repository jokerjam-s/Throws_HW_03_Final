package hw.homework.persondata.exceptions;

/**
 * Класс исколючения - неверный телефонный номер.
 * Выбрасывается, если веденный номер телефона содержит неверный формат.
 * В качестве допустимых символов разрешены только цифры
 */
public class PersonPhoneWrongException extends PersonDataExceptions{
    private String message = "Телефоннфй номер имеет неверный формат.";

    public PersonPhoneWrongException() {
    }

    public PersonPhoneWrongException(String message) {
        super(message);
        this.message = message;
    }
}
