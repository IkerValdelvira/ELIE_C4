package ehu.pk;

import ehu.pk.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent mainUI;

  private Stage stage;

  private MainKud mainKud;

  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Conecta 4");
    stage.setScene(new Scene(mainUI, 700, 540));
    stage.show();
    stage.setResizable(false);
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/main.fxml"));
    mainUI = (Parent) loaderMain.load();
    mainKud = loaderMain.getController();
    mainKud.setMainApp(this);



  }


  public static void main(String[] args) {
    launch(args);
  }

}