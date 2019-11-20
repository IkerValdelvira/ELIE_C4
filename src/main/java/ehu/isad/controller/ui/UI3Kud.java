package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.HerrialdeaDBKud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UI3Kud implements Initializable {

    private Main mainApp;

    @FXML
    private ImageView ivEurobisioa;

    @FXML
    private Label labelHerrialdea;

    @FXML
    private ImageView ivHerrialdea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ivEurobisioa.setImage(new Image("eurobisioa.png"));
    }


    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void setHerrialdeBandera(String pHerrialdea){
        labelHerrialdea.setText(pHerrialdea + " jada banatu ditu");

        String banderaPath = HerrialdeaDBKud.getInstantzia().banderaLortu(pHerrialdea);
        ivHerrialdea.setFitHeight(80);
        ivHerrialdea.setFitWidth(150);
        ivHerrialdea.setImage(new Image(banderaPath + ".png"));
    }

    @FXML
    public void okSakatu(ActionEvent actionEvent) {
        mainApp.UI2Erakutsi();
    }
}