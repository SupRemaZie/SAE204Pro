package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreerGroupeController extends Controller implements Initializable {
    private static String CurrentGroupeParent;
    private static String CurrentGroupe;

    @FXML
    private Button AjouterEtudiantButton;

    @FXML
    private ListView<String> GrouParentList;

    @FXML
    private ListView<String> GroupeList;

    @FXML
    private Label GroupeSelected;

    @FXML
    private TextField NomTextField;

    @FXML
    private Label ParentSelected;

    @FXML
    private Button ValiderButton;

    public void onValiderButtonClick(ActionEvent event) {

    }

    public void onAjouterEtudiantButtonClick(ActionEvent event) {
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
                CurrentGroupeParent = GrouParentList.getSelectionModel().getSelectedItem();

                ParentSelected.setText(CurrentGroupeParent);
                GroupeList.getItems().clear();

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
}
