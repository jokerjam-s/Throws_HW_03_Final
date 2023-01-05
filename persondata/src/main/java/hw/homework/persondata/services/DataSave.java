package hw.homework.persondata.services;

import java.io.IOException;

/**
 * Сохранение информации о людях в файл
 */

public interface DataSave<E> {
    /**
     * Сохранние структуры PersonData в текстовый файл. В качестве имени файла используется значение surName
     * @param data  - структура для сохранения
     * @return      - результат выполнения операции
     */
    void saveDataToFile(E data) throws IOException;
}
