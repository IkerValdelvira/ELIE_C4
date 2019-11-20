package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class UI1Kud implements Initializable {

    private Main mainApp;

    @FXML
    private ImageView ivEurobisioa;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ivEurobisioa.setImage(new Image("eurobisioa.png"));
    }


    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void bozkatu(ActionEvent actionEvent) {
        mainApp.UI2Erakutsi();
    }
}