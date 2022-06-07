module com.example.sae204 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sae204 to javafx.fxml;
    exports com.example.sae204;
}