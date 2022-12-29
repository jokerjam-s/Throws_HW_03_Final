package hw.homework.persondata.exceptions;


/**
 * Класс исколючения - несоответствие количества параметров.
 * Выбрасывается, если кол-во параметров в анализируемой строке не равно количеству полей класса PersonData
 */

public class PersonDataWrongCount extends PersonDataExceptions{
    public String message = "Количество переданных значений не соответствует количеству требуемых полей.";

    public PersonDataWrongCount() {
    }

    public PersonDataWrongCount(String message) {
        this.message = message;
    }
}
