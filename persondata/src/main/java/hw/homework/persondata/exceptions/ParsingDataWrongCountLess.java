package hw.homework.persondata.exceptions;

public class ParsingDataWrongCountLess extends ParsingDataWrongCount {
    public ParsingDataWrongCountLess() {
        super("Количество переданных параметров меньше необходимого.");
    }

    public ParsingDataWrongCountLess(String message) {
        super(message);
    }
}
