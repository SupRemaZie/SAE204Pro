package com.example.sae204.Controller;

import com.example.sae204.EtudiantAPK;
import com.example.sae204.Modele.DAO;
import com.example.sae204.Modele.Etudiant;
import com.example.sae204.Modele.Groupe;
import com.example.sae204.Modele.Promotion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SecretaireAccController extends Controller implements Initializable {
    public static String Harpege;
    @FXML
    private Label GroupeSelected;
    @FXML
    private ListView<String> GrouParentList;


    private String CurrentGroupeParent;
    private String CurrentGroupe;

    @FXML
    private Label ParentSelected;
    @FXML
    private ListView<String> GroupeList;
    @FXML
    private Label adressemaillabel;


    @FXML
    void onDisconnectButtonClick(ActionEvent event) {
        GoToPage("Accueil.fxml", "Accueil");
    }


    @FXML
    void afficherList(ActionEvent event){

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
@FXML
void afficherList(){

}
    void ChampGroupeParent () throws SQLException, ClassNotFoundException {
        GrouParentList.getItems().addAll(DAO.ListGrpParent());

        GrouParentList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                CurrentGroupeParent = GrouParentList.getSelectionModel().getSelectedItem();

                ParentSelected.setText(CurrentGroupeParent);
                GroupeList.getItems().clear();
                DAO.listGrpAffilGrpParents.clear();
                System.out.println("clear");
                try {
                    GroupeList.getItems().addAll(DAO.ListGrpAffilGrpParent(CurrentGroupeParent));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                GroupeList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                        CurrentGroupe = GroupeList.getSelectionModel().getSelectedItem();

                        GroupeSelected.setText(CurrentGroupe);
                    }
                });
            }
        });
    }

    public void onCreateGroupButtonClick(ActionEvent event) {
        GoToPage("Creer_groupe.fxml","Créer un groupe");
    }
}

