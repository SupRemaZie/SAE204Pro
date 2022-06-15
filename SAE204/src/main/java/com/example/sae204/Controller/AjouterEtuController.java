package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO.DAO;
import com.example.sae204.Modele.DAO.DAOEtudiant;
import com.example.sae204.Modele.DAO.DAOGroupe;
import com.example.sae204.Modele.Etudiant;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;


public class AjouterEtuController extends Controller implements Initializable {
    public static String Harpege;
    public static String CurrentGroupeParent1;
    public static String NouveauGroupe1;
    @FXML
    public Button retour;

    @FXML
    private Label adressemaillabel;

    @FXML
    private Label CurrentGroupeParent;

    @FXML
    public Label NouveauGroupe;
    @FXML
    private ListView<Etudiant> ListEtuGroupeSelect;

    @FXML
    private ListView<Etudiant> ListEtuNewGrp;



    @FXML
    private ComboBox<String> listGroupeEnfant;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ChargerLaListeEtu();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String mail = "";
        try {
            mail = DAO.mail(Harpege);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ChampGroupeParent();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        adressemaillabel.setText(mail);
        CurrentGroupeParent.setText(CurrentGroupeParent1);
        NouveauGroupe.setText(NouveauGroupe1);

    }

    private void ChampGroupeParent() throws SQLException, ClassNotFoundException {
        DAO.listGrpAffilGrpParents.clear();
        listGroupeEnfant.getItems().clear();
        listGroupeEnfant.getItems().addAll(DAOGroupe.ListGrpAffilGrpParent(CurrentGroupeParent1));
        listGroupeEnfant.getItems().add("AUCUN");
    }


    private void ChargerLaListeEtu() throws SQLException, ClassNotFoundException {
        ListEtuGroupeSelect.getItems().addAll(chercherEtuGroupePromo(CurrentGroupeParent1));
        listGroupeEnfant.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                ListEtuGroupeSelect.getItems().clear();
                String CurrentGroupeEnfant = listGroupeEnfant.getSelectionModel().getSelectedItem();
                try {
                    ListEtuGroupeSelect.getItems().addAll(Controller.chercherEtuGroupePromo(CurrentGroupeEnfant));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    public void retour(ActionEvent event){
        GoToPage("Creergroupe.fxml","Créer un groupe");
    }




    public void onAjouterButtonEtuSelectButtonClick(ActionEvent event) {
    }

    public void OnValiderButtonClick(ActionEvent event) {
    }

    public void onRemoveAllButtonClick(ActionEvent event) {
    }

    public void onRemoveSingleButtonClick(ActionEvent event) {
    }
}
