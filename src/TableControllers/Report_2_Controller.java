package TableControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DbConnector;
import Reports.Report_2;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Report_2_Controller implements Initializable
{

    String sql_query="\n" +
            "SELECT TB.Client_ID, CONCAT(c_name,\" \",C_surname) AS Client_Name from tblclientinfo AS TB JOIN ( SELECT Client_ID, CONVERT (SUBSTR(Client_ID, 3, 2),unsigned) \n" +
            "AS month,CONVERT (SUBSTR(Client_ID, 5, 2),unsigned)  AS day FROM tblclientinfo HAVING day = day (current_date)AND month = month(current_date) ) \n" +
            "AS TC ON TB.Client_ID = TC.Client_ID ";

    @FXML
    private TableView<Report_2> table_r2;

    @FXML
    private TableColumn<Report_2,String > client_id;
    @FXML
    private TableColumn <Report_2, String> client_name;

    ObservableList<Report_2> oblist= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Connection con= DbConnector.getConnection();

        try {
            ResultSet rs = con.createStatement().executeQuery(sql_query);

            System.out.println("querry worked");
            while (rs.next()){

                oblist.add(new Report_2(rs.getString(1),rs.getString(2)));

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        client_id.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        client_name.setCellValueFactory(new PropertyValueFactory<>("client_name"));



        table_r2.setItems(oblist);






    }




}
