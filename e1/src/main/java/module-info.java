module com.e1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.e1 to javafx.fxml, javafx.base;
    exports com.e1;
}


