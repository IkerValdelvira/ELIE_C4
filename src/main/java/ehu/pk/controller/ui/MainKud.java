package ehu.pk.controller.ui;

import ehu.pk.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import javax.xml.transform.sax.SAXSource;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainKud implements Initializable {

    private Main mainApp;

    @FXML
    private GridPane tableroaPane;

    @FXML
    private Button btnZut0;

    @FXML
    private Button btnZut1;

    @FXML
    private Button btnZut2;

    @FXML
    private Button btnZut3;

    @FXML
    private Button btnZut4;

    @FXML
    private Button btnZut5;

    @FXML
    private Button btnZut6;

    @FXML
    private Button btnZut7;

    @FXML
    private Button btnZut8;

    private String[][] tableroa;
    private int turnoa;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        turnoa = 0;
        tableroa = new String[6][9];
        for(int i=0; i<tableroa.length; i++){
            for(int j=0; j<tableroa[0].length; j++){
                tableroa[i][j] = "Z";
            }
        }

        for(int i=1; i<tableroaPane.getRowCount(); i++) {
            for (int j = 0; j < tableroaPane.getColumnCount(); j++) {
                Image image = new Image("FitxaZuria.png");
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(80);
                imageView.setFitWidth(79);
                tableroaPane.setAlignment(Pos.CENTER);
                tableroaPane.add(imageView, j, i);
                tableroaPane.setHalignment(imageView, HPos.CENTER);
            }
        }

        botoienKoloreaAldatu();
    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClickZut0(ActionEvent actionEvent){
        int errenkada = kokapenErrenkadaBilatu(0);
        fitxaKokatu(errenkada,0);
        if(errenkada == 0){
            btnZut0.setDisable(true);
        }
        botoienKoloreaAldatu();
    }

    @FXML
    public void onClickZut1(ActionEvent actionEvent){
        int errenkada = kokapenErrenkadaBilatu(1);
        fitxaKokatu(errenkada,1);
        if(errenkada == 0){
            btnZut1.setDisable(true);
        }
        botoienKoloreaAldatu();
    }

    @FXML
    public void onClickZut2(ActionEvent actionEvent){
        int errenkada = kokapenErrenkadaBilatu(2);
        fitxaKokatu(errenkada,2);
        if(errenkada == 0){
            btnZut2.setDisable(true);
        }
        botoienKoloreaAldatu();
    }

    @FXML
    public void onClickZut3(ActionEvent actionEvent){
        int errenkada = kokapenErrenkadaBilatu(3);
        fitxaKokatu(errenkada,3);
        if(errenkada == 0){
            btnZut3.setDisable(true);
        }
        botoienKoloreaAldatu();
    }

    @FXML
    public void onClickZut4(ActionEvent actionEvent){
        int errenkada = kokapenErrenkadaBilatu(4);
        fitxaKokatu(errenkada,4);
        if(errenkada == 0){
            btnZut4.setDisable(true);
        }
        botoienKoloreaAldatu();
    }

    @FXML
    public void onClickZut5(ActionEvent actionEvent){
        int errenkada = kokapenErrenkadaBilatu(5);
        fitxaKokatu(errenkada,5);
        if(errenkada == 0){
            btnZut5.setDisable(true);
        }
        botoienKoloreaAldatu();
    }

    @FXML
    public void onClickZut6(ActionEvent actionEvent){
        int errenkada = kokapenErrenkadaBilatu(6);
        fitxaKokatu(errenkada,6);
        if(errenkada == 0){
            btnZut6.setDisable(true);
        }
        botoienKoloreaAldatu();
    }

    @FXML
    public void onClickZut7(ActionEvent actionEvent){
        int errenkada = kokapenErrenkadaBilatu(7);
        fitxaKokatu(errenkada,7);
        if(errenkada == 0){
            btnZut7.setDisable(true);
        }
        botoienKoloreaAldatu();
    }

    @FXML
    public void onClickZut8(ActionEvent actionEvent){
        int errenkada = kokapenErrenkadaBilatu(8);
        fitxaKokatu(errenkada,8);
        if(errenkada == 0){
            btnZut8.setDisable(true);
        }
        botoienKoloreaAldatu();
    }

    private int kokapenErrenkadaBilatu(int pZut){
        int i = tableroa.length-1;
        while(i>0 && !tableroa[i][pZut].equals("Z")){
            i--;
        }
        return i;
    }

    private void fitxaKokatu(int pErrenkada, int pZutabea){
        Image image;
        if(turnoa == 0){
            tableroa[pErrenkada][pZutabea] = "G";
            image = new Image("FitxaGorria.png");
        }
        else{
            tableroa[pErrenkada][pZutabea] = "H";
            image = new Image("FitxaHoria.png");
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(79);
        tableroaPane.setAlignment(Pos.CENTER);
        tableroaPane.add(imageView, pZutabea, pErrenkada+1);
        tableroaPane.setHalignment(imageView, HPos.CENTER);
        if(turnoa == 0){
            turnoa = 1;
        }
        else{
            turnoa = 0;
        }
    }

    private void botoienKoloreaAldatu(){
        if(turnoa == 0){
            btnZut0.setStyle("-fx-background-color: #ff0600");
            btnZut1.setStyle("-fx-background-color: #ff0600");
            btnZut2.setStyle("-fx-background-color: #ff0600");
            btnZut3.setStyle("-fx-background-color: #ff0600");
            btnZut4.setStyle("-fx-background-color: #ff0600");
            btnZut5.setStyle("-fx-background-color: #ff0600");
            btnZut6.setStyle("-fx-background-color: #ff0600");
            btnZut7.setStyle("-fx-background-color: #ff0600");
            btnZut8.setStyle("-fx-background-color: #ff0600");
        }
        else{
            btnZut0.setStyle("-fx-background-color: #fff700");
            btnZut1.setStyle("-fx-background-color: #fff700");
            btnZut2.setStyle("-fx-background-color: #fff700");
            btnZut3.setStyle("-fx-background-color: #fff700");
            btnZut4.setStyle("-fx-background-color: #fff700");
            btnZut5.setStyle("-fx-background-color: #fff700");
            btnZut6.setStyle("-fx-background-color: #fff700");
            btnZut7.setStyle("-fx-background-color: #fff700");
            btnZut8.setStyle("-fx-background-color: #fff700");
        }
    }

}