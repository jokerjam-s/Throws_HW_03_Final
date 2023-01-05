package hw.homework.persondata.services;

import hw.homework.persondata.data.PersonData;
import hw.homework.persondata.exceptions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Реализация интерфейса парсинга данных. Для проверки ввода отдельных элементов используется механизм RegExp.
 * Шаблоны для проверки соответствия можно задать посредством конструктора, при вызове конструктора без параметров,
 * будут использованы предопределенные шаблоны
 * <p>
 * Проверка шаблонов (https://regex101.com/)
 */

public class PersonDataParse implements DataParse<PersonData> {
    // Предопределенные шаблоны для проверки элементов структуры данных

    // Шаблон для проверки ФИО. Любые буквы кирилицы или латиницы, не менее 2х
    private static final String NAME_PATTERN = "^[а-яА-Яa-zA-Z]{2,}$";
    // Шаблон телефонного номера, набор любых цифр длиной от 5 до 15 знаков
    private static final String PHONE_PATTERN = "^\\d{5,15}$";
    // Шаблон для определения пола - любая из букв f или m независимо от регистра
    private static final String GENDER_PATTERN = "^[fmFM]$";
    // Дата рождения в формате dd.mm.yyyy
    private static final String BIRTHDATE_PATTERN = "^(0?[1-9]|[12][0-9]|3[01])[.](0?[1-9]|1[012])[.](\\d{4})$";
    // Шаблон даты для перевода из String в LocalDate
    private static final String DATE_PATTERN = "dd.MM.yyyy";


    // Шаблоны проверки соответствия
    private final Pattern namePattern;
    private final Pattern phonePattern;
    private final Pattern genderPattern;
    private final Pattern birthDatePattern;
    private final String datePattern;

    public PersonDataParse(String namePattern, String phonePattern, String genderPattern, String birthDatePattern, String datePattern) {
        this.namePattern = Pattern.compile(namePattern);
        this.phonePattern = Pattern.compile(phonePattern);
        this.genderPattern = Pattern.compile(genderPattern);
        this.birthDatePattern = Pattern.compile(birthDatePattern);
        this.datePattern = datePattern;
    }

    public PersonDataParse() {
        this(NAME_PATTERN, PHONE_PATTERN, GENDER_PATTERN, BIRTHDATE_PATTERN, DATE_PATTERN);
    }

    /**
     * Парсинг строки в PersonData. В случае невозможности получения необходимой структуры данных
     * выбрасывает исключение группы PersonDataExceptions
     *
     * @param data - строка для анализа и парсинга
     * @return - полученное значение
     */
    @Override
    public PersonData parsePersonDate(String data) throws PersonDataExceptions {
        String[] partsInfo = data.split(" ");

        // проверить соответствие количества параметров, при несоответствии -
        // выбросить соответствующее исключение PersonDataWrongCount
        int countValidate = this.isPersonDataCountValid(partsInfo);
        if (countValidate < 0) {
            throw new PersonDataWrongCountLess();
        } else if (countValidate > 0) {
            throw new PersonDataWrongCountMore();
        }

        PersonData personData = new PersonData();

        for (String s : partsInfo) {
            if (this.isPersonNameValid(s)) {                   // Проверка на соответствие ФИО
                // если совпадает - заполлняем пустое значение
                if (personData.getSurName().isEmpty()) {
                    personData.setSurName(s);
                } else if (personData.getFirstName().isEmpty()) {
                    personData.setFirstName(s);
                } else if (personData.getSecondName().isEmpty()) {
                    personData.setSecondName(s);
                }
            } else if (this.isPersonPhoneValid(s)) {         // Проверка на соответствие телефоному номеру
                personData.setPhone(s);
            } else if (this.isPersonBirthDateValid(s)) {     // Проверка на соответствие дате рождения
                personData.setBirthDate(
                        LocalDate.parse(s, DateTimeFormatter.ofPattern(this.datePattern))
                );
            } else if (this.isPersonGenderValid(s)) {        // проверка на соответствие пола
                personData.setGender(s.toLowerCase());       // сохраняем в нижний регистр
            }
        }

        // Проверим заполнение данными, если не все поля заполнены - выбасываем соответствующее исключение
        if (personData.getSurName().isEmpty() || personData.getFirstName().isEmpty() || personData.getSecondName().isEmpty()){
            throw new PersonNameWrongException();
        }

        if(personData.getPhone().isEmpty()){
            throw new PersonPhoneWrongException();
        }

        if (personData.getBirthDate() == null){
            throw new PersonBirthDateWrongException();
        }

        if(personData.getGender().isEmpty()){
            throw new PersonGenderWrongException();
        }

        // все OK - вернем заполненный объект
        return personData;
    }

    /**
     * Парсинг строкового списка в ArrayList<PersonData>. Строки с неверным форматом игнорирует.
     * Если валидных значений в переданном для обработки списке нет - вернет пустой ArrayList<PersonData>.
     *
     * @param data - список c исходной информацией
     * @return - список с полученных значений
     */
    @Override
    public List<PersonData> parseListPersonData(List<String> data) {
        List<PersonData> list = new ArrayList<>();

        for (String s : data) {
            try {
                list.add(parsePersonDate(s));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    /**
     * Проверка количества переданных параметров. Возвращает код ошибки сравнения.
     * @param parameters    - массив переаваемых пользователем параметров
     * @return              - код результата сравнения
     *                         1 - передано больше чем нужно
     *                        -1 - передано меньше чем нужно
     *                         0 - количество верное
     */
    private int isPersonDataCountValid(String[] parameters){
        if(PersonData.class.getDeclaredFields().length > parameters.length){
            return -1;
        } else if (PersonData.class.getDeclaredFields().length < parameters.length) {
            return 1;
        }

        return 0;
    }

    /**
     * Проверка строки на соответствие имени.
     *
     * @param name - проверяемое значение
     * @return - результат проверки
     */
    private boolean isPersonNameValid(String name) {
        return namePattern.matcher(name).matches();
    }

    /**
     * Проверка строки на соответствие телефонному номеру.
     *
     * @param number - проверяемое значение
     * @return - результат проверки
     */
    private boolean isPersonPhoneValid(String number) {
        return phonePattern.matcher(number).matches();
    }

    /**
     * Проверка строки на соответствие информации о половой принадлужности персоны.
     *
     * @param gender - проверяемое значение
     * @return - результат проверки
     */
    private boolean isPersonGenderValid(String gender) {
        return genderPattern.matcher(gender).matches();
    }

    /**
     * Проверка строки на соответствие информации о половой принадлужности персоны.
     *
     * @param birthDate - проверяемое значение
     * @return - результат проверки
     */
    private boolean isPersonBirthDateValid(String birthDate) {
        return birthDatePattern.matcher(birthDate).matches();
    }
}
