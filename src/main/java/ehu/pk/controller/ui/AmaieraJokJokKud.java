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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void setIrabazlea(String pIrabazlea){
        if("G".equals(pIrabazlea)){
            lblIrabazlea.setText("JOKALARI GORRIAK irabazi du!!!");
        }
        else{
            lblIrabazlea.setText("JOKALARI URDINAK irabazi du!!!");
        }
        Image image = new Image("pictures/win.gif");
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

}