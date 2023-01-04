package hw.homework.persondata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PersonDataApplication extends Application {
    // Заголовок прилодения
    private final String titleApplication = "GB - Исключения, итоговый проект.";


    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PersonDataApplication.class.getResource("main-window.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle(titleApplication);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}
