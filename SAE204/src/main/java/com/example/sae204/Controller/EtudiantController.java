package com.example.sae204.Controller;


import com.example.sae204.Modele.MyJDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.sql.SQLException;

public class EtudiantController<detailProfil> {
    @FXML
    private Label myConnexionTitle;
    @FXML private Label myIdTitle;
    @FXML private Label myPwdTitle;
    @FXML private Label myCurrentConnexionStatusTitle;

    @FXML private Label myResultTitle;

    //Label for displaying dynamic message
    @FXML private Label myResultLabel;

    //TextField to get information from user
    @FXML private TextField myIdTextField;
    @FXML private TextField myPwdTextField;
    @FXML private TextField myTableTextField;

    //Button to connect and execute Query
    @FXML private Button myConnexionButton;
    @FXML private Button myQueryButton;
    @FXML private Button myQueryButton2;
    private Button tEleve1Button;
    @FXML
    private Button tEleve2Button;
    @FXML
    private Button tEleve3Button;
    @FXML
    private Button tEleve4Button;
    @FXML
    private Button tEleve5Button;
    @FXML
    private Button tEleve6Button;
    @FXML
    private Label detailProfil;

@FXML
    void ontEleve1ButtonClick(ActionEvent event){
       changeText(tEleve1Button);

    }
    @FXML
    void ontEleve2ButtonClick(ActionEvent event){
        changeText(tEleve2Button);

    }
    @FXML
    void ontEleve3ButtonClick(ActionEvent event){
        changeText(tEleve3Button);

    }
    @FXML
    void ontEleve4ButtonClick(ActionEvent event){
        changeText(tEleve4Button);
    }
    @FXML
    void ontEleve5ButtonClick(ActionEvent event){
        changeText(tEleve5Button);
    }
    @FXML
    void ontEleve6ButtonClick(ActionEvent event){
        changeText(tEleve6Button);
    }


    void changeText(Button textfrom ){
        detailProfil.setText(textfrom.getText());
    }

    //Label for displaying static message only
    @FXML
    void myQueryButtonOnPress2(ActionEvent event) throws ClassNotFoundException, SQLException {
        String query1="SELECT dateDebutJus, dateFinJus, ficheAbs, etatJus FROM JUSTIFICATIF WHERE numEtu='"+this.myTableTextField.getText()+"' ORDER BY dateDebutJus DESC;";

        String result1=this.myJdbc.executeReadQuery(query1);
        this.myResultLabel.setText(result1);
    }



    @FXML
    void myQueryButtonOnPress(ActionEvent event) throws ClassNotFoundException, SQLException {
        String query="SELECT dateAbs, intCoursAbs, heureAbs FROM ABSENCE INNER JOIN JUSTIFICATIF ON ABSENCE.idJus=JUSTIFICATIF.idJus INNER JOIN ETUDIANT ON ETUDIANT.numEtu=JUSTIFICATIF.numEtu WHERE ETUDIANT.numEtu='"+this.myTableTextField.getText()+"' ORDER BY dateAbs DESC, heureAbs ASC;";

        String result=this.myJdbc.executeReadQuery(query);
        this.myResultLabel.setText(result);
    }

    @FXML
    void myConnexionButtonOnPress(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (this.myConnexionButton.getText().equals("Connect")) {
            //Pour Xamp ou easyphp
            //myJdbc = new MyJDBC("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/client_voiture?serverTimezone=UTC");
            //pour SQL server
            myJdbc=new MyJDBC("com.microsoft.sqlserver.jdbc.SQLServerDriver","jdbc:sqlserver://172.30.4.243\\LHAMON;databaseName=gaudincDB");
            myJdbc.connect(this.myIdTextField.getText(), this.myPwdTextField.getText());
            this.myConnexionButton.setText("Disconnect");
            this.myCurrentConnexionStatusTitle.setText("Connected");
            this.myCurrentConnexionStatusTitle.setTextFill(Color.GREEN);

        }
        else{
            this.myConnexionButton.setText("Connect");
            myJdbc.disconnect();
            this.myCurrentConnexionStatusTitle.setText("Disconnected");
            this.myCurrentConnexionStatusTitle.setTextFill(Color.RED);
        }

    }

    private MyJDBC myJdbc;
}

