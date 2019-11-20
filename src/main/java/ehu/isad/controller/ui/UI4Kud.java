package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkaketaDBKud;
import ehu.isad.controller.db.HerrialdeaDBKud;
import ehu.isad.controller.db.OrdezkaritzaDBKud;
import ehu.isad.model.Bozkaketa;
import ehu.isad.model.Ordezkaritza;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UI4Kud implements Initializable {

    private Main mainApp;

    @FXML
    private ImageView ivEurobisioa;

    @FXML
    private ImageView ivBandera1;

    @FXML
    private ImageView ivBandera2;

    @FXML
    private ImageView ivBandera3;

    @FXML
    private Label lblHerrialdea1;

    @FXML
    private Label lblHerrialdea2;

    @FXML
    private Label lblHerrialdea3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ivEurobisioa.setImage(new Image("eurobisioa.png"));
    }


    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void top3Osatu(){
        ArrayList<Ordezkaritza> top3 = OrdezkaritzaDBKud.getInstantzia().lortuTop3Ordezkariak();
        ivBandera1.setImage(top3.get(0).getBandera());
        ivBandera2.setImage(top3.get(1).getBandera());
        ivBandera3.setImage(top3.get(2).getBandera());
        lblHerrialdea1.setText(top3.get(0).getHerrialdea() + " - " + top3.get(0).getPuntuak() + " puntu");
        lblHerrialdea2.setText(top3.get(1).getHerrialdea() + " - " + top3.get(1).getPuntuak() + " puntu");
        lblHerrialdea3.setText(top3.get(2).getHerrialdea() + " - " + top3.get(2).getPuntuak() + " puntu");
    }

    @FXML
    public void okSakatu(ActionEvent actionEvent) {
        mainApp.close();
    }
}