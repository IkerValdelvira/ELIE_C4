package ehu.pk.controller.ui;

import ehu.pk.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class BerdinketaKud implements Initializable {

    private Main mainApp;

    @FXML
    private Button btnItzuli;

    @FXML
    private Button btnErrebantxa;

    @FXML
    private ImageView imageView;

    private int modua;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void setModua(int pModua){
        this.modua = modua;
        Image image = new Image("pictures/berdinketa.gif");
        imageView.setImage(image);
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

}