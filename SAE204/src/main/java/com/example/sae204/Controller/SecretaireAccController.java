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

    private String CurrentGroupeParent;

    @FXML
    private Label adressemaillabel;
    @FXML
    private ComboBox<String> listGroupe;
    @FXML
    private ComboBox<String> listGroupeEnfant;

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

    void ChampGroupeParent () throws SQLException, ClassNotFoundException {
        listGroupe.getItems().addAll(DAO.ListGrpParent());

        listGroupe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                CurrentGroupeParent = listGroupe.getSelectionModel().getSelectedItem();
                listGroupeEnfant.getItems().clear();
                DAO.listGrpAffilGrpParents.clear();

                try {
                    listGroupeEnfant.getItems().addAll(DAO.ListGrpAffilGrpParent(CurrentGroupeParent));


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
}

