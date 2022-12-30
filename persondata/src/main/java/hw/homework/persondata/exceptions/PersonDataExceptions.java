package hw.homework.persondata.exceptions;

/**
 * Класс исключений обработчика пользовательского ввода.
 */
public class PersonDataExceptions extends RuntimeException {
    public PersonDataExceptions() {
        super("Персональные данные не распознаны или имеют неверный формат.");
    }

    public PersonDataExceptions(String message) {
        super(message);
    }
}

