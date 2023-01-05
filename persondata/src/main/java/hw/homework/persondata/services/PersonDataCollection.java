package hw.homework.persondata.services;

import hw.homework.persondata.data.PersonData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.util.List;

/**
 *
 */
public class PersonDataCollection implements DataCollection<PersonData> {
    // TODO: 05.01.2023 Continue here
    private ObservableList<PersonData> dataList =

    /**
     * Добавление элемента в коллекцию
     *
     * @param item - добавляемые данные
     */
    @Override
    public void append(PersonData item) {

    }

    /**
     * Удалениеи элемента из коллекции
     *
     * @param item - удаляемый элемент
     */
    @Override
    public void delete(PersonData item) {

    }

    /**
     * Удвдение элемента по индексу
     *
     * @param index - индечс удаляемого элемента
     */
    @Override
    public void delete(int index) {

    }

    /**
     * Получение элемента из коллекции по индексу
     *
     * @param index - индекс возвращаемого документа
     * @return
     */
    @Override
    public PersonData get(int index) {
        return null;
    }

    /**
     * Получение списка данных
     *
     * @return
     */
    @Override
    public List<PersonData> getList() {
        return null;
    }
}
