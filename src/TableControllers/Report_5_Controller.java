package TableControllers;

import Reports.Report_5;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DbConnector;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Report_5_Controller implements Initializable {


    String sql_query="SELECT COUNT(Inv_Num) AS NUM_OF_PURCHASES,MONTHNAME(Inv_Date) AS MONTH FROM tblinv_info where Inv_Date>='2012-01-01'  GROUP BY MONTH ORDER BY FIELD(MONTH,'January','February','March','April','May','June','july','August','September','October','November',' December')";
    @FXML
    private TableView<Report_5> table_r5;

    @FXML
    private TableColumn<Report_5,String > n_purch;
    @FXML
    private TableColumn <Report_5, String> mnth;


    ObservableList<Report_5> oblist= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con= DbConnector.getConnection();

        try {
            ResultSet rs = con.createStatement().executeQuery(sql_query);

            System.out.println("querry worked");
            while (rs.next()){

                oblist.add(new Report_5(rs.getString(1),rs.getString(2)
                ));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        n_purch.setCellValueFactory(new PropertyValueFactory<>("n_of_purch"));
        mnth.setCellValueFactory(new PropertyValueFactory<>("mnth"));



        table_r5.setItems(oblist);
    }
}
