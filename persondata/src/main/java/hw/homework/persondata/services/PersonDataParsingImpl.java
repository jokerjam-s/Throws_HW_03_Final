package hw.homework.persondata.services;

import hw.homework.persondata.data.PersonData;
import hw.homework.persondata.exceptions.PersonDataExceptions;
import hw.homework.persondata.exceptions.PersonDataWrongCount;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Реализация интерфейса парсинга данных. Для проверки ввода отдельных элементов используется механизм RegExp.
 * Шаблоны для проверки соответствия можно задать посредством конструктора, при вызове конструктора без параметров,
 * будут использованы предопределенные шаблоны
 *
 * Проверка шаблонов (https://regex101.com/)
 */

public class PersonDataParsingImpl implements PersonDataParsing {
    // Предопределенные шаблоны для проверки элементов структуры данных

    // Шаблон для проверки ФИО. Любые буквы кирилицы или латиницы, не менее 2х
    private static final String NAME_PATTERN = "^[а-яА-Яa-zA-Z]{2,}$";
    // Шаблон телефонного номера, набор любых цифр длиной от 5 до 15 знаков
    private static final String PHONE_PATTERN = "^\\d{5,15}$";
    // Шаблон для определения пола - любая из букв f или m независимо от регистра
    private static final String GENDER_PATTERN = "^[fmFM]$";
    // Дата рождения в формате dd.mm.yyyy
    private static final String BIRTHDATE_PATTERN = "^(0?[1-9]|[12][0-9]|3[01]])[.](0?[1-9]|1[012])[.](\\d{4}))$";


    // Шаблоны проверки соответствия
    private final Pattern namePattern;
    private final Pattern phonePattern;
    private final Pattern genderPattern;
    private final Pattern birthDatePattern;


    public PersonDataParsingImpl(String namePattern, String phonePattern, String genderPattern, String birthDatePattern) {
        this.namePattern = Pattern.compile(namePattern);
        this.phonePattern = Pattern.compile(phonePattern);
        this.genderPattern = Pattern.compile(genderPattern);
        this.birthDatePattern = Pattern.compile(birthDatePattern);
    }

    public PersonDataParsingImpl() {
        this(NAME_PATTERN, PHONE_PATTERN, GENDER_PATTERN, BIRTHDATE_PATTERN);
    }

    /**
     * Парсинг строки в PersonData. В случае невозможности получения необходимой структуры данных
     * выбрасывает исключение группы PersonDataExceptions
     *
     * @param data  - строка для анализа и парсинга
     * @return      - полученное значение
     */
    @Override
    public PersonData parsePersonDate(String data) throws PersonDataExceptions {
        String[] partsInfo = data.split(" ");
        // проверить соответствие количества параметров
        if (PersonData.class.getDeclaredFields().length != partsInfo.length){
            throw new PersonDataWrongCount();
        }

        PersonData personData = new PersonData();

        for (int i = 0; i < partsInfo.length; i++) {
            if(isPersonNameValid(partsInfo[i])){
                if(personData.getFirstName().isEmpty()){
                    personData.setFirstName(partsInfo[i]);
                } else if (personData.getSecondName().isEmpty()) {
                    personData.setSecondName(partsInfo[i]);
                }
                // TODO: 29.12.2022 continue here
            }
        }


        return null;
    }

    /**
     * Парсинг строкового списка в ArrayList<PersonData>. Строки с неверным форматом игнорирует.
     * Если валидных значений в переданном для обработки списке нет - вернет пустой ArrayList<PersonData>.
     *
     * @param data  - список c исходной информацией
     * @return      - список с полученных значений
     */
    @Override
    public List<PersonData> parseListPersonData(List<String> data) {
        List<PersonData> list = new ArrayList<>();

        for (String s : data){
            try {
                list.add(parsePersonDate(s));
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return list;
    }

    /**
     * Проверка строки на соответствие имени.
     *
     * @param name      - проверяемое значение
     * @return          - результат проверки
     */
    private boolean isPersonNameValid(String name) {
        return namePattern.matcher(name).matches();
    }

    /**
     * Проверка строки на соответствие телефонному номеру.
     *
     * @param number    - проверяемое значение
     * @return          - результат проверки
     */
    private boolean isPersonPhoneValid(String number) {
        return phonePattern.matcher(number).matches();
    }

    /**
     * Проверка строки на соответствие информации о половой принадлужности персоны.
     *
     * @param gender    - проверяемое значение
     * @return          - результат проверки
     */
    private boolean isPersonGenderValid(String gender) {
        return genderPattern.matcher(gender).matches();
    }

    /**
     * Проверка строки на соответствие информации о половой принадлужности персоны.
     *
     * @param birthDate - проверяемое значение
     * @return          - результат проверки
     */
    private boolean isPersonBirthDateValid(String birthDate) {
        return birthDatePattern.matcher(birthDate).matches();
    }
}
