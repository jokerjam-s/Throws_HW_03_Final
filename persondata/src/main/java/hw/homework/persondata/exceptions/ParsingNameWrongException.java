package hw.homework.persondata.exceptions;

/**
 * Класс исколючения - неверные персональные данные.
 * Выбрасывается, если веденные ФИО содержат недопустимые символы.
 * В качестве допустимых символов разрешены латинские или кириллические буквы и дефис
 */
public class ParsingNameWrongException extends ParsingDataExceptions {
    public ParsingNameWrongException() {
        super("Неверный формат Фамилии, Имени или Отчества.");
    }

    public ParsingNameWrongException(String message) {
        super(message);
    }
}
