package hw.homework.persondata.services;

import hw.homework.persondata.data.PersonData;

import java.io.IOException;

/**
 * Сохранение информации о людях в файл
 */

public interface PersonDataSave {
    /**
     * Сохранние структуры PersonData в текстовый файл. В качестве имени файла используется значение surName
     * @param data  - структура для сохранения
     * @return      - результат выполнения операции
     */
    void saveDataToFile(PersonData data) throws IOException;
}
