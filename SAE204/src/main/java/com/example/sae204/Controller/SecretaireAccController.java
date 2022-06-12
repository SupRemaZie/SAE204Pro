package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO;
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
import java.util.ResourceBundle;

public class SecretaireAccController extends Controller implements Initializable {

    @FXML
    private Label GroupeSelected;

    private String CurrentGroupe;

    @FXML
    private Label ParentSelected;
    @FXML
    private ListView<String> GroupeList;

    @FXML
    private ListView<String> GrpParentList;

    @FXML
    void onDisconnectButtonClick(ActionEvent event) {
        GoToPage("Accueil.fxml", "Accueil");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            for(Groupe grp : DAO.listerGrp()){
                GroupeList.getItems().add(grp.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        GroupeList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                CurrentGroupe=GroupeList.getSelectionModel().getSelectedItem();
                GroupeSelected.setText(CurrentGroupe);
            }
        });
    }
}
