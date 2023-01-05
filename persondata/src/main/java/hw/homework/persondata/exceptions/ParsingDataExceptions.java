package hw.homework.persondata.exceptions;

/**
 * Класс исключений обработчика пользовательского ввода.
 */
public class ParsingDataExceptions extends RuntimeException {
    public ParsingDataExceptions() {
        super("Персональные данные не распознаны или имеют неверный формат.");
    }

    public ParsingDataExceptions(String message) {
        super(message);
    }
}

