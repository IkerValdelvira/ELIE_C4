package ehu.pk.controller.ui;

import ehu.pk.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class AmaieraJokJokKud implements Initializable {

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
    private VBox vbox;

    @FXML
    private HBox hbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hbox.setStyle("-fx-background-color: rgba(217,217,217,0.64);");
    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void setIrabazlea(String pIrabazlea){
        if("G".equals(pIrabazlea)){
            lblIrabazlea.setText("JOKALARI GORRIAK irabazi du!!!");
            vbox.setStyle("-fx-background-color: #f1afaf");
        }
        else{
            lblIrabazlea.setText("JOKALARI URDINAK irabazi du!!!");
            vbox.setStyle("-fx-background-color: #b8dbe8");
        }
        Image image = new Image("pictures/win.gif");
        imageView.setFitHeight(138);
        imageView.setFitWidth(250);
        imageView.setImage(image);

    }

    @FXML
    public void onClickErrebantxa(ActionEvent actionEvent){
        mainApp.stageTxikiaClose();
        mainApp.mainErakutsi(0);
    }

    @FXML
    public void onClickItzuli(ActionEvent actionEvent){
        mainApp.stageTxikiaClose();
        mainApp.sarreraErakutsi();
    }

    @FXML
    public void onClickItxi(ActionEvent actionEvent){
        mainApp.stageTxikiaClose();
        mainApp.close();
    }

    @FXML
    public void onClickBerrabiarazi(ActionEvent actionEvent){
        mainApp.stageTxikiaClose();
        mainApp.mainErakutsi(0);
    }

    @FXML
    public void onClickJokvsJok(ActionEvent actionEvent){
        mainApp.stageTxikiaClose();
        mainApp.mainErakutsi(0);
    }

    @FXML
    public void onClickJokvsOrd(ActionEvent actionEvent){
        mainApp.stageTxikiaClose();
        mainApp.mainErakutsi(1);
    }

    @FXML
    public void onClickJokvsOrdAdimendua(ActionEvent actionEvent){
        mainApp.stageTxikiaClose();
        mainApp.mainErakutsi(2);
    }

}