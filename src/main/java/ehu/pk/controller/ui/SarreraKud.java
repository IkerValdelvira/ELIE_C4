package ehu.pk.controller.ui;

import ehu.pk.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

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