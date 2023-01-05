package hw.homework.persondata.services;

import hw.homework.persondata.data.PersonData;
import hw.homework.persondata.exceptions.ParsingDataExceptions;

import java.util.List;

/**
 * Интерфейс для парсинга текстовой информации в формат PersonData
 */

public interface DataParse<E> {
    /**
     * Парсинг строки в <E>. В случае невозможности получения необходимой структуры данных
     * выбрасывает исключение группы ParsingDataExceptions
     *
     * @param data  - строка для анализа и парсинга
     * @return      - полученное значение
     */
    E parsePersonDate(String data) throws ParsingDataExceptions;

    /**
     * Парсинг строкового списка в ArrayList<E>. Строки с неверным форматом игнорирует.
     * Если валидных значений в переданном для обработки списке нет - вернет пустой ArrayList<E>.
     *
     * @param data  - список c исходной информацией
     * @return      - список с полученных значений
     */
    List<E> parseListPersonData(List<String> data);

}
