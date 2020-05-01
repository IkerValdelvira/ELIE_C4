package ehu.pk.controller.ui;

import ehu.pk.Main;
import ehu.pk.model.IntelligentIA;
import ehu.pk.model.Tableroa;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.awt.*;
import java.net.URL;
import java.util.Random;
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

    @FXML
    private TextArea taJokaldiak;

    private Tableroa tableroa;
    private Boolean[] zutabeBetetak;
    private String txanda;
    private int jokoModua = 0;  // 0 -> Bi jokalari      1 -> Random IA     2 -> Intelligent IA
    private long hasieraDenbora;
    private long bukaeraDenbora;
    private long partidaDenbora;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void hasieratu(){
        setButtonsDisable(false);
        taJokaldiak.clear();
        taJokaldiak.appendText("ONGI ETORRI Conecta 4 jokora!!!");
        taJokaldiak.appendText("\n\nJokalari GORRIAren txanda...");

        txanda = "G";       // Gorriaren txanda
        tableroa = new Tableroa();

        for(int i=1; i<tableroaPane.getRowCount(); i++) {
            for (int j = 0; j < tableroaPane.getColumnCount(); j++) {
                Image image = new Image("pictures/FitxaZuria.png");
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(80);
                imageView.setFitWidth(79);
                tableroaPane.setAlignment(Pos.CENTER);
                tableroaPane.add(imageView, j, i);
                tableroaPane.setHalignment(imageView, HPos.CENTER);
            }
        }

        zutabeBetetak = new Boolean[9];
        for(int i=0; i<zutabeBetetak.length; i++){
            zutabeBetetak[i] = false;
        }

        botoienKoloreaAldatu();

        if(jokoModua != 0){
            hasieraDenbora = System.currentTimeMillis();
        }
    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClickZut0(ActionEvent actionEvent){
        int errenkada = tableroa.kokapenErrenkadaBilatu(0);
        fitxaKokatu(errenkada,0);
        if(errenkada == 0){
            zutabeBetetak[0] = true;
            btnZut0.setDisable(true);
        }
        botoienKoloreaAldatu();
        berdinetaKonprobatu();
    }

    @FXML
    public void onClickZut1(ActionEvent actionEvent){
        int errenkada = tableroa.kokapenErrenkadaBilatu(1);
        fitxaKokatu(errenkada,1);
        if(errenkada == 0){
            zutabeBetetak[1] = true;
            btnZut1.setDisable(true);
        }
        botoienKoloreaAldatu();
        berdinetaKonprobatu();
    }

    @FXML
    public void onClickZut2(ActionEvent actionEvent){
        int errenkada = tableroa.kokapenErrenkadaBilatu(2);
        fitxaKokatu(errenkada,2);
        if(errenkada == 0){
            zutabeBetetak[2] = true;
            btnZut2.setDisable(true);
        }
        botoienKoloreaAldatu();
        berdinetaKonprobatu();
    }

    @FXML
    public void onClickZut3(ActionEvent actionEvent){
        int errenkada = tableroa.kokapenErrenkadaBilatu(3);
        fitxaKokatu(errenkada,3);
        if(errenkada == 0){
            zutabeBetetak[3] = true;
            btnZut3.setDisable(true);
        }
        botoienKoloreaAldatu();
        berdinetaKonprobatu();
    }

    @FXML
    public void onClickZut4(ActionEvent actionEvent){
        int errenkada = tableroa.kokapenErrenkadaBilatu(4);
        fitxaKokatu(errenkada,4);
        if(errenkada == 0){
            zutabeBetetak[4] = true;
            btnZut4.setDisable(true);
        }
        botoienKoloreaAldatu();
        berdinetaKonprobatu();
    }

    @FXML
    public void onClickZut5(ActionEvent actionEvent){
        int errenkada = tableroa.kokapenErrenkadaBilatu(5);
        fitxaKokatu(errenkada,5);
        if(errenkada == 0){
            zutabeBetetak[5] = true;
            btnZut5.setDisable(true);
        }
        botoienKoloreaAldatu();
        berdinetaKonprobatu();
    }

    @FXML
    public void onClickZut6(ActionEvent actionEvent){
        int errenkada = tableroa.kokapenErrenkadaBilatu(6);
        fitxaKokatu(errenkada,6);
        if(errenkada == 0){
            zutabeBetetak[6] = true;
            btnZut6.setDisable(true);
        }
        botoienKoloreaAldatu();
        berdinetaKonprobatu();
    }

    @FXML
    public void onClickZut7(ActionEvent actionEvent){
        int errenkada = tableroa.kokapenErrenkadaBilatu(7);
        fitxaKokatu(errenkada,7);
        if(errenkada == 0){
            zutabeBetetak[7] = true;
            btnZut7.setDisable(true);
        }
        botoienKoloreaAldatu();
        berdinetaKonprobatu();
    }

    @FXML
    public void onClickZut8(ActionEvent actionEvent){
        int errenkada = tableroa.kokapenErrenkadaBilatu(8);
        fitxaKokatu(errenkada,8);
        if(errenkada == 0){
            zutabeBetetak[8] = true;
            btnZut8.setDisable(true);
        }
        botoienKoloreaAldatu();
        berdinetaKonprobatu();
    }

    @FXML
    public void onClickAtera(ActionEvent actionEvent){
        mainApp.sarreraErakutsi();
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
            btnZut0.setStyle("-fx-background-color: #2e8ac6");
            btnZut1.setStyle("-fx-background-color: #2e8ac6");
            btnZut2.setStyle("-fx-background-color: #2e8ac6");
            btnZut3.setStyle("-fx-background-color: #2e8ac6");
            btnZut4.setStyle("-fx-background-color: #2e8ac6");
            btnZut5.setStyle("-fx-background-color: #2e8ac6");
            btnZut6.setStyle("-fx-background-color: #2e8ac6");
            btnZut7.setStyle("-fx-background-color: #2e8ac6");
            btnZut8.setStyle("-fx-background-color: #2e8ac6");
        }
    }

    private void setButtonsDisable(Boolean bool){
        btnZut0.setDisable(bool);
        btnZut1.setDisable(bool);
        btnZut2.setDisable(bool);
        btnZut3.setDisable(bool);
        btnZut4.setDisable(bool);
        btnZut5.setDisable(bool);
        btnZut6.setDisable(bool);
        btnZut7.setDisable(bool);
        btnZut8.setDisable(bool);
    }

    private void fitxaKokatu(int pErrenkada, int pZutabea) {
        Image image;
        if ("G".equals(txanda)) {
            tableroa.setFitxa(pErrenkada, pZutabea, "G");
            image = new Image("pictures/FitxaGorria.png");
            taJokaldiak.appendText("\nGorria: [" + (pErrenkada + 1) + "," + (pZutabea + 1) + "] posizioan fitxa kokatu du.\n");
            if (jokoModua == 0) {
                taJokaldiak.appendText("\nJokalari URDINAren txanda...");
            } else {
                taJokaldiak.appendText("\nIA-ren txanda...");
            }
        } else if (jokoModua == 0) {
            tableroa.setFitxa(pErrenkada, pZutabea, "U");
            image = new Image("pictures/FitxaUrdina.png");
            taJokaldiak.appendText("\nUrdina: [" + (pErrenkada + 1) + "," + (pZutabea + 1) + "] posizioan fitxa kokatu du.\n");
            taJokaldiak.appendText("\nJokalari GORRIAren txanda...");
        } else {
            tableroa.setFitxa(pErrenkada, pZutabea, "IA");
            image = new Image("pictures/FitxaUrdina.png");
            taJokaldiak.appendText("\nIA: [" + (pErrenkada + 1) + "," + (pZutabea + 1) + "] posizioan fitxa kokatu du.\n");
            taJokaldiak.appendText("\nJokalari GORRIAren txanda...");
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(79);
        tableroaPane.setAlignment(Pos.CENTER);
        tableroaPane.add(imageView, pZutabea, pErrenkada + 1);
        tableroaPane.setHalignment(imageView, HPos.CENTER);
        Boolean irabaziDu = irabaziDu(pErrenkada, pZutabea, txanda);
        if (irabaziDu) {
            setButtonsDisable(true);
            this.setButtonsDisable(true);
            PauseTransition pauseIrabazlea = new PauseTransition(Duration.seconds(1));
            pauseIrabazlea.setOnFinished(event -> {
                if (jokoModua == 0) {
                    mainApp.amaieraJokJokErakutsi(txanda);
                } else if ("G".equals(txanda)) {
                    mainApp.amaieraErakutsi("irabazi",partidaDenbora,jokoModua);
                } else {
                    mainApp.amaieraErakutsi("galdu",0,jokoModua);
                }
            });
            pauseIrabazlea.play();
        } else {
            if ("G".equals(txanda)) {
                switch (jokoModua) {
                    case 0:
                        txanda = "U";
                        break;
                    case 1:
                        txanda = "IA";
                        this.setButtonsDisable(true);
                        PauseTransition pauseRandomIA = new PauseTransition(Duration.seconds(2));
                        pauseRandomIA.setOnFinished(event -> {
                            randomIA();
                            this.setButtonsDisable(false);
                        });
                        pauseRandomIA.play();
                        break;
                    case 2:
                        txanda = "IA";
                        this.setButtonsDisable(true);
                        PauseTransition pauseIntelligentIA = new PauseTransition(Duration.seconds(2));
                        pauseIntelligentIA.setOnFinished(event -> {
                            intelligentIA();
                            this.setButtonsDisable(false);
                        });
                        pauseIntelligentIA.play();
                        break;
                }
            } else {
                txanda = "G";
            }
        }
    }

    public boolean irabaziDu(int pErrenkada, int pZutabea, String pTxanda){
        if(tableroa.irabaziDu(pErrenkada,pZutabea,pTxanda)){
            if(jokoModua != 0){
                bukaeraDenbora = System.currentTimeMillis();
                partidaDenbora = (bukaeraDenbora - hasieraDenbora);
            }
            return true;
        }
        return false;
    }

    public void berdinetaKonprobatu(){
        int kont = 0;
        for(int i=0; i<zutabeBetetak.length; i++){
            if(zutabeBetetak[i]){
                kont++;
            }
        }
        if(kont==9){
            mainApp.berdiketaErakutsi(jokoModua);
        }
    }

    public void setJokoModua(int modu) {
        jokoModua = modu;
    }

    public void randomIA() {
        Random r = new Random();
        int low = 0;
        int high = tableroa.getZutabeKop()-1;    // +1 9.zutabea ere sartzeko
        int zutabea = r.nextInt(high - low + 1) + low;
        while(zutabeBetetak[zutabea]){
            zutabea = r.nextInt(high - low + 1) + low;
        }

        System.out.println("Random IA ---> Zutabea: " + zutabea);

        int errenkada = tableroa.kokapenErrenkadaBilatu(zutabea);
        System.out.println("Random IA-k aukeratutako laukia: [" + errenkada + " , " + zutabea + "]");
        fitxaKokatu(errenkada,zutabea);
        if(errenkada == 0){
            if(zutabea == 0){
                zutabeBetetak[0] = true;
                btnZut0.setDisable(true);
            }
            else if(zutabea == 1){
                zutabeBetetak[1] = true;
                btnZut1.setDisable(true);
            }
            else if(zutabea == 2){
                zutabeBetetak[2] = true;
                btnZut2.setDisable(true);
            }
            else if(zutabea == 3){
                zutabeBetetak[3] = true;
                btnZut3.setDisable(true);
            }
            else if(zutabea == 4){
                zutabeBetetak[4] = true;
                btnZut4.setDisable(true);
            }
            else if(zutabea == 5){
                zutabeBetetak[5] = true;
                btnZut5.setDisable(true);
            }
            else if(zutabea == 6){
                zutabeBetetak[6] = true;
                btnZut6.setDisable(true);
            }
            else if(zutabea == 7){
                zutabeBetetak[7] = true;
                btnZut7.setDisable(true);
            }
            else {
                zutabeBetetak[8] = true;
                btnZut8.setDisable(true);
            }
        }
        botoienKoloreaAldatu();
        berdinetaKonprobatu();
    }

    public void intelligentIA() {
        /*
        IA-ren pausuak:
            1. Aukera posible guztiak lortu
            2. Tableroaren kopia bat egin
            3. Aukera posible guztiak aztertzen ditu banan-banan, hoberena lortzeko

            (Inplentatu miniMax??? --> minValue, maxValue eta evaluationFunction sortu)
         */

//        Point aukeraOPt = IntelligentIA.emanZutabeHoberena(tableroa);
        Point aukeraOPt = IntelligentIA.emanAukeraHoberena(tableroa);

        if (aukeraOPt == null)
            randomIA();
        else {
            int errenkada = (int) aukeraOPt.getX();
            int zutabea = (int) aukeraOPt.getY();
            System.out.println("Intelligent IA-k aukeratutako laukia: [" + errenkada + " , " + zutabea + "]");
            fitxaKokatu(errenkada,zutabea);
            if(errenkada == 0){
                if(zutabea == 0){
                    zutabeBetetak[0] = true;
                    btnZut0.setDisable(true);
                }
                else if(zutabea == 1){
                    zutabeBetetak[1] = true;
                    btnZut1.setDisable(true);
                }
                else if(zutabea == 2){
                    zutabeBetetak[2] = true;
                    btnZut2.setDisable(true);
                }
                else if(zutabea == 3){
                    zutabeBetetak[3] = true;
                    btnZut3.setDisable(true);
                }
                else if(zutabea == 4){
                    zutabeBetetak[4] = true;
                    btnZut4.setDisable(true);
                }
                else if(zutabea == 5){
                    zutabeBetetak[5] = true;
                    btnZut5.setDisable(true);
                }
                else if(zutabea == 6){
                    zutabeBetetak[6] = true;
                    btnZut6.setDisable(true);
                }
                else if(zutabea == 7){
                    zutabeBetetak[7] = true;
                    btnZut7.setDisable(true);
                }
                else {
                    zutabeBetetak[8] = true;
                    btnZut8.setDisable(true);
                }
            }
            botoienKoloreaAldatu();
            berdinetaKonprobatu();
        }

    }

}