package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO;
import com.example.sae204.Modele.Etudiant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class EtudiantsinfoController extends Controller implements Initializable {
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

    public void retour(ActionEvent event){
        GoToPage("EtudiantView.fxml", "Accueil");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        String mail = "";
        try {
            mail = DAO.mail(num_etu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        adressemaillabel.setText(mail);

    }
}
