package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO.DAO;
import com.example.sae204.Modele.DAO.DAOGroupe;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

public class SecretaireAccController extends Controller implements Initializable {
    public static String Harpege;

    private String CurrentGroupeParent;

    @FXML
    private Label adressemaillabel;
    @FXML
    private ComboBox<String> listGroupe;
    @FXML
    private ComboBox<String> listGroupeEnfant;
    private String CurrentGroupeEnfant;

    @FXML
    void onDisconnectButtonClick(ActionEvent event) {
        GoToPage("Accueil.fxml", "Accueil");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String mail ="";
        try {
            mail = DAO.mail(Harpege);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        adressemaillabel.setText(mail);

        try {
            ChampGroupeParent();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public int verif(){

        if(!(listGroupe.getValue()==null|| listGroupe.getValue().equals("AUCUN"))&&(listGroupeEnfant.getValue()==null|| listGroupeEnfant.getValue().equals("AUCUN"))){
            System.out.println(" colonne de gauche");
            return 0;

        }
        else if(!(listGroupe.getValue()==null|| listGroupe.getValue().equals("AUCUN"))&&!(listGroupeEnfant.getValue()==null|| listGroupeEnfant.getValue().equals("AUCUN"))){
            System.out.println("colonne de droite ");
            return 2;
        }
        return 1;
    }

    void ChampGroupeParent () throws SQLException, ClassNotFoundException {
        listGroupe.getItems().addAll(DAOGroupe.ListGrpParent());

        listGroupe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                CurrentGroupeParent = listGroupe.getSelectionModel().getSelectedItem();
                listGroupeEnfant.getItems().clear();
                DAO.listGrpAffilGrpParents.clear();

                try {
                    listGroupeEnfant.getItems().addAll(DAOGroupe.ListGrpAffilGrpParent(CurrentGroupeParent));
                    CurrentGroupeEnfant=listGroupeEnfant.getSelectionModel().getSelectedItem();


                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                listGroupeEnfant.getItems().add("AUCUN");


            }
        });
    }

    public void onCreateGroupButtonClick(ActionEvent event) {
        CreerGroupeController.Harpege = Harpege;
        GoToPage("Creergroupe.fxml","Créer un groupe");
    }
    @FXML
    public void visualiserGr(){
        if(verif()==1){
            System.out.println("Erreur veuillez entrez un groupe");
        }
        else if(verif()==0){
            PersonnelTrombiController.CurrentGroupeParent=CurrentGroupeParent;
            GoToPage("PersonnelTrombi.fxml", "Trombinoscope des étudiants");
        }
        else {
            PersonnelTrombiController.CurrentGroupeParent=CurrentGroupeEnfant;
            GoToPage("PersonnelTrombi.fxml", "Trombinoscope des étudiants");
        }

    }
    @FXML
    public void supprimerGr(){

    }
    @FXML
    public void modifierGr(){

    }
}

