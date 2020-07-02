package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.XMLFormatter;

public class Mainpane_Controler implements Initializable {

    @FXML
    public AnchorPane bttm_pane;

    @FXML
    public ImageView AHC_logo;

    @FXML
    public ImageView i_suppl;

    @FXML
    public AnchorPane right_pane;

    @FXML
    public HBox mnu_hbox;

    @FXML
    public AnchorPane left_pane;

    @FXML
    public AnchorPane center_pane;


    @FXML
    private BorderPane b_pane;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }


    @FXML
    public void buttonClientClicked(javafx.scene.input.MouseEvent mouseEvent){
        handleMenu("cl_menu");
    }

    @FXML
    public void buttonSupplierClicked(javafx.scene.input.MouseEvent mouseEvent){
        handleMenu("supplier_mnu");
    }

    public void handleMenu(String ui) {
Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("../Fxml files/"+ui+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        b_pane.setCenter(root);
    }



}
