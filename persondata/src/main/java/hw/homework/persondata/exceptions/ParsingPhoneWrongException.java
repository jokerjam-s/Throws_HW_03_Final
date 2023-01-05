package hw.homework.persondata.exceptions;

/**
 * Класс исколючения - неверный телефонный номер.
 * Выбрасывается, если веденный номер телефона содержит неверный формат.
 * В качестве допустимых символов разрешены только цифры
 */
public class ParsingPhoneWrongException extends ParsingDataExceptions {
    public ParsingPhoneWrongException() {
        super("Телефоннфй номер имеет неверный формат.");
    }

    public ParsingPhoneWrongException(String message) {
        super(message);
    }
}
