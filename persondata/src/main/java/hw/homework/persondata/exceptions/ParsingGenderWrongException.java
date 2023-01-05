package hw.homework.persondata.exceptions;

/**
 * Класс исколючения - неверный формат пола.
 * Выбрасывается, если поол указан с использованием недопустимых символов.
 */
public class PersonGenderWrongException extends ParsingDataExceptions {
    public PersonGenderWrongException() {
        super("Пол персоны указан неверно.");
    }

    public PersonGenderWrongException(String message) {
        super(message);
    }
}
