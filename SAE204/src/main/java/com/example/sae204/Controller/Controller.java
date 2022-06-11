package com.example.sae204.Controller;

import com.example.sae204.EtudiantAPK;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class Controller {
    static void GoToPage(String fichier_fxml, String nom) {
        FXMLLoader fxml = new FXMLLoader(EtudiantAPK.class.getResource(fichier_fxml));
        Scene scene = null;
        try {
            scene = new Scene(fxml.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        EtudiantAPK.stage.setResizable(false);
        EtudiantAPK.stage.setTitle(nom);
        EtudiantAPK.stage.setScene(scene);
        EtudiantAPK.stage.show();

    }
}
