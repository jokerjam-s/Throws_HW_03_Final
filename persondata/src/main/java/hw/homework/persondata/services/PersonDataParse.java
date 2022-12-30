package hw.homework.persondata.services;

import hw.homework.persondata.data.PersonData;
import hw.homework.persondata.exceptions.PersonDataExceptions;

import java.util.List;

/**
 * Интерфейс для парсинга текстовой информации в формат PersonData
 */

public interface PersonDataParse {
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

}
