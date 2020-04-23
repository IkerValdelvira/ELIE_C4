package ehu.pk;

import ehu.pk.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends Application {

  private Parent mainUI;
  private Parent sarreraUI;
  private Parent amaieraJokJokUI;
  private Parent irabazleJokOrdUI;
  private Parent galtzaileJokOrdUI;
  private Parent berdinketaUI;
  private Parent amaieraUI;

  private Stage stage;
  private Stage stageTxikia;

  private MainKud mainKud;
  private SarreraKud sarreraKud;
  private AmaieraJokJokKud amaieraJokJokKud;
  private IrabazleJokOrdKud irabazleJokOrdKud;
  private GaltzaileJokOrdKud galtzaileJokOrdKud;
  private BerdinketaKud berdinketaKud;
  private AmaieraKud amaieraKud;

  private Scene mainScene;
  private Scene sarreraScene;
  private Scene amaieraJokJokScene;
  private Scene irabazleJokOrdScene;
  private Scene galtzaileJokOrdScene;
  private Scene berdinketaScene;
  private Scene amaieraScene;


  @Override
  public void start(Stage primaryStage) throws Exception {

    this.datuBaseaHasieratu();

    stage = primaryStage;
    pantailakKargatu();

    stageTxikia = new Stage();
    stageTxikia.initStyle(StageStyle.UTILITY);

    stage.setTitle("Conecta 4");
    sarreraScene = new Scene(sarreraUI, 700, 250);
    stage.setScene(sarreraScene);
    stage.show();
    stage.setResizable(false);
  }

  private void datuBaseaHasieratu(){

    Path source = null;
    Path destination = null;

    String path = System.getProperty("user.home") + File.separatorChar + ".conecta4DB" + File.separatorChar + "conecta4DB.sqlite";
    if(!(new File(path).exists())) {
      File directory = new File(System.getProperty("user.home") + File.separatorChar + ".conecta4DB");
      directory.mkdir();
      try {
        source = Paths.get(getClass().getClassLoader().getResource("conecta4DB.sqlite").toURI());
        destination = Paths.get(path);
        Files.copy(source, destination);

      } catch (URISyntaxException | IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/main.fxml"));
    mainUI = (Parent) loaderMain.load();
    mainKud = loaderMain.getController();
    mainKud.setMainApp(this);

    FXMLLoader loaderSarrera = new FXMLLoader(getClass().getResource("/sarrera.fxml"));
    sarreraUI = (Parent) loaderSarrera.load();
    sarreraKud = loaderSarrera.getController();
    sarreraKud.setMainApp(this);

    FXMLLoader loaderIrabazleJokOrd = new FXMLLoader(getClass().getResource("/irabazleJokOrd.fxml"));
    irabazleJokOrdUI = (Parent) loaderIrabazleJokOrd.load();
    irabazleJokOrdKud = loaderIrabazleJokOrd.getController();
    irabazleJokOrdKud.setMainApp(this);

    FXMLLoader loaderAmaieraJokJok = new FXMLLoader(getClass().getResource("/amaieraJokJok.fxml"));
    amaieraJokJokUI = (Parent) loaderAmaieraJokJok.load();
    amaieraJokJokKud = loaderAmaieraJokJok.getController();
    amaieraJokJokKud.setMainApp(this);

    FXMLLoader loaderGaltzaileJokOrd = new FXMLLoader(getClass().getResource("/galtzaileJokOrd.fxml"));
    galtzaileJokOrdUI = (Parent) loaderGaltzaileJokOrd.load();
    galtzaileJokOrdKud = loaderGaltzaileJokOrd.getController();
    galtzaileJokOrdKud.setMainApp(this);

    FXMLLoader loaderBerdinketa = new FXMLLoader(getClass().getResource("/berdinketa.fxml"));
    berdinketaUI = (Parent) loaderBerdinketa.load();
    berdinketaKud = loaderBerdinketa.getController();
    berdinketaKud.setMainApp(this);

    FXMLLoader loaderAmaiera = new FXMLLoader(getClass().getResource("/amaiera.fxml"));
    amaieraUI = (Parent) loaderAmaiera.load();
    amaieraKud = loaderAmaiera.getController();
    amaieraKud.setMainApp(this);

  }

  public void mainErakutsi(int jokoModua){
    if(mainScene == null){
      mainScene = new Scene(mainUI, 1000, 540);
    }
    stage.setScene(mainScene);
    mainKud.setJokoModua(jokoModua);
    mainKud.hasieratu();
  }

  public void sarreraErakutsi(){
    if(sarreraScene == null){
      sarreraScene = new Scene(sarreraUI, 700, 250);
    }
    stage.setScene(sarreraScene);
  }

  public void amaieraJokJokErakutsi(String pIrabazlea){
    if(amaieraJokJokScene == null){
      amaieraJokJokScene = new Scene(amaieraJokJokUI, 500, 250);
    }
    stageTxikia.setScene(amaieraJokJokScene);
    stageTxikia.setTitle("IRABAZLEA");
    amaieraJokJokKud.setIrabazlea(pIrabazlea);
    stageTxikia.show();
  }

  public void irabazleJokOrdErakutsi(long denbora, int jokoModua){
    if(irabazleJokOrdScene == null){
      irabazleJokOrdScene = new Scene(irabazleJokOrdUI, 820, 510);
    }

    stageTxikia.setScene(irabazleJokOrdScene);
    stageTxikia.setTitle("IRABAZLEA");
    stageTxikia.show();
    irabazleJokOrdKud.hasieratu(denbora, jokoModua);
  }

  public void galtzaileJokOrdErakutsi(int pModua){
    if(galtzaileJokOrdScene == null){
      galtzaileJokOrdScene = new Scene(galtzaileJokOrdUI, 500, 250);
    }
    stageTxikia.setScene(galtzaileJokOrdScene);
    stageTxikia.setTitle("GAME OVER");
    stageTxikia.show();
    galtzaileJokOrdKud.hasieratu(pModua);
  }

  public void berdiketaErakutsi(int pModua){
    if(berdinketaScene == null){
      berdinketaScene = new Scene(berdinketaUI, 500, 250);
    }
    stageTxikia.setScene(berdinketaScene);
    stageTxikia.setTitle("BERDINKETA");
    stageTxikia.show();
    berdinketaKud.setModua(pModua);
  }
  public void amaieraErakutsi(String emaitza, long denbora, int modua){
    if(amaieraScene == null) {
      amaieraScene = new Scene(amaieraUI, 500, 250);
    }

    stageTxikia.setScene(amaieraScene);
    //stageTxikia.setTitle("IRABAZLEA");
    stageTxikia.show();
    amaieraKud.hasieratu(emaitza,denbora,modua);
  }



  public void stageTxikiaClose(){
    stageTxikia.close();
  }

  public static void main(String[] args) {
    launch(args);
  }

}