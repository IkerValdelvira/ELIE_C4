package ehu.pk.controller.ui;

import ehu.pk.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    private Button buttonRanking;

    @FXML
    private VBox vbox;

    @FXML
    private HBox hbox;

    private long denbora;
    private int modua;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hbox.setStyle("-fx-background-color: rgba(217,217,217,0.64);");
    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }


    public void hasieratu(String emaitza, long denbora, int modua){
        this.denbora=denbora;
        this.modua=modua;

        if("irabazi".equals(emaitza)){
            vbox.setStyle("-fx-background-color: #f1afaf");
            lblIrabazlea.setText("ZORIONAK, IRABAZI DUZU!");
            Image image = new Image("pictures/win.gif");
            imageView.setImage(image);
            buttonRanking.setDisable(false);
            btnErrebantxa.setText("Berriro jolastu");

        }
        else{
            vbox.setStyle("-fx-background-color: #b8dbe8");
            lblIrabazlea.setText("GALDU DUZU, SAIATU BERRIRO");
            Image image = new Image("pictures/lose.gif");
            imageView.setImage(image);
            buttonRanking.setDisable(true);
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

    public void onClickRanking(ActionEvent actionEvent) {
        mainApp.stageTxikiaClose();
        mainApp.irabazleJokOrdErakutsi(denbora,modua);
    }

    public void onClickItxi(ActionEvent actionEvent) {
        mainApp.stageTxikiaClose();
        mainApp.close();
    }

    public void onClickBerrabiarazi(ActionEvent actionEvent) {
        mainApp.stageTxikiaClose();
        mainApp.mainErakutsi(this.modua);
    }

    public void onClickJokvsJok(ActionEvent actionEvent) {
        mainApp.stageTxikiaClose();
        mainApp.mainErakutsi(0);
    }

    public void onClickJokvsOrd(ActionEvent actionEvent) {
        mainApp.stageTxikiaClose();
        mainApp.mainErakutsi(1);
    }

    public void onClickJokvsOrdAdimendua(ActionEvent actionEvent) {
        mainApp.stageTxikiaClose();
        mainApp.mainErakutsi(2);
    }
}