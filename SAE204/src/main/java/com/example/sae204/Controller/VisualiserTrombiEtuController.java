package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class VisualiserTrombiEtuController extends Controller implements Initializable{

    public static String num_etu;

    @FXML
    ImageView image1=new ImageView();
    @FXML
    private Label adressemaillabel;

    //Image image=new Image(new URL("@image/PhotoEtudiant/ElisabethBlanchard.png"));

    public VisualiserTrombiEtuController() throws MalformedURLException{
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String mail ="";
        try {
            mail = DAO.mail(num_etu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        adressemaillabel.setText(mail);

    }
}
