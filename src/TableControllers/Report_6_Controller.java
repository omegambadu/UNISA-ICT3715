package TableControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DbConnector;
import Reports.Report_6;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Report_6_Controller implements Initializable {


    String sql_query = "SELECT tblclientinfo.client_id AS CLIENT, tblclientinfo.c_tel_h AS HOME, tblclientinfo.c_tel_w AS WORK, tblclientinfo.c_tel_c AS CELL ,tblclientinfo.c_email AS 'E-MAIL' FROM tblclientinfo WHERE tblclientinfo.c_email ='' and tblclientinfo.c_tel_c =''";
    @FXML
    private TableView<Report_6> table_6;

    @FXML
    private TableColumn<Report_6, String> client;
    @FXML
    private TableColumn<Report_6, String> hme;
    @FXML
    private TableColumn<Report_6, String> wrk;
    @FXML
    private TableColumn<Report_6, String> cell;
    @FXML
    private TableColumn<Report_6, String> email;


    ObservableList<Report_6> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con = DbConnector.getConnection();

        try {
            ResultSet rs = con.createStatement().executeQuery(sql_query);

            System.out.println("querry worked");
            while (rs.next()) {

                oblist.add(new Report_6(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),rs.getString(5)));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        client.setCellValueFactory(new PropertyValueFactory<>("clnt"));
        hme.setCellValueFactory(new PropertyValueFactory<>("hme"));
        wrk.setCellValueFactory(new PropertyValueFactory<>("wrk"));
        cell.setCellValueFactory(new PropertyValueFactory<>("cel"));
        email.setCellValueFactory(new PropertyValueFactory<>("mail"));


        table_6.setItems(oblist);
    }
}
