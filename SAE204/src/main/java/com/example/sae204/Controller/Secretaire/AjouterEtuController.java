package com.example.sae204.Controller.Secretaire;

import com.example.sae204.Controller.Controller;
import com.example.sae204.Modele.DAO.DAO;

import com.example.sae204.Modele.DAO.DAOGroupe;
import com.example.sae204.Modele.Etudiant;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.ResourceBundle;


public class AjouterEtuController extends Controller implements Initializable {
    public static String Harpege;
    public static String CurrentGroupeParent1;
    public static String NouveauGroupe1;
    public static LinkedList <Etudiant>nouveauGroupeliste = new LinkedList<Etudiant>();
    @FXML
    public Button retour;

    @FXML
    private Label adressemaillabel;

    @FXML
    private Label CurrentGroupeParent;

    @FXML
    public Label NouveauGroupe;
    @FXML
    public  ListView<Etudiant> ListEtuGroupeSelect;

    @FXML
    private ListView<Etudiant> ListEtuNewGrp;



    @FXML
    private ComboBox<String> listGroupeEnfant;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListEtuGroupeSelect.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
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

        ListEtuGroupeSelect.getItems().setAll(chercherEtuGroupePromo(CurrentGroupeParent1));


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

        Etudiant  etuSelect = ListEtuGroupeSelect.getSelectionModel().getSelectedItem();

        ListEtuNewGrp.getItems().addAll(etuSelect);
    }

    public void OnValiderButtonClick(ActionEvent event) {
        nouveauGroupeliste.addAll(ListEtuNewGrp.getItems());
        GoToPage("Creergroupe.fxml","Créer un groupe");
    }

    public void onRemoveAllButtonClick(ActionEvent event) {
        ListEtuNewGrp.getItems().clear();
    }

    public void onRemoveSingleButtonClick(ActionEvent event) {
        Etudiant etuSelect = ListEtuNewGrp.getSelectionModel().getSelectedItem();
        ListEtuNewGrp.getItems().remove(etuSelect);
    }
}
