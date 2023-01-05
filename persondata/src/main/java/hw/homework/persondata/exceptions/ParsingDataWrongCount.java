package hw.homework.persondata.exceptions;

/**
 * Класс исколючения - несоответствие количества параметров.
 * Выбрасывается, если кол-во параметров в анализируемой строке не равно количеству полей класса PersonData
 */

public class ParsingDataWrongCount extends ParsingDataExceptions {
    public ParsingDataWrongCount() {
        super("Количество переданных значений не соответствует количеству требуемых полей.");
    }

    public ParsingDataWrongCount(String message) {
        super(message);
    }
}
