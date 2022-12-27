package hw.th.userdata.persondata.services;

import hw.th.userdata.persondata.data.PersonData;

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
