package hw.homework.persondata.exceptions;

/**
 * Класс исколючения - неверный формат даты рождения.
 * Выбрасывается, если дата рождения не соотыетствует требуемому формату (дд.мм.гггг).
 * В качестве допустимых символов разрешены только цифры и точки в строго определенных местах
 */
public class PersonBirthDateWrongException extends PersonDataExceptions {
    public PersonBirthDateWrongException() {
        super("Неверный формат даты рождения.");
    }

    public PersonBirthDateWrongException(String message) {
        super(message);
    }
}
