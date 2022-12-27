package hw.th.userdata.persondata.exceptions;

/**
 * Класс исколючения - неверный формат даты рождения.
 * Выбрасывается, если дата рождения не соотыетствует требуемому формату (дд.мм.гггг).
 * В качестве допустимых символов разрешены только цифры и точки в строго определенных местах
 */
public class PersonBirthDateWrongException extends PersonDataExceptions {
    private String message = "Неверный формат даты рождения.";

    public PersonBirthDateWrongException() {
    }

    public PersonBirthDateWrongException(String message) {
        super(message);
        this.message = message;
    }
}
