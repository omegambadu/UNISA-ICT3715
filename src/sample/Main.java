package sample;

import Controllers.Mainpane_Controler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception{


    Parent root= FXMLLoader.load(getClass().getResource("../Fxml files/main_gui.fxml"));
    Scene scene=new Scene (root);
    primaryStage.setScene(scene);
    scene.getStylesheets().add(getClass().getResource("style.css").toString());
    primaryStage.show();
DbConnector.getAllSuppliers();







    }


    public static void main(String[] args) {
        launch(args);


    }






}
