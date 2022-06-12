package com.example.sae204.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class VisualiserTrombiEtuController extends Controller{
    @FXML
    ImageView image1=new ImageView();

    //Image image=new Image(new URL("@image/PhotoEtudiant/ElisabethBlanchard.png"));

    public VisualiserTrombiEtuController() throws MalformedURLException {
    }

    @FXML
    public void retour(ActionEvent event){
        GoToPage("EtudiantView.fxml", "Accueil etudiant");
    }
    @FXML
    public void rechercherEtu(ActionEvent event){

    }
    @FXML
    public void afficherImage(ActionEvent event){
        try {
            image1.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/ElisabethBlanchard.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
