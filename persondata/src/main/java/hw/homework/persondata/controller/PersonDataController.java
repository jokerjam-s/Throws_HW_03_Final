package hw.homework.persondata.controller;

import hw.homework.persondata.data.PersonData;
import hw.homework.persondata.exceptions.PersonDataExceptions;
import hw.homework.persondata.services.PersonDataParse;
import hw.homework.persondata.services.PersonDataSave;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class PersonDataController {
    private final String dataPath = File.separator + "saving" + File.separator;
    private final PersonDataParse dataParse = new PersonDataParse();
    private final PersonDataSave dataSave = new PersonDataSave(dataPath);

    // блок ссылок на контролы
    @FXML
    private TextArea txtLog;
    @FXML
    private TextField textData;
    @FXML
    private TableView tableData;
    @FXML
    private TableColumn<PersonData, String> colSurName;
    @FXML
    private TableColumn<PersonData, String> colFilrstName;
    @FXML
    private TableColumn<PersonData, String> colSecondName;
    @FXML
    private TableColumn<PersonData, LocalDate> colBirthDate;
    @FXML
    private TableColumn<PersonData, String> colPhone;
    @FXML
    private TableColumn<PersonData, String> colGender;

    /**
     * вывод лог информации и сообщений пользователю
     * @param message   - выводимое сообщение
     */
    private void logInfo(String message) {
        txtLog.appendText(message + "\n");
    }

    /**
     * Добавление информации в таблицу отобоажения
     * @param data  - объект с отображаемыми данными
     */
    private void fillTable(PersonData data){
        colSurName.setCellValueFactory(new PropertyValueFactory<PersonData, String>("surName"));
        colFilrstName.setCellValueFactory(new PropertyValueFactory<PersonData, String>("firstName"));
        colSecondName.setCellValueFactory(new PropertyValueFactory<PersonData, String>("secondName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<PersonData, String>("phone"));
        colBirthDate.setCellValueFactory(new PropertyValueFactory<PersonData, LocalDate>("birthDate"));
        colGender.setCellValueFactory(new PropertyValueFactory<PersonData, String>("gender"));

    }

    /**
     * обработчик нажатия кнопки Ok
     */
    @FXML
    private void onButtonOkClick() {
        String data = textData.getText();

        try {
            // парсим строку
            PersonData personData = dataParse.parsePersonDate(data);
            // отображаем данные

            // сохраняем
            dataSave.saveDataToFile(personData);
        } catch (PersonDataExceptions | IOException e) {
            logInfo(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
