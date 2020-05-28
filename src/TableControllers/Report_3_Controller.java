package TableControllers;

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

public class Report_3_Controller implements Initializable {


    String sql_query="SELECT tblsupplements.supplement_id AS SUPPLEMENT, \n" +
            "CONCAT(tblsupplier_info.supplier_id,'',tblsupplier_info.contact_person,'',tblsupplier_info.Supplier_Tel) \n" +
            "AS SUPPLIER_INFORMATION, tblsupplements.Min_levels, tblsupplements.Current_stock_levels \n" +
            "AS CURRENT_STOCK FROM tblsupplements JOIN tblsupplier_info ON tblsupplements.supplier_id = tblsupplier_info.supplier_id \n" +
            "WHERE tblsupplements.Min_levels >tblsupplements.Current_stock_levels ORDER BY supplier_information ASC";
    @FXML
    private TableView<Report_3> table_3;

    @FXML
    private TableColumn<Report_3,String > supplm;
    @FXML
    private TableColumn <Report_3, String> suppl;
    @FXML
    private TableColumn  <Report_3,String> min_lev;
    @FXML
    private TableColumn  <Report_3, String>  c_stock;

    ObservableList<Report_3> oblist= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con= DbConnector.getConnection();

        try {
            ResultSet rs = con.createStatement().executeQuery(sql_query);

            System.out.println("querry worked");
            while (rs.next()){

                oblist.add(new Report_3(rs.getString(1),rs.getString(2),
                        rs.getInt(3), rs.getInt(4)));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        supplm.setCellValueFactory(new PropertyValueFactory<>("supplement"));
        suppl.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        min_lev.setCellValueFactory(new PropertyValueFactory<>("min_lev"));
        c_stock.setCellValueFactory(new PropertyValueFactory<>("cur_stock"));


        table_3.setItems(oblist);
    }
}