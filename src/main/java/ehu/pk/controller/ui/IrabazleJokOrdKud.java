package ehu.pk.controller.ui;

import ehu.pk.Main;
import ehu.pk.controller.db.RankingIntelligentIADBKud;
import ehu.pk.controller.db.RankingRandomIADBKud;
import ehu.pk.model.Emaitza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class IrabazleJokOrdKud implements Initializable {

    private Main mainApp;

    @FXML
    private Label lblDenbora;

    @FXML
    private Label lblMezua;

    @FXML
    private TextField tfIzenaSartu;

    @FXML
    private Button btnIzenaGorde;

    @FXML
    private TableView<Emaitza> tbRanking;

    @FXML
    private TableColumn<Emaitza, Image> colPosizioa;

    @FXML
    private TableColumn<Emaitza, String> colJokalaria;

    @FXML
    private TableColumn<Emaitza, String> colDenbora;

    @FXML
    private TableColumn<Emaitza, Date> colData;

    private ObservableList<Emaitza> emaitzaModels = FXCollections.observableArrayList();

    private int posizioa;
    private long denbora;
    private int jokoModua;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void hasieratu(long denbora, int jokoModua){
        lblDenbora.setStyle("-fx-font-weight: bold;");

        this.jokoModua = jokoModua;
        this.denbora = denbora;
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
        String denboraString = dateFormat.format(denbora);
        lblDenbora.setText(denboraString);

        if(jokoModua == 1){
            emaitzaModels = RankingRandomIADBKud.getInstantzia().rankingLortu();
        }
        else{
            emaitzaModels = RankingIntelligentIADBKud.getInstantzia().rankingLortu();
        }
        posizioa = -1;
        for(int i=0; i<emaitzaModels.size(); i++){
            if(denbora < emaitzaModels.get(i).getDenbora()){
                posizioa = emaitzaModels.get(i).getPosizioa();
                break;
            }
        }
        if(posizioa == -1 && emaitzaModels.size() < 10){
            posizioa = emaitzaModels.size()+1;
            lblMezua.setText("10 jokalari onenen " + (posizioa) + " posizioan ranking-ean sar zaitezke!!! Izena eman:");
            tfIzenaSartu.setVisible(true);
            btnIzenaGorde.setVisible(true);
        }
        else if(posizioa != -1){
            lblMezua.setText("10 jokalari onenen " + (posizioa) + " posizioan ranking-ean sar zaitezke!!! Izena eman:");
            tfIzenaSartu.setVisible(true);
            btnIzenaGorde.setVisible(true);
        }
        else{
            lblMezua.setText("Ez zara 10 jokalari onenen ranking-ean sartu.");
            tfIzenaSartu.setVisible(false);
            btnIzenaGorde.setVisible(false);
        }

        colJokalaria.setCellValueFactory(new PropertyValueFactory<>("Jokalaria"));
        colDenbora.setCellValueFactory(new PropertyValueFactory<>("DenboraString"));
        colData.setCellValueFactory(new PropertyValueFactory<>("Data"));
        colPosizioa.setCellValueFactory(new PropertyValueFactory<Emaitza, Image>("PosizioaImage"));
        colPosizioa.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty) {
                    ImageView imageview = new ImageView();
                    imageview.setFitHeight(30);
                    imageview.setFitWidth(30);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);

                    tbRanking.refresh();
                }
            }

            ;
        });

        tbRanking.setItems(emaitzaModels);

        tbRanking.setId("my-table");
    }

    @FXML
    public void onClickIzenaGorde(ActionEvent actionEvent){
        Emaitza emaitza = new Emaitza(posizioa,tfIzenaSartu.getText(),denbora,new Timestamp(new Date().getTime()).toString());
        if(posizioa == emaitzaModels.size()+1 && emaitzaModels.size() < 10){
            if(jokoModua == 1){
                RankingRandomIADBKud.getInstantzia().emaitzaSartu(emaitza);
            }
            else{
                RankingIntelligentIADBKud.getInstantzia().emaitzaSartu(emaitza);
            }
            emaitzaModels.add(emaitza);
        }
        else{
            ObservableList<Emaitza> emaitzaModelsLag = FXCollections.observableArrayList();
            for(int i=1; i<posizioa; i++){
                emaitzaModelsLag.add(emaitzaModels.get(i-1));
            }
            emaitzaModelsLag.add(emaitza);
            if(emaitzaModels.size()<10){
                for(int i=emaitzaModelsLag.size(); i<=emaitzaModels.size(); i++) {
                    emaitzaModels.get(i-1).setPosizioa(emaitzaModels.get(i-1).getPosizioa()+1);
                    emaitzaModelsLag.add(emaitzaModels.get(i-1));
                }
            }
            else{
                for(int i=emaitzaModelsLag.size(); i<10; i++) {
                    emaitzaModels.get(i-1).setPosizioa(emaitzaModels.get(i-1).getPosizioa()+1);
                    emaitzaModelsLag.add(emaitzaModels.get(i-1));
                }
            }
            emaitzaModels.clear();
            emaitzaModels.addAll(emaitzaModelsLag);
            if(jokoModua == 1){
                RankingRandomIADBKud.getInstantzia().emaitzakEzabatu();
                RankingRandomIADBKud.getInstantzia().emaitzakSartu(emaitzaModels);
            }
            else{
                RankingIntelligentIADBKud.getInstantzia().emaitzakEzabatu();
                RankingIntelligentIADBKud.getInstantzia().emaitzakSartu(emaitzaModels);
            }
            tfIzenaSartu.setVisible(false);
            btnIzenaGorde.setVisible(false);
            lblMezua.setText("Zure izena ranking-ean erregistratu da!!!");
        }
    }

    @FXML
    public void onClickErrebantxa(ActionEvent actionEvent){
        mainApp.stageTxikiaClose();
        mainApp.mainErakutsi(jokoModua);
    }

    @FXML
    public void onClickItzuli(ActionEvent actionEvent){
        mainApp.stageTxikiaClose();
        mainApp.sarreraErakutsi();
    }

}