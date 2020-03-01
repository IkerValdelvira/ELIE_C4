package ehu.pk.controller.ui;

import ehu.pk.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainKud implements Initializable {

    private Main mainApp;

    @FXML
    private GridPane tableroa;

    @FXML
    private Button btnZut0;

    @FXML
    private Button btnZut1;

    @FXML
    private Button btnZut2;

    @FXML
    private Button btnZut3;

    @FXML
    private Button btnZut4;

    @FXML
    private Button btnZut5;

    @FXML
    private Button btnZut6;

    @FXML
    private Button btnZut7;

    @FXML
    private Button btnZut8;

    private static final int LAUKI_TAMAINA = 80;
    private static final int ZUTABEAK = 9;
    private static final int ERRENKADAK = 6;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
/*        Shape tableroa = new Rectangle((ZUTABEAK + 1) * LAUKI_TAMAINA, (ERRENKADAK + 1) * LAUKI_TAMAINA);
        for (int y=0; y<ERRENKADAK; y++){
            for (int x=0; x<ZUTABEAK; x++){
                Circle circle = new Circle(LAUKI_TAMAINA / 2);
                circle.setCenterX(LAUKI_TAMAINA / 2);
                circle.setCenterX(LAUKI_TAMAINA / 2);
                circle.setTranslateX(x * (LAUKI_TAMAINA + 5) + LAUKI_TAMAINA / 4);
                circle.setTranslateX(y * (LAUKI_TAMAINA + 5) + LAUKI_TAMAINA / 4);
                tableroa = tableroa.subtract(tableroa,circle);
            }
        }
        tableroa.setFill(Color.BLUE);
        tableroaPane.getChildren().add(tableroa);*/

        for(int i=1; i<tableroa.getRowCount(); i++){
            for (int j = 0; j < tableroa.getColumnCount(); j++) {
                Image image = new Image("FitxaZuria.png");
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(80);
                imageView.setFitWidth(79);
                tableroa.setAlignment(Pos.CENTER);
                tableroa.add(imageView, j, i);
                tableroa.setHalignment(imageView, HPos.CENTER);
            }
        }

        Image image = new Image("FitxaGorria.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(79);
        tableroa.setAlignment(Pos.CENTER);
        tableroa.add(imageView, 8, 5);
        tableroa.setHalignment(imageView, HPos.CENTER);


    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

}