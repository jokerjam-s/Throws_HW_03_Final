package hw.homework.persondata.services;

import hw.homework.persondata.data.PersonData;

import java.io.FileWriter;
import java.io.IOException;

public class PersonDataSaveImpl implements PersonDataSave{
    public PersonDataSaveImpl() {
    }

    /**
     * Сохранение структуры в текстовый файл. В качестве имени используется фамилия персоны.
     * @param data  - структура для сохранения
     * @throws IOException
     */
    @Override
    public void saveDataToFile(PersonData data) throws IOException {
        String fileName = data.getSurName() + ".txt";

        try(FileWriter file = new FileWriter(fileName, true)){
            file.write(data.toString() + "\n");
        }
    }
}
