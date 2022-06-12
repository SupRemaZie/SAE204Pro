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

    @FXML
    private Label GroupeSelected;
    @FXML
    private ListView<String> GrouParentList;

    private String CurrentGroupe;

    @FXML
    private Label ParentSelected;
    @FXML
    private ListView<String> GroupeList;



    @FXML
    void onDisconnectButtonClick(ActionEvent event) {
        GoToPage("Accueil.fxml", "Accueil");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ChampGroupeParent();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void ChampGroupeParent () throws SQLException, ClassNotFoundException {
        GrouParentList.getItems().addAll(DAO.ListGrpParent());

        GrouParentList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                CurrentGroupe = GrouParentList.getSelectionModel().getSelectedItem();

                ParentSelected.setText(CurrentGroupe);
                try {
                    for(String grp : DAO.ListGrpAffilGrpParent(CurrentGroupe)){
                        GroupeList.getItems().add(grp);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }



            }
        });
    }

}
