package hw.homework.persondata.exceptions;

public class PersonDataWrongCountLess extends PersonDataWrongCount{
    public PersonDataWrongCountLess() {
        super("Количество переданных параметров меньше необходимого.");
    }

    public PersonDataWrongCountLess(String message) {
        super(message);
    }
}
