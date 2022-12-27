package hw.homework.persondata.services;

import hw.homework.persondata.data.PersonData;

/**
 * Сохранение информации о людях в файл
 */

public interface PersonDataSaving {
    /**
     * Сохранние структуры PersonData в текстовый файл. В качестве имени файла используется значение surName
     * @param data  - структура для сохранения
     * @return      - результат выполнения операции
     */
    boolean saveDataToFile(PersonData data);
}
