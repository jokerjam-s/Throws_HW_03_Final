package hw.th.userdata.persondata.services;


import hw.th.userdata.persondata.data.PersonData;
import hw.th.userdata.persondata.exceptions.PersonDataExceptions;

import java.util.List;

/**
 * Интерфейс для парсинга текстовой информации в формат PersonData
 */

public interface PersonDataParsing {
    /**
     * Парсинг строки в PersonData. В случае невозможности получения необходимой структуры данных
     * выбрасывает исключение группы PersonDataExceptions
     *
     * @param data  - строка для анализа и парсинга
     * @return      - полученное значение
     */
    PersonData parsePersonDate(String data) throws PersonDataExceptions;

    /**
     * Парсинг строкового списка в ArrayList<PersonData>. Строки с неверным форматом игнорирует.
     * Если валидных значений в переданном для обработки списке нет - вернет пустой ArrayList<PersonData>.
     *
     * @param data  - список c исходной информацией
     * @return      - список с полученных значений
     */
    List<PersonData> parseListPersonData(List<String> data);

    /**
     * Проверка строки на соответствие требованиям к Фамилии, Имени или Отчеству.
     *
     * @param name  - проверяемое значение
     * @return      - результат проверки
     */
    boolean isPersonNameValid(String name);

    /**
     * Проверка строки на соответствие телефонному номеру.
     *
     * @param number    - проверяемое значение
     * @return          - результат проверки
     */
    boolean isPersonPhoneValid(String number);

    /**
     * Проверка строки на соответствие информации о половой принадлужности персоны.
     *
     * @param gender    - проверяемое значение
     * @return          - результат проверки
     */
    boolean isPersonGenderValid(String gender);

    /**
     * Проверка строки на соответствие информации о половой принадлужности персоны.
     *
     * @param birthDate - проверяемое значение
     * @return          - результат проверки
     */
    boolean isPersonBirthDateValid(String birthDate);

}
