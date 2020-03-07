package ehu.pk.controller.ui;

import ehu.pk.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Stop;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MainKud implements Initializable {

    private Main mainApp;

    private int jokoModua = 0;  // 0 -> Bi jokalari      1 -> Random IA     2 -> Intelligent IA

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
    private String txanda;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        txanda = "G";       // Gorriaren txanda
        tableroa = new String[6][9];
        for(int i=0; i<tableroa.length; i++){
            for(int j=0; j<tableroa[0].length; j++){
                tableroa[i][j] = "Z";   //  Fitxa zuria
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
        if("G".equals(txanda)){
            tableroa[pErrenkada][pZutabea] = "G";
            image = new Image("FitxaGorria.png");
        }
        else if (jokoModua == 0){
            tableroa[pErrenkada][pZutabea] = "H";
            image = new Image("FitxaHoria.png");
        }
        else {
            tableroa[pErrenkada][pZutabea] = "IA";
            image = new Image("FitxaHoria.png");
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(79);
        tableroaPane.setAlignment(Pos.CENTER);
        tableroaPane.add(imageView, pZutabea, pErrenkada+1);
        tableroaPane.setHalignment(imageView, HPos.CENTER);
        Boolean irabazi=irabaziDuBertikal(pErrenkada,pZutabea, txanda);
        Boolean irabazi2=irabaziDuHorizontal(pErrenkada,pZutabea, txanda);
        Boolean irabazi3=irabaziDuDiagonal(pErrenkada,pZutabea, txanda);
        if("G".equals(txanda)){
            switch(jokoModua) {
                case 0:
                    txanda = "H";
                    break;
                case 1:
                    txanda = "IA";
                    randomIA();
                    break;
                case 2:
                    txanda = "IA";
                    intelligentIA();
                    break;
            }

        }
        else{
            txanda = "G";
        }

    }

    private void botoienKoloreaAldatu(){
        if("G".equals(txanda)){
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


    public Boolean irabaziDuBertikal(int pErrenkada, int pZutabea, String pTxanda){
        Boolean irabazi=false;
        int kont=1;
        if (pErrenkada<tableroa.length-3){
            System.out.println("Coronau");
            int i=1;
            System.out.println(tableroa[pErrenkada+i][pZutabea]);
            while ( pErrenkada+i<tableroa.length && pTxanda.equals(tableroa[pErrenkada+i][pZutabea])){
                kont++;
                i++;
            }
            if (kont==4){
                irabazi=true;
                System.out.println("irabazi duzu");

            }
        }


        return irabazi;
    }


    public Boolean irabaziDuHorizontal(int pErrenkada, int pZutabea, String pTxanda){
        Boolean irabazi=false;
        int kont=1;
        int j=1;
        while ( pZutabea+j<tableroa[0].length && pTxanda.equals(tableroa[pErrenkada][pZutabea+j])){
            kont++;
            j++;
        }
        if (kont==4){
            irabazi=true;
            System.out.println("irabazi duzu");

        }
        else{
            j=1;

            while ( pZutabea-j>=0 && pTxanda.equals(tableroa[pErrenkada][pZutabea-j])){
                kont++;
                j++;
                System.out.println(kont);
            }
            if (kont==4){
                irabazi=true;
                System.out.println("irabazi duzu");

            }
        }
        return irabazi;
    }


    private Boolean irabaziDuDiagonal(int pErrenkada, int pZutabea, String pTxanda) {
        Boolean irabazi=false;
        int kont=1;
        int i=1;
        int j=1;
        //ezkerra gora
        while ( pErrenkada-i>=1 && pZutabea-j>=0 && pTxanda.equals(tableroa[pErrenkada-i][pZutabea-j])){
            kont++;
            j++;
            i++;
        }
        if (kont==4){
            irabazi=true;
            System.out.println("irabazi duzu");

        }
        else{
            //eskuina behera
            j=1;
            i=1;
            while (pErrenkada+i<tableroa.length && pZutabea+j<tableroa[0].length && pTxanda.equals(tableroa[pErrenkada+i][pZutabea+j])){
                kont++;
                i++;
                j++;
            }
            if (kont==4){
                irabazi=true;
                System.out.println("irabazi duzu");

            }
            else{
                //eskuina gora
                j=1;
                i=1;
                while (pErrenkada-i>=1 && pZutabea+j<tableroa[0].length && pTxanda.equals(tableroa[pErrenkada-i][pZutabea+j])){
                    kont++;
                    i++;
                    j++;
                }
                if (kont==4){
                    irabazi=true;
                    System.out.println("irabazi duzu");

                }
                else{
                    //ezkerra behera
                    j=1;
                    i=1;
                    while (pErrenkada+i<tableroa.length && pZutabea-j>=0 && pTxanda.equals(tableroa[pErrenkada+i][pZutabea-j])){
                        kont++;
                        i++;
                        j++;
                    }
                    if (kont==4){
                        irabazi=true;
                        System.out.println("irabazi duzu");

                    }
                }
            }
        }

        return irabazi;
    }

    public void setJokoModua(int modu) {
        jokoModua = modu;
    }

    public void randomIA() {
        try {
            Thread.sleep(1000);     // Denbora pixka bat utziko diogu jokoa hain azkarra ez egiteko
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random r = new Random();
        int low = 0;
        int high = tableroa[0].length+1;    // +1 9.zutabea ere sartzeko
        int zutabea = r.nextInt(high-low) + low;


        int errenkada = kokapenErrenkadaBilatu(zutabea);
        System.out.println("Random IA-k aukeratutako laukia: [" + errenkada + " , " + zutabea + "]");
        fitxaKokatu(errenkada,zutabea);
        if(errenkada == 0){
            btnZut0.setDisable(true);
            btnZut1.setDisable(true);
            btnZut2.setDisable(true);
            btnZut3.setDisable(true);
            btnZut4.setDisable(true);
            btnZut5.setDisable(true);
            btnZut6.setDisable(true);
            btnZut7.setDisable(true);
            btnZut8.setDisable(true);
        }
        botoienKoloreaAldatu();

    }

    public void intelligentIA() {

    }

}