package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO.DAO;
import com.example.sae204.Modele.DAO.DAOGroupe;
import com.example.sae204.Modele.Etudiant;
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

public class PersonnelTrombiController extends Controller implements Initializable{

    public static String num_etu;

    public String groupeParent;
    //Déclaration des images du trombinoscope

    public static String CurrentGroupeParent;
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
    Etudiant etu1, etu2, etu3, etu4, etu5, etu6, etu7, etu8, etu9, etu10, etu11, etu12, etu13, etu14, etu15, etu16, etu17, etu18, etu19, etu20, etu21, etu22, etu23, etu24;

    private LinkedList<Groupe> listGroup= DAOGroupe.listerGrp();
    LinkedList<Etudiant> listEtu=new LinkedList<>();


    public PersonnelTrombiController() throws MalformedURLException, SQLException, ClassNotFoundException {
    }

    @FXML
    public void retour(){
        if(ChoixRoleController.choixRole.equals("Secrétariat")) {
            GoToPage("SecretaireAcc.fxml", "Accueil secrétaire");
        }
        else if(ChoixRoleController.choixRole.equals("Enseignant")){
            GoToPage("EnseignantAcc.fxml", "Accueil enseignant");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listGroupe.setValue(CurrentGroupeParent);
        String mail ="";
        try {
            mail = DAO.mail(ConnexionController.Harpege);
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
        try {

            listEtu=Controller.chercherEtuGroupePromo(CurrentGroupeParent);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        afficherPhoto(listEtu);


    }
    public void cacherPhoto(int n){
        if(n>0) {
            image24.setOpacity(0);
            prenom24.setOpacity(0);
            nom24.setOpacity(0);
            etu24=null;
        }
        if(n>1) {
            image23.setOpacity(0);
            prenom23.setOpacity(0);
            nom23.setOpacity(0);
            etu23=null;
        }
        if(n>2) {
            image22.setOpacity(0);
            prenom22.setOpacity(0);
            nom22.setOpacity(0);
            etu22=null;
        }
        if(n>3) {
            image21.setOpacity(0);
            prenom21.setOpacity(0);
            nom21.setOpacity(0);
            etu21=null;
        }
        if(n>4) {
            image20.setOpacity(0);
            prenom20.setOpacity(0);
            nom20.setOpacity(0);
            etu20=null;
        }
        if(n>5) {
            image19.setOpacity(0);
            prenom19.setOpacity(0);
            nom19.setOpacity(0);
            etu19=null;
        }
        if(n>6) {
            image18.setOpacity(0);
            prenom18.setOpacity(0);
            nom18.setOpacity(0);
            etu18=null;
        }
        if(n>7) {
            image17.setOpacity(0);
            prenom17.setOpacity(0);
            nom17.setOpacity(0);
            etu17=null;
        }
        if(n>8) {
            image16.setOpacity(0);
            prenom16.setOpacity(0);
            nom16.setOpacity(0);
            etu16=null;
        }
        if(n>9) {
            image15.setOpacity(0);
            prenom15.setOpacity(0);
            nom15.setOpacity(0);
            etu15=null;
        }
        if(n>10) {
            image14.setOpacity(0);
            prenom14.setOpacity(0);
            nom14.setOpacity(0);
            etu14=null;
        }
        if(n>11) {
            image13.setOpacity(0);
            prenom13.setOpacity(0);
            nom13.setOpacity(0);
            etu13=null;
        }
        if(n>12) {
            image12.setOpacity(0);
            prenom12.setOpacity(0);
            nom12.setOpacity(0);
            etu12=null;
        }
        if(n>13) {
            image11.setOpacity(0);
            prenom11.setOpacity(0);
            nom11.setOpacity(0);
            etu11=null;
        }
        if(n>14) {
            image10.setOpacity(0);
            prenom10.setOpacity(0);
            nom10.setOpacity(0);
            etu10=null;
        }
        if(n>15) {
            image9.setOpacity(0);
            prenom9.setOpacity(0);
            nom9.setOpacity(0);
            etu9=null;
        }
        if(n>16) {
            image8.setOpacity(0);
            prenom8.setOpacity(0);
            nom8.setOpacity(0);
            etu8=null;
        }
        if(n>17) {
            image7.setOpacity(0);
            prenom7.setOpacity(0);
            nom7.setOpacity(0);
            etu7=null;
        }
        if(n>18) {
            image6.setOpacity(0);
            prenom6.setOpacity(0);
            nom6.setOpacity(0);
            etu6=null;
        }
        if(n>19) {
            image5.setOpacity(0);
            prenom5.setOpacity(0);
            nom5.setOpacity(0);
            etu5=null;
        }
        if(n>20) {
            image4.setOpacity(0);
            prenom4.setOpacity(0);
            nom4.setOpacity(0);
            etu4=null;
        }
        if(n>21) {
            image3.setOpacity(0);
            prenom3.setOpacity(0);
            nom3.setOpacity(0);
            etu3=null;
        }
        if(n>22) {
            image2.setOpacity(0);
            prenom2.setOpacity(0);
            nom2.setOpacity(0);
            etu2=null;
        }
        if(n>23) {
            image1.setOpacity(0);
            prenom1.setOpacity(0);
            nom1.setOpacity(0);
            etu1=null;
        }


    }
    public void montrerPhoto(int n){
        Etudiant etu;
        if(n>0) {
            image1.setOpacity(100);
            prenom1.setOpacity(100);
            nom1.setOpacity(100);
            etu=listEtu.poll();
            try {
                image1.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom1.setText(etu.getPrenom_etu());
            nom1.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu1=etu;
        }
        if(n>1) {
            image2.setOpacity(100);
            prenom2.setOpacity(100);
            nom2.setOpacity(100);
            etu=listEtu.poll();
            try {
                image2.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom2.setText(etu.getPrenom_etu());
            nom2.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu2=etu;
        }
        if(n>2) {
            image3.setOpacity(100);
            prenom3.setOpacity(100);
            nom3.setOpacity(100);
            etu=listEtu.poll();
            try {
                image3.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom3.setText(etu.getPrenom_etu());
            nom3.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu3=etu;
        }
        if(n>3) {
            image4.setOpacity(100);
            prenom4.setOpacity(100);
            nom4.setOpacity(100);
            etu=listEtu.poll();
            try {
                image4.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom4.setText(etu.getPrenom_etu());
            nom4.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu4=etu;
        }
        if(n>4) {
            image5.setOpacity(100);
            prenom5.setOpacity(100);
            nom5.setOpacity(100);
            etu=listEtu.poll();
            try {
                image5.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom5.setText(etu.getPrenom_etu());
            nom5.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu5=etu;
        }
        if(n>5) {
            image6.setOpacity(100);
            prenom6.setOpacity(100);
            nom6.setOpacity(100);
            etu=listEtu.poll();
            try {
                image6.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom6.setText(etu.getPrenom_etu());
            nom6.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu6=etu;
        }
        if(n>6) {
            image7.setOpacity(100);
            prenom7.setOpacity(100);
            nom7.setOpacity(100);
            etu=listEtu.poll();
            try {
                image7.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom7.setText(etu.getPrenom_etu());
            nom7.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu7=etu;
        }
        if(n>7) {
            image8.setOpacity(100);
            prenom8.setOpacity(100);
            nom8.setOpacity(100);
            etu=listEtu.poll();
            try {
                image8.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom8.setText(etu.getPrenom_etu());
            nom8.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu8=etu;
        }
        if(n>8) {
            image9.setOpacity(100);
            prenom9.setOpacity(100);
            nom9.setOpacity(100);
            etu=listEtu.poll();
            try {
                image9.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom9.setText(etu.getPrenom_etu());
            nom9.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu9=etu;
        }
        if(n>9) {
            image10.setOpacity(100);
            prenom10.setOpacity(100);
            nom10.setOpacity(100);
            etu=listEtu.poll();
            try {
                image10.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom10.setText(etu.getPrenom_etu());
            nom10.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu10=etu;
        }
        if(n>10) {
            image11.setOpacity(100);
            prenom11.setOpacity(100);
            nom11.setOpacity(100);
            etu=listEtu.poll();
            try {
                image11.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom11.setText(etu.getPrenom_etu());
            nom11.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu11=etu;
        }
        if(n>11) {
            image12.setOpacity(100);
            prenom12.setOpacity(100);
            nom12.setOpacity(100);
            etu=listEtu.poll();
            try {
                image12.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom12.setText(etu.getPrenom_etu());
            nom12.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu12=etu;
        }
        if(n>12) {
            image13.setOpacity(100);
            prenom13.setOpacity(100);
            nom13.setOpacity(100);
            etu=listEtu.poll();
            try {
                image13.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom13.setText(etu.getPrenom_etu());
            nom13.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu13=etu;
        }
        if(n>13) {
            image14.setOpacity(100);
            prenom14.setOpacity(100);
            nom14.setOpacity(100);
            etu=listEtu.poll();
            try {
                image14.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom14.setText(etu.getPrenom_etu());
            nom14.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu14=etu;
        }
        if(n>14) {
            image15.setOpacity(100);
            prenom15.setOpacity(100);
            nom15.setOpacity(100);
            etu=listEtu.poll();
            try {
                image15.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom15.setText(etu.getPrenom_etu());
            nom15.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu15=etu;
        }
        if(n>15) {
            image16.setOpacity(100);
            prenom16.setOpacity(100);
            nom16.setOpacity(100);
            etu=listEtu.poll();
            try {
                image16.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom16.setText(etu.getPrenom_etu());
            nom16.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu16=etu;
        }
        if(n>16) {
            image17.setOpacity(100);
            prenom17.setOpacity(100);
            nom17.setOpacity(100);
            etu=listEtu.poll();
            try {
                image17.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom17.setText(etu.getPrenom_etu());
            nom17.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu17=etu;
        }
        if(n>17) {
            image18.setOpacity(100);
            prenom18.setOpacity(100);
            nom18.setOpacity(100);
            etu=listEtu.poll();
            try {
                image18.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom18.setText(etu.getPrenom_etu());
            nom18.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu18=etu;
        }
        if(n>18) {
            image19.setOpacity(100);
            prenom19.setOpacity(100);
            nom19.setOpacity(100);
            etu=listEtu.poll();
            try {
                image19.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom19.setText(etu.getPrenom_etu());
            nom19.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu19=etu;
        }
        if(n>19) {
            image20.setOpacity(100);
            prenom20.setOpacity(100);
            nom20.setOpacity(100);
            etu=listEtu.poll();
            try {
                image20.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom20.setText(etu.getPrenom_etu());
            nom20.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu20=etu;
        }
        if(n>20) {
            image21.setOpacity(100);
            prenom21.setOpacity(100);
            nom21.setOpacity(100);
            etu=listEtu.poll();
            try {
                image21.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom21.setText(etu.getPrenom_etu());
            nom21.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu21=etu;
        }
        if(n>21) {
            image22.setOpacity(100);
            prenom22.setOpacity(100);
            nom22.setOpacity(100);
            etu=listEtu.poll();
            try {
                image22.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom22.setText(etu.getPrenom_etu());
            nom22.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu22=etu;
        }
        if(n>22) {
            image23.setOpacity(100);
            prenom23.setOpacity(100);
            nom23.setOpacity(100);
            etu=listEtu.poll();
            try {
                image23.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom23.setText(etu.getPrenom_etu());
            nom23.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu23=etu;
        }
        if(n>23) {
            image24.setOpacity(100);
            prenom24.setOpacity(100);
            nom24.setOpacity(100);
            etu=listEtu.poll();
            try {
                image24.setImage(new Image(new FileInputStream("SAE204/src/main/resources/com/example/sae204/image/PhotoEtudiant/"+etu.getPhoto_etu())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prenom24.setText(etu.getPrenom_etu());
            nom24.setText(etu.getNom_etu());
            listEtu.add(etu);
            etu24=etu;
        }


    }

    private  int verif(){

        if(!(listGroupe.getValue()==null|| listGroupe.getValue().equals("AUCUN"))&&(listGroupeEnfant.getValue()==null|| listGroupeEnfant.getValue().equals("AUCUN"))){

            return 0;

        }
        else if(!(listGroupe.getValue()==null|| listGroupe.getValue().equals("AUCUN"))&&!(listGroupeEnfant.getValue()==null|| listGroupeEnfant.getValue().equals("AUCUN"))){

            return 2;
        }

        return 1;
    }

    void ChampGroupeParent () throws SQLException, ClassNotFoundException {
        listGroupe.getItems().addAll(DAOGroupe.ListGrpParent());

        listGroupe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(verif()==0){
                    CurrentGroupeParent = String.valueOf(listGroupe.getValue());
                }
                else if (verif()==2){
                    CurrentGroupeParent=String.valueOf(listGroupeEnfant.getValue());
                }


                try {
                    listEtu = chercherEtuGroupePromo(CurrentGroupeParent);
                    afficherPhoto(listEtu);


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                listGroupeEnfant.getItems().clear();
                DAO.listGrpAffilGrpParents.clear();

                try {
                    listGroupeEnfant.getItems().addAll(DAOGroupe.ListGrpAffilGrpParent(CurrentGroupeParent));
                    listGroupeEnfant.getItems().add("AUCUN");
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                listGroupeEnfant.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                        if(verif()==0){
                            CurrentGroupe = String.valueOf(listGroupe.getValue());
                        }
                        else if (verif()==2){
                            CurrentGroupe=String.valueOf(listGroupeEnfant.getValue());
                        }

                        try {
                            listEtu = chercherEtuGroupePromo(CurrentGroupe);
                            afficherPhoto(listEtu);

                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        });
    }
    public void afficherPhoto(LinkedList<Etudiant> listEtu){
        cacherPhoto(24-listEtu.size());
        montrerPhoto(listEtu.size());
    }
    @FXML
    public void infoEtu1(){
        if(etu1!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu1.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu2(){
        if(etu2!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu2.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu3(){
        if(etu3!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu3.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu4(){
        if(etu4!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu4.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu5(){
        if(etu5!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu5.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu6(){
        if(etu6!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu6.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu7(){
        if(etu7!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu7.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu8(){
        if(etu8!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu8.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu9(){
        if(etu9!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu9.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu10(){
        if(etu10!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu10.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu11(){
        if(etu11!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu11.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu12(){
        if(etu12!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu12.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu13(){
        if(etu13!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu13.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu14(){
        if(etu14!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu14.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu15(){
        if(etu15!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu15.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu16(){
        if(etu16!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu16.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu17(){
        if(etu17!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu17.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu18(){
        if(etu18!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu18.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu19(){
        if(etu19!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu19.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu20(){
        if(etu20!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu20.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu21(){
        if(etu21!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu21.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu22(){
        if(etu22!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu22.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu23(){
        if(etu23!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu23.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
    @FXML
    public void infoEtu24(){
        if(etu24!=null) {
            PersonnelEtudiantsinfoController.num_etu = etu24.getNum_etu();
            GoToPage("InfoEtu.fxml", "Informations de l'étudiant");
        }
    }
}