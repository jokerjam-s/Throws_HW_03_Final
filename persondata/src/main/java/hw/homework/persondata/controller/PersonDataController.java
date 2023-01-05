package hw.homework.persondata.controller;

import hw.homework.persondata.data.PersonData;
import hw.homework.persondata.exceptions.PersonDataExceptions;
import hw.homework.persondata.services.PersonDataList;
import hw.homework.persondata.services.PersonDataParse;
import hw.homework.persondata.services.PersonDataSave;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class PersonDataController {
    //private final String dataPath = File.separator + "saving" + File.separator;
    private final String dataPath = "saving" + File.separator;
    private final PersonDataParse dataParse = new PersonDataParse();
    private final PersonDataSave dataSave = new PersonDataSave(dataPath);

    private PersonDataList dataList = new PersonDataList();

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
     */
    private void fillTable(){
        colSurName.setCellValueFactory(new PropertyValueFactory<PersonData, String>("surName"));
        colFilrstName.setCellValueFactory(new PropertyValueFactory<PersonData, String>("firstName"));
        colSecondName.setCellValueFactory(new PropertyValueFactory<PersonData, String>("secondName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<PersonData, String>("phone"));
        colBirthDate.setCellValueFactory(new PropertyValueFactory<PersonData, LocalDate>("birthDate"));
        colGender.setCellValueFactory(new PropertyValueFactory<PersonData, String>("gender"));

        tableData.setItems(dataList.getList());
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
            dataList.append(personData);
            // сохраняем
            dataSave.saveDataToFile(personData);
            // отображаем список правильных введенных данных
            fillTable();
        } catch (PersonDataExceptions | IOException e) {
            logInfo(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
