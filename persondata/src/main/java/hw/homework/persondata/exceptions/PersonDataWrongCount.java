package hw.homework.persondata.exceptions;

/**
 * Класс исколючения - несоответствие количества параметров.
 * Выбрасывается, если кол-во параметров в анализируемой строке не равно количеству полей класса PersonData
 */

public class PersonDataWrongCount extends PersonDataExceptions{
    public PersonDataWrongCount() {
        super("Количество переданных значений не соответствует количеству требуемых полей.");
    }

    public PersonDataWrongCount(String message) {
        super(message);
    }
}
