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
    exports com.example.sae204.Modele.DAO;
    opens com.example.sae204.Modele.DAO to javafx.fxml;
    exports com.example.sae204.Controller.Accueil;
    opens com.example.sae204.Controller.Accueil to javafx.fxml;
    exports com.example.sae204.Controller.Secretaire;
    opens com.example.sae204.Controller.Secretaire to javafx.fxml;
    exports com.example.sae204.Controller.Enseignant;
    opens com.example.sae204.Controller.Enseignant to javafx.fxml;
    exports com.example.sae204.Controller.Etudiant;
    opens com.example.sae204.Controller.Etudiant to javafx.fxml;
    exports com.example.sae204.Controller.Personnel;
    opens com.example.sae204.Controller.Personnel to javafx.fxml;
}