module com.example.sae204 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sae204 to javafx.fxml;
    exports com.example.sae204;
    exports com.example.sae204.Controller;
    opens com.example.sae204.Controller to javafx.fxml;
    exports com.example.sae204.Modele;
    opens com.example.sae204.Modele to javafx.fxml;
}