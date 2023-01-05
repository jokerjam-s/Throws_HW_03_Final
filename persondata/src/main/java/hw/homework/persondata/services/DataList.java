package hw.homework.persondata.services;

import java.util.List;

/**
 * Компонент, реализующий управлениеи коллекцией данных
 */
public interface DataList<E> {
    /**
     * Добавление элемента в коллекцию
      * @param item - добавляемые данные
     */
    void append(E item);

    /**
     * Удалениеи элемента из коллекции
     * @param item  - удаляемый элемент
     */
    void delete(E item);

    /**
     * Удвдение элемента по индексу
     * @param index - индечс удаляемого элемента
     */
    void delete(int index);

    /**
     * Получение элемента из коллекции по индексу
     * @param index - индекс возвращаемого документа
     * @return
     */
    E get(int index);

    /**
     * Получение списка данных
     * @return
     */
    List<E> getList();
}
