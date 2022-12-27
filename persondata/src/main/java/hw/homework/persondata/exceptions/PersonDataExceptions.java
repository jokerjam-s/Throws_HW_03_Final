package hw.th.userdata.persondata.exceptions;

/**
 * Класс исключений обработчика пользовательского ввода.
 */
public class PersonDataExceptions extends RuntimeException {
    private String message = "Персональные данные не распознаны или ичеют неверный формат.";

    public PersonDataExceptions() {
    }

    public PersonDataExceptions(String message) {
        super(message);
        this.message = message;
    }
}

