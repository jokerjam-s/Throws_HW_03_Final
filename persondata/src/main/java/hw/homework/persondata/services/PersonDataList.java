package hw.homework.persondata.services;

import hw.homework.persondata.data.PersonData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 *
 */
public class PersonDataList implements DataList<PersonData> {
    private ObservableList<PersonData> dataList = FXCollections.observableArrayList();

    /**
     * Добавление элемента в коллекцию
     *
     * @param item - добавляемые данные
     */
    @Override
    public void append(PersonData item) {
        dataList.add(item);
    }

    /**
     * Удалениеи элемента из коллекции
     *
     * @param item - удаляемый элемент
     */
    @Override
    public void delete(PersonData item) {
        dataList.remove(item);
    }

    /**
     * Удвдение элемента по индексу
     *
     * @param index - индечс удаляемого элемента
     */
    @Override
    public void delete(int index) {
        dataList.remove(index);
    }

    /**
     * Получение элемента из коллекции по индексу
     *
     * @param index - индекс возвращаемого документа
     * @return
     */
    @Override
    public PersonData get(int index) {
        return dataList.get(index);
    }

    /**
     * Получение списка данных
     *
     * @return
     */
    @Override
    public ObservableList<PersonData> getList() {
        return dataList;
    }
}
