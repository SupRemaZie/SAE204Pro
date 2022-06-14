package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO;
import com.example.sae204.Modele.Groupe;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class EtudiantTrombiController extends Controller implements Initializable{

    public static String num_etu;

    //Déclaration des images du trombinoscope

    private static String CurrentGroupeParent;
    private static String CurrentGroupe;
    @FXML
    ImageView image1=new ImageView();
    @FXML
    ImageView image2=new ImageView();
    @FXML
    ImageView image3=new ImageView();
    @FXML
    ImageView image4=new ImageView();
    @FXML
    ImageView image5=new ImageView();
    @FXML
    ImageView image6=new ImageView();
    @FXML
    ImageView image7=new ImageView();
    @FXML
    ImageView image8=new ImageView();
    @FXML
    ImageView image9=new ImageView();
    @FXML
    ImageView image10=new ImageView();
    @FXML
    ImageView image11=new ImageView();
    @FXML
    ImageView image12=new ImageView();
    @FXML
    ImageView image13=new ImageView();
    @FXML
    ImageView image14=new ImageView();
    @FXML
    ImageView image15=new ImageView();
    @FXML
    ImageView image16=new ImageView();
    @FXML
    ImageView image17=new ImageView();
    @FXML
    ImageView image18=new ImageView();
    @FXML
    ImageView image19=new ImageView();
    @FXML
    ImageView image20=new ImageView();
    @FXML
    ImageView image21=new ImageView();
    @FXML
    ImageView image22=new ImageView();
    @FXML
    ImageView image23=new ImageView();
    @FXML
    ImageView image24=new ImageView();

    //Déclaration des labels pour les noms
    @FXML
    Label nom1=new Label();
    @FXML
    Label nom2=new Label();
    @FXML
    Label nom3=new Label();
    @FXML
    Label nom4=new Label();
    @FXML
    Label nom5=new Label();
    @FXML
    Label nom6=new Label();
    @FXML
    Label nom7=new Label();
    @FXML
    Label nom8=new Label();
    @FXML
    Label nom9=new Label();
    @FXML
    Label nom10=new Label();
    @FXML
    Label nom11=new Label();
    @FXML
    Label nom12=new Label();
    @FXML
    Label nom13=new Label();
    @FXML
    Label nom14=new Label();
    @FXML
    Label nom15=new Label();
    @FXML
    Label nom16=new Label();
    @FXML
    Label nom17=new Label();
    @FXML
    Label nom18=new Label();
    @FXML
    Label nom19=new Label();
    @FXML
    Label nom20=new Label();
    @FXML
    Label nom21=new Label();
    @FXML
    Label nom22=new Label();
    @FXML
    Label nom23=new Label();
    @FXML
    Label nom24=new Label();

    //Déclaration des labels pour les prénoms
    @FXML
    Label prenom1=new Label();
    @FXML
    Label prenom2=new Label();
    @FXML
    Label prenom3=new Label();
    @FXML
    Label prenom4=new Label();
    @FXML
    Label prenom5=new Label();
    @FXML
    Label prenom6=new Label();
    @FXML
    Label prenom7=new Label();
    @FXML
    Label prenom8=new Label();
    @FXML
    Label prenom9=new Label();
    @FXML
    Label prenom10=new Label();
    @FXML
    Label prenom11=new Label();
    @FXML
    Label prenom12=new Label();
    @FXML
    Label prenom13=new Label();
    @FXML
    Label prenom14=new Label();
    @FXML
    Label prenom15=new Label();
    @FXML
    Label prenom16=new Label();
    @FXML
    Label prenom17=new Label();
    @FXML
    Label prenom18=new Label();
    @FXML
    Label prenom19=new Label();
    @FXML
    Label prenom20=new Label();
    @FXML
    Label prenom21=new Label();
    @FXML
    Label prenom22=new Label();
    @FXML
    Label prenom23=new Label();
    @FXML
    Label prenom24=new Label();
    @FXML
    ComboBox<String>listGroupe;
    @FXML
    ComboBox<String>listGroupeEnfant;
    @FXML
    private Label adressemaillabel;

    private LinkedList<Groupe> listGroup=DAO.listerGrp();

    public EtudiantTrombiController() throws MalformedURLException, SQLException, ClassNotFoundException {
    }

    @FXML
    public void retour(ActionEvent event){
        GoToPage("EtudiantView.fxml", "Accueil etudiant");
    }
    @FXML
    public void rechercherEtu(ActionEvent event){

    }
    @FXML
    public void afficherImage(ActionEvent event){
        try {
            image1.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/ElisabethBlanchard.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        cacherPhoto(4);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String mail ="";
        try {
            mail = DAO.mail(num_etu);
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
    public void cacherPhoto(int n){
        if(n>0) {
            image24.setOpacity(0);
            prenom24.setOpacity(0);
            nom24.setOpacity(0);
        }
        if(n>1) {
            image23.setOpacity(0);
            prenom23.setOpacity(0);
            nom23.setOpacity(0);
        }
        if(n>2) {
            image22.setOpacity(0);
            prenom22.setOpacity(0);
            nom22.setOpacity(0);
        }
        if(n>3) {
            image21.setOpacity(0);
            prenom21.setOpacity(0);
            nom21.setOpacity(0);
        }
        if(n>4) {
            image20.setOpacity(0);
            prenom20.setOpacity(0);
            nom20.setOpacity(0);
        }
        if(n>5) {
            image19.setOpacity(0);
            prenom19.setOpacity(0);
            nom19.setOpacity(0);
        }
        if(n>6) {
            image18.setOpacity(0);
            prenom18.setOpacity(0);
            nom18.setOpacity(0);
        }
        if(n>7) {
            image17.setOpacity(0);
            prenom17.setOpacity(0);
            nom17.setOpacity(0);
        }
        if(n>8) {
            image16.setOpacity(0);
            prenom16.setOpacity(0);
            nom16.setOpacity(0);
        }
        if(n>9) {
            image15.setOpacity(0);
            prenom15.setOpacity(0);
            nom15.setOpacity(0);
        }
        if(n>10) {
            image14.setOpacity(0);
            prenom14.setOpacity(0);
            nom14.setOpacity(0);
        }
        if(n>11) {
            image13.setOpacity(0);
            prenom13.setOpacity(0);
            nom13.setOpacity(0);
        }
        if(n>12) {
            image12.setOpacity(0);
            prenom12.setOpacity(0);
            nom12.setOpacity(0);
        }
        if(n>13) {
            image11.setOpacity(0);
            prenom11.setOpacity(0);
            nom11.setOpacity(0);
        }
        if(n>14) {
            image10.setOpacity(0);
            prenom10.setOpacity(0);
            nom10.setOpacity(0);
        }
        if(n>15) {
            image9.setOpacity(0);
            prenom9.setOpacity(0);
            nom9.setOpacity(0);
        }
        if(n>16) {
            image8.setOpacity(0);
            prenom8.setOpacity(0);
            nom8.setOpacity(0);
        }
        if(n>17) {
            image7.setOpacity(0);
            prenom7.setOpacity(0);
            nom7.setOpacity(0);
        }
        if(n>18) {
            image6.setOpacity(0);
            prenom6.setOpacity(0);
            nom6.setOpacity(0);
        }
        if(n>19) {
            image5.setOpacity(0);
            prenom5.setOpacity(0);
            nom5.setOpacity(0);
        }
        if(n>20) {
            image4.setOpacity(0);
            prenom4.setOpacity(0);
            nom4.setOpacity(0);
        }
        if(n>21) {
            image3.setOpacity(0);
            prenom3.setOpacity(0);
            nom3.setOpacity(0);
        }
        if(n>22) {
            image2.setOpacity(0);
            prenom2.setOpacity(0);
            nom2.setOpacity(0);
        }
        if(n>23) {
            image1.setOpacity(0);
            prenom1.setOpacity(0);
            nom1.setOpacity(0);
        }


    }

    void ChampGroupeParent () throws SQLException, ClassNotFoundException {
        listGroupe.getItems().addAll(DAO.ListGrpParent());

        listGroupe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                CurrentGroupeParent = listGroupe.getSelectionModel().getSelectedItem();

                //--> mettre ici la fonction pour renvoyer les étudiants du groupe

                listGroupeEnfant.getItems().clear();
                DAO.listGrpAffilGrpParents.clear();

                try {
                    listGroupeEnfant.getItems().addAll(DAO.ListGrpAffilGrpParent(CurrentGroupeParent));
                    listGroupeEnfant.getItems().add("VIDE");
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                listGroupeEnfant.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                        CurrentGroupe = listGroupeEnfant.getSelectionModel().getSelectedItem();
                    }
                });
            }
        });
    }
    public void afficherPhoto(){
        String leGroupe;
        if(CurrentGroupe.equals(null)){
            leGroupe=CurrentGroupeParent;
        }
        else{
            leGroupe=CurrentGroupe;
        }
    }
}
