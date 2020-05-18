package ehu.pk.controller.ui;

import ehu.pk.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class SarreraKud implements Initializable {

    private Main mainApp;

    @FXML
    private ImageView ivLogoa;

    @FXML
    private ComboBox<String> cbModua;

    @FXML
    private Button btnHasi;

    @FXML
    private HBox hbox;

    @FXML
    private VBox vbox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hbox.setStyle("-fx-background-color: rgba(217,217,217,0.64);");
        vbox.setStyle("-fx-background-color: rgba(217,217,217,0.64);");
        ivLogoa.setFitHeight(125);
        ivLogoa.setFitWidth(250);
        ivLogoa.setImage(new Image("pictures/conecta4.png"));
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

    @FXML
    public void onClickItxi(ActionEvent actionEvent){
        mainApp.close();
    }

}