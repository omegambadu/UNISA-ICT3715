package TableControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DbConnector;
import Reports.Report_1;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Report_1_Controller implements Initializable {


    String sql_query="SELECT tblclientinfo.Client_ID AS CLIENT_ID, CONCAT (tblclientinfo.C_name, ' ',tblclientinfo.C_surname) AS CLIENT,  \n" +
            "tblinv_info.Inv_Num AS INVOICE_NUMBER, tblinv_info.Inv_Date AS INVOICE_DATE from tblclientinfo  \n" +
            "JOIN tblinv_info ON tblclientinfo.Client_ID = tblinv_info.Client_ID WHERE date(tblinv_info.Inv_Date) < '2020-01-01'  \n" +
            "AND tblinv_info.Inv_Paid NOT IN ('Y') group by 1,2,3,4 ORDER BY tblinv_info.Inv_Date ASC";
    @FXML
    private TableView<Report_1> table;

    @FXML
    private TableColumn<Report_1,String > c_id;
    @FXML
    private TableColumn <Report_1, String> c_names;
    @FXML
    private TableColumn  <Report_1,String> inv_num;
    @FXML
    private TableColumn  <Report_1, String>  inv_date;

 ObservableList<Report_1> oblist= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con= DbConnector.getConnection();

        try {
            ResultSet rs = con.createStatement().executeQuery(sql_query);

            System.out.println("querry worked");
        while (rs.next()){

            oblist.add(new Report_1(rs.getString(1),rs.getString(2),
                    rs.getString(3), rs.getString(4)));
        }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        c_id.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        c_names.setCellValueFactory(new PropertyValueFactory<>("client"));
        inv_num.setCellValueFactory(new PropertyValueFactory<>("invoice_number"));
        inv_date.setCellValueFactory(new PropertyValueFactory<>("invoice_date"));


        table.setItems(oblist);
    }
}
