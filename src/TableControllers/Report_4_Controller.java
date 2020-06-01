package TableControllers;

import Reports.Report_4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DbConnector;
import Reports.Report_3;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Report_4_Controller implements Initializable {


    String sql_query="SELECT CONCAT(tblinv_info.client_id,\" \",tblclientinfo.c_name,\" \",tblclientinfo.c_surname) AS Client, COUNT(tblinv_info.client_id) AS    FREQUENCY FROM tblinv_info join tblclientinfo ON tblinv_info.client_id=tblclientinfo.client_id    WHERE tblinv_info.Inv_Date BETWEEN '2018-01-01' AND '2019-12-31' GROUP BY tblinv_info.client_id ORDER BY `FREQUENCY` DESC LIMIT 10";
    @FXML
    private TableView<Report_4> table_r4;

    @FXML
    private TableColumn<Report_4,String > client;
    @FXML
    private TableColumn <Report_4, String> frequency;


    ObservableList<Report_4> oblist= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con= DbConnector.getConnection();

        try {
            ResultSet rs = con.createStatement().executeQuery(sql_query);

            System.out.println("querry worked");
            while (rs.next()){

                oblist.add(new Report_4(rs.getString(1),rs.getString(2)
                       ));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        client.setCellValueFactory(new PropertyValueFactory<>("client"));
        frequency.setCellValueFactory(new PropertyValueFactory<>("frequency"));



        table_r4.setItems(oblist);
    }
}
