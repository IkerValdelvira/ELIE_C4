package ehu.pk.controller.ui;

import ehu.pk.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AmaieraKud implements Initializable {

    private Main mainApp;

    @FXML
    private Label lblIrabazlea;

    @FXML
    private Button btnItzuli;

    @FXML
    private Button btnErrebantxa;

    @FXML
    private ImageView imageView;

    @FXML
    private Button buttonPuntuazioa;

    private long denbora;
    private int modua;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }


    public void hasieratu(String emaitza, long denbora, int modua){
        this.denbora=denbora;
        this.modua=modua;

        if("irabazi".equals(emaitza)){
            lblIrabazlea.setText("ZORIONAK, IRABAZI DUZU!");
            Image image = new Image("pictures/win.gif");
            imageView.setImage(image);
            buttonPuntuazioa.setDisable(false);
            btnErrebantxa.setText("Berriro jolastu");

        }
        else{
            lblIrabazlea.setText("GALDU DUZU, SAIATU BERRIRO");
            Image image = new Image("pictures/lose.gif");
            imageView.setImage(image);
            buttonPuntuazioa.setDisable(true);
            btnErrebantxa.setText("Errebantxa");

        }
    }

    @FXML
    public void onClickErrebantxa(ActionEvent actionEvent){
        mainApp.stageTxikiaClose();
        mainApp.mainErakutsi(modua);
    }

    @FXML
    public void onClickItzuli(ActionEvent actionEvent){
        mainApp.stageTxikiaClose();
        mainApp.sarreraErakutsi();
    }

    public void puntuazioaGorde(ActionEvent actionEvent) {
        mainApp.stageTxikiaClose();
        mainApp.irabazleJokOrdErakutsi(denbora,modua);
    }
}