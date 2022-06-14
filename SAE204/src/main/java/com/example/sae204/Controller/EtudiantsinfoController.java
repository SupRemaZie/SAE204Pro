package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO;
import com.example.sae204.Modele.Etudiant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class  EtudiantsinfoController extends Controller implements Initializable {
    public static String num_etu;

    @FXML
    private Label adressemaillabel;
    @FXML
    private Button retour;
    @FXML
    private Label age;
    @FXML
    private Label datedenaissance;
    @FXML
    private Label amenagement;
    @FXML
    private Label promotion;
    @FXML
    private Label groupe;
    @FXML
    private Label statut;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private ImageView photo;

    public void retour(ActionEvent event){
        GoToPage("EtudiantView.fxml", "Accueil");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        String mail = "";
        LinkedList<Etudiant> listEtu=new LinkedList<>();
        try {
            mail = DAO.mail(num_etu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        adressemaillabel.setText(mail);
        try {
            listEtu=DAO.listerEtu();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Etudiant etu : listEtu) {
            if(etu.getNum_etu().equals(num_etu)) {
                age.setText(etu.getAge_etu() + " ans");
                datedenaissance.setText(etu.getDate_etu());
                amenagement.setText(etu.getDesc_etu());
                try {
                    promotion.setText(DAO.getNomPromo(num_etu));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    statut.setText(DAO.getAmenagement(num_etu));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    groupe.setText(DAO.getGroupe(num_etu));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                nom.setText(etu.getNom_etu());
                prenom.setText(etu.getPrenom_etu());
                String recup = null;
                try {
                    recup = DAO.getPhoto(num_etu);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String photo1 = "SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+recup;
                try {
                    photo.setImage(new Image(new FileInputStream(photo1)));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
