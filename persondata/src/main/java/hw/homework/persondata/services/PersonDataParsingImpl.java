package hw.homework.persondata.services;

import hw.homework.persondata.data.PersonData;
import hw.homework.persondata.exceptions.PersonDataExceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса парсинга данных. Для проверки ввода отдельных элементов используется механизм RegExp.
 * Шаблоны для проверки соответствия можно задать посредством конструктора, при вызове конструктора без параметров,
 * будут использованы предопределенные шаблоны
 *
 * Проверка шаблонов (https://regex101.com/)
 */

public class PersonDataParsingImpl implements PersonDataParsing {
    // Предопределенные шаблоны для проверки элементов структуры данных

    // Шаблолн для проверки ФИО. Любые буквы кирилицы или латиницы, не менее 2х
    private static final String NAME_PATTERN = "^[а-яА-Яa-zA-Z]{2,}$";
    // Шаблон телефонного номера, набор любых цифр длиной от 5 до 15 знаков
    private static final String PHONE_PATTERN = "^\\d{5,15}$";
    // Шаблон для определения пола - любая из букв f или m независимо от регистра
    private static final String GENDER_PATTERN = "^[fmFM]$";
    // Дата рождения в формате dd.mm.yyyy
    private static final String BIRTHDATE_PATTERN = "^(0?[1-9]|[12][0-9]|3[01]])[.](0?[1-9]|1[012])[.](\\d{4}))$";


    // Шаблоны проверки соответствия
    private final String namePattern;
    private final String phonePattern;
    private final String genderPattern;
    private final String birthDatePattern;


    public PersonDataParsingImpl(String namePattern, String phonePattern, String genderPattern, String birthDatePattern) {
        this.namePattern = namePattern;
        this.phonePattern = phonePattern;
        this.genderPattern = genderPattern;
        this.birthDatePattern = birthDatePattern;
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
        // TODO: 28.12.2022 реализовать парсинг
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
        // TODO: 28.12.2022 реализовать проверку имени через регэксп
        return false;
    }

    /**
     * Проверка строки на соответствие телефонному номеру.
     *
     * @param number    - проверяемое значение
     * @return          - результат проверки
     */
    private boolean isPersonNamePhoneValid(String number) {
        // TODO: 28.12.2022 реализовать проверку телефона
        return false;
    }

    /**
     * Проверка строки на соответствие информации о половой принадлужности персоны.
     *
     * @param gender    - проверяемое значение
     * @return          - результат проверки
     */
    private boolean isPersonGenderValid(String gender) {
        // TODO: 28.12.2022 выполнить реализацию проверки пола
        return false;
    }

    /**
     * Проверка строки на соответствие информации о половой принадлужности персоны.
     *
     * @param birthDate - проверяемое значение
     * @return          - результат проверки
     */
    private boolean isPersonBirthDateValid(String birthDate) {
        // TODO: 28.12.2022 реализовать проверку даты рождения
        return false;
    }
}
