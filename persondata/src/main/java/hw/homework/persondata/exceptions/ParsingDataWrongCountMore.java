package hw.homework.persondata.exceptions;

public class PersonDataWrongCountMore extends PersonDataWrongCount{
    public PersonDataWrongCountMore() {
        super("Количество переданных параметров превышает необходимое.");
    }

    public PersonDataWrongCountMore(String message) {
        super(message);
    }
}
