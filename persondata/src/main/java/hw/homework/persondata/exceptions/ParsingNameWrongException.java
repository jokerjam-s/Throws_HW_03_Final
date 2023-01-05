package hw.homework.persondata.exceptions;

/**
 * Класс исколючения - неверные персональные данные.
 * Выбрасывается, если веденные ФИО содержат недопустимые символы.
 * В качестве допустимых символов разрешены латинские или кириллические буквы и дефис
 */
public class PersonNameWrongException extends ParsingDataExceptions {
    public PersonNameWrongException() {
        super("Неверный формат Фамилии, Имени или Отчества.");
    }

    public PersonNameWrongException(String message) {
        super(message);
    }
}
