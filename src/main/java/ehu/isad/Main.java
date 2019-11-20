package ehu.isad;

import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent UI1;
  private Parent UI2;
  private Parent UI3;
  private Parent UI4;
  private Parent UI5;

  private Stage stage;

  private Scene sceneUI2;
  private Scene sceneUI3;

  private UI1Kud ui1Kud;
  private UI2Kud ui2Kud;
  private UI3Kud ui3Kud;
  private UI4Kud ui4Kud;
  private UI5Kud ui5Kud;

  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Eurobisioa");
    stage.setScene(new Scene(UI1, 300, 200));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderUI1 = new FXMLLoader(getClass().getResource("/UI1.fxml"));
    UI1 = (Parent) loaderUI1.load();
    ui1Kud = loaderUI1.getController();
    ui1Kud.setMainApp(this);

    FXMLLoader loaderUI2 = new FXMLLoader(getClass().getResource("/UI2.fxml"));
    UI2 = (Parent) loaderUI2.load();
    ui2Kud = loaderUI2.getController();
    ui2Kud.setMainApp(this);

    FXMLLoader loaderUI3 = new FXMLLoader(getClass().getResource("/UI3.fxml"));
    UI3 = (Parent) loaderUI3.load();
    ui3Kud = loaderUI3.getController();
    ui3Kud.setMainApp(this);

    FXMLLoader loaderUI4 = new FXMLLoader(getClass().getResource("/UI4.fxml"));
    UI4 = (Parent) loaderUI4.load();
    ui4Kud = loaderUI4.getController();
    ui4Kud.setMainApp(this);

    FXMLLoader loaderUI5 = new FXMLLoader(getClass().getResource("/UI5.fxml"));
    UI5 = (Parent) loaderUI5.load();
    ui5Kud = loaderUI5.getController();
    ui5Kud.setMainApp(this);

  }


  public static void main(String[] args) {
    launch(args);
  }

  public void UI1Erakutsi() {
    stage.setScene(new Scene(UI1));
    stage.show();
  }

  public void UI2Erakutsi() {
    stage.setTitle("Informazioaren Eguneraketa");
    if(sceneUI2 == null){
      this.sceneUI2 = new Scene(UI2);
    }
    stage.setScene(sceneUI2);
    stage.show();
    ui2Kud.getPartaideak();
  }

  public void UI3Erakutsi(String hautatutakoHerrialdea) {
    stage.setTitle(hautatutakoHerrialdea + "ren inguruko informazioa");
    if(sceneUI3 == null){
      this.sceneUI3 = new Scene(UI3);
    }
    stage.setScene(sceneUI3);
    stage.show();
    ui3Kud.setHerrialdeBandera(hautatutakoHerrialdea);
  }

  public void UI4Erakutsi() {
    stage.setTitle("Datuak Sartu");
    stage.setScene(new Scene(UI4));
    stage.show();
    ui4Kud.top3Osatu();
  }

  public void UI5Erakutsi(String hautatutakoHerrialdea) {
    stage.setTitle("Bozkaketa panela");
    stage.setScene(new Scene(UI5));
    stage.show();
    ui5Kud.setHerrialdeBandera(hautatutakoHerrialdea);
  }

  public void close(){
    stage.close();
  }

}