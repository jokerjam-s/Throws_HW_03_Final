package hw.homework.persondata.exceptions;

public class ParsingDataWrongCountMore extends ParsingDataWrongCount {
    public ParsingDataWrongCountMore() {
        super("Количество переданных параметров превышает необходимое.");
    }

    public ParsingDataWrongCountMore(String message) {
        super(message);
    }
}
