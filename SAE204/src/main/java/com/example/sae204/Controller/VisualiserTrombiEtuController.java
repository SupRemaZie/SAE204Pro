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

    //Déclaration des images du trombinoscope
    @FXML
    ImageView image1=new ImageView();
    @FXML
    ImageView image2=new ImageView();
    @FXML
    ImageView image3=new ImageView();
    @FXML
    ImageView image4=new ImageView();
    @FXML
    ImageView image5=new ImageView();
    @FXML
    ImageView image6=new ImageView();
    @FXML
    ImageView image7=new ImageView();
    @FXML
    ImageView image8=new ImageView();
    @FXML
    ImageView image9=new ImageView();
    @FXML
    ImageView image10=new ImageView();
    @FXML
    ImageView image11=new ImageView();
    @FXML
    ImageView image12=new ImageView();
    @FXML
    ImageView image13=new ImageView();
    @FXML
    ImageView image14=new ImageView();
    @FXML
    ImageView image15=new ImageView();
    @FXML
    ImageView image16=new ImageView();
    @FXML
    ImageView image17=new ImageView();
    @FXML
    ImageView image18=new ImageView();
    @FXML
    ImageView image19=new ImageView();
    @FXML
    ImageView image20=new ImageView();
    @FXML
    ImageView image21=new ImageView();
    @FXML
    ImageView image22=new ImageView();
    @FXML
    ImageView image23=new ImageView();
    @FXML
    ImageView image24=new ImageView();

    //Déclaration des labels pour les noms
    @FXML
    Label nom1=new Label();
    @FXML
    Label nom2=new Label();
    @FXML
    Label nom3=new Label();
    @FXML
    Label nom4=new Label();
    @FXML
    Label nom5=new Label();
    @FXML
    Label nom6=new Label();
    @FXML
    Label nom7=new Label();
    @FXML
    Label nom8=new Label();
    @FXML
    Label nom9=new Label();
    @FXML
    Label nom10=new Label();
    @FXML
    Label nom11=new Label();
    @FXML
    Label nom12=new Label();
    @FXML
    Label nom13=new Label();
    @FXML
    Label nom14=new Label();
    @FXML
    Label nom15=new Label();
    @FXML
    Label nom16=new Label();
    @FXML
    Label nom17=new Label();
    @FXML
    Label nom18=new Label();
    @FXML
    Label nom19=new Label();
    @FXML
    Label nom20=new Label();
    @FXML
    Label nom21=new Label();
    @FXML
    Label nom22=new Label();
    @FXML
    Label nom23=new Label();
    @FXML
    Label nom24=new Label();

    //Déclaration des labels pour les prénoms
    @FXML
    Label prenom1=new Label();
    @FXML
    Label prenom2=new Label();
    @FXML
    Label prenom3=new Label();
    @FXML
    Label prenom4=new Label();
    @FXML
    Label prenom5=new Label();
    @FXML
    Label prenom6=new Label();
    @FXML
    Label prenom7=new Label();
    @FXML
    Label prenom8=new Label();
    @FXML
    Label prenom9=new Label();
    @FXML
    Label prenom10=new Label();
    @FXML
    Label prenom11=new Label();
    @FXML
    Label prenom12=new Label();
    @FXML
    Label prenom13=new Label();
    @FXML
    Label prenom14=new Label();
    @FXML
    Label prenom15=new Label();
    @FXML
    Label prenom16=new Label();
    @FXML
    Label prenom17=new Label();
    @FXML
    Label prenom18=new Label();
    @FXML
    Label prenom19=new Label();
    @FXML
    Label prenom20=new Label();
    @FXML
    Label prenom21=new Label();
    @FXML
    Label prenom22=new Label();
    @FXML
    Label prenom23=new Label();
    @FXML
    Label prenom24=new Label();

    @FXML
    private Label adressemaillabel;

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
    public void cacherPhoto(int n){

    }
}
