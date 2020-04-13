package ehu.pk.controller.ui;

import ehu.pk.Main;
import ehu.pk.controller.IntelligentIA;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class SarreraKud implements Initializable {

    private Main mainApp;

    @FXML
    private ComboBox<String> cbModua;

    @FXML
    private Button btnHasi;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbModua.getItems().addAll("Jokalari VS Jokalari", "Jokalari VS Ordenagailu", "Jokalari VS Ordenagailu Adimendua");
        cbModua.getSelectionModel().selectFirst();
    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClickHasi(ActionEvent actionEvent){
        String modua = cbModua.getValue();
        if("Jokalari VS Jokalari".equals(modua)){
            mainApp.mainErakutsi(0);
        }
        else if("Jokalari VS Ordenagailu".equals(modua)){
            mainApp.mainErakutsi(1);
        }
        else{
            mainApp.mainErakutsi(2);
        }
    }

}