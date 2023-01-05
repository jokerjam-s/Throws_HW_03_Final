package hw.homework.persondata.exceptions;

/**
 * Класс исколючения - неверный формат пола.
 * Выбрасывается, если поол указан с использованием недопустимых символов.
 */
public class ParsingGenderWrongException extends ParsingDataExceptions {
    public ParsingGenderWrongException() {
        super("Пол персоны указан неверно.");
    }

    public ParsingGenderWrongException(String message) {
        super(message);
    }
}
