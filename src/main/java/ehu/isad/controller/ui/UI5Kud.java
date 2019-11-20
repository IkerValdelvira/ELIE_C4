package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkaketaDBKud;
import ehu.isad.controller.db.HerrialdeaDBKud;
import ehu.isad.controller.db.OrdezkaritzaDBKud;
import ehu.isad.model.Bozkaketa;
import ehu.isad.model.Ordezkaritza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

public class UI5Kud implements Initializable {

    private Main mainApp;

    @FXML
    private ImageView ivEurobisioa;

    @FXML
    private Label labelHerrialdea;

    @FXML
    private ImageView ivHerrialdea;

    @FXML
    private TableView<Ordezkaritza> tbData;
    @FXML
    private TableColumn<Ordezkaritza, Integer> herrialdea;

    @FXML
    private TableColumn<Ordezkaritza, String> artista;

    @FXML
    private TableColumn<Ordezkaritza, String> abestia;

    @FXML
    private TableColumn<Ordezkaritza, Integer> puntuak;

    @FXML
    private TableColumn<Ordezkaritza, Image> bandera;

    private ObservableList<Ordezkaritza> ordezkaritzaModels = FXCollections.observableArrayList();

    private String unekoHerrialdea;

    private int bozkaketaKop = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ivEurobisioa.setImage(new Image("eurobisioa.png"));

        tbData.setEditable(true);
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        herrialdea.setCellValueFactory(new PropertyValueFactory<>("herrialdea"));
        artista.setCellValueFactory(new PropertyValueFactory<>("artista"));
        abestia.setCellValueFactory(new PropertyValueFactory<>("abestia"));
        puntuak.setCellValueFactory(new PropertyValueFactory<>("puntuak"));

        //puntuak.setCellFactory(TextFieldTableCell.forTableColumn());

        puntuak.setOnEditCommit(

                t -> t.getTableView().getItems().get(t.getTablePosition().getRow())
                        .setPuntuak(t.getNewValue())

        );

        Callback<TableColumn<Ordezkaritza, Integer>, TableCell<Ordezkaritza, Integer>> intTextFieldCellFactory = TextFieldTableCell.forTableColumn(new IntegerStringConverter());

        puntuak.setCellFactory(col -> {
            TableCell<Ordezkaritza, Integer> cell = intTextFieldCellFactory.call(col);
            cell.setOnMouseClicked(event -> {
                if (! cell.isEmpty()) {
                    if (cell.getTableView().getSelectionModel().getSelectedItem().getHerrialdea().equals(this.unekoHerrialdea)) {
                        cell.setEditable(false);
                        cell.setText("---");
                    }else {
                        cell.setEditable(true);
                    }
                }
            });
            return cell;
        });

        bandera.setCellValueFactory(new PropertyValueFactory<Ordezkaritza, Image>("bandera"));

        bandera.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    ImageView imageview = new ImageView();
                    imageview.setFitHeight(20);
                    imageview.setFitWidth(30);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);

                    //tbData.refresh();
                }
                else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });


        ArrayList<Ordezkaritza> zerrenda = OrdezkaritzaDBKud.getInstantzia().lortuOrdezkaritzak();
        ordezkaritzaModels.addAll(zerrenda);
        //add your data to the table here.
        tbData.setItems(ordezkaritzaModels);
    }


    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void setHerrialdeBandera(String pHerrialdea){
        this.unekoHerrialdea = pHerrialdea;
        labelHerrialdea.setText(pHerrialdea + " horrela nahi ditu");

        String banderaPath = HerrialdeaDBKud.getInstantzia().banderaLortu(pHerrialdea);
        ivHerrialdea.setFitHeight(80);
        ivHerrialdea.setFitWidth(150);
        ivHerrialdea.setImage(new Image(banderaPath + ".png"));
    }

    @FXML
    public void bozkaketaGordeSakatu(ActionEvent actionEvent) {
        ArrayList<Bozkaketa> bozkatuak = new ArrayList<>();
        ArrayList<Ordezkaritza> ordezkaritzaEguneratuak = new ArrayList<>();
        for(Ordezkaritza lerroa : ordezkaritzaModels){
            if(lerroa.getPuntuak() > 0){
                bozkatuak.add(new Bozkaketa(lerroa.getHerrialdea(),this.unekoHerrialdea,Calendar.getInstance().get(Calendar.YEAR),lerroa.getPuntuak()));
                ordezkaritzaEguneratuak.add(lerroa);
            }
        }
        BozkaketaDBKud.getInstantzia().puntuakGorde(bozkatuak);
        OrdezkaritzaDBKud.getInstantzia().puntuakEguneratu(ordezkaritzaEguneratuak);
        this.mainApp.UI4Erakutsi();
    }
}