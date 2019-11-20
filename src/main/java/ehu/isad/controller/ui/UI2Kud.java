package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkaketaDBKud;
import ehu.isad.controller.db.HerrialdeaDBKud;
import ehu.isad.model.Bozkaketa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UI2Kud implements Initializable {

    private Main mainApp;

    @FXML
    private ImageView ivEurobisioa;

    @FXML
    private ComboBox cbHerrialdeak;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ivEurobisioa.setImage(new Image("eurobisioa.png"));
    }


    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void getPartaideak(){
        ArrayList<String> partaideak = HerrialdeaDBKud.getInstantzia().lortuPartaideak();
        cbHerrialdeak.getItems().addAll(partaideak);
    }

    @FXML
    public void okSakatu(ActionEvent actionEvent) {
        String hautatutakoHerrialdea = cbHerrialdeak.getValue().toString();
        ArrayList<Bozkaketa> bozkatuDu = BozkaketaDBKud.getInstantzia().bozkatuDu(hautatutakoHerrialdea);
        if(!bozkatuDu.isEmpty()){
            mainApp.UI3Erakutsi(hautatutakoHerrialdea);
        }
        else{
            mainApp.UI5Erakutsi(hautatutakoHerrialdea);
        }
    }
}