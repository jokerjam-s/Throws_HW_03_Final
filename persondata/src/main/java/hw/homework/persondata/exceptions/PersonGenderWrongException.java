package hw.homework.persondata.exceptions;

/**
 * Класс исколючения - неверный формат пола.
 * Выбрасывается, если поол указан с использованием недопустимых символов.
 */
public class PersonGenderWrongException extends PersonDataExceptions {
    public String message = "Пол персоны указан неверно.";

    public PersonGenderWrongException() {
    }

    public PersonGenderWrongException(String message) {
        this.message = message;
    }
}
