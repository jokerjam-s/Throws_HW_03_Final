module hw.homework.persondata {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens hw.homework.persondata to javafx.fxml;
    exports hw.homework.persondata;
    opens hw.homework.persondata.controller to javafx.fxml;
    exports hw.homework.persondata.controller;

    opens hw.homework.persondata.data to javafx.base;
}