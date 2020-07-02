package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import obj.Client;
import obj.Client_Validation;
import obj.Supplier;
import sample.DbConnector;
import sample.jdbcDAO;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Supplier_Menu_Controler implements Initializable {

    @FXML
    private Label id_err_mess;

    @FXML
    private TextField acc_type;

    @FXML
    private TextField acc_num;

    @FXML
    private TextField mail;

    @FXML
    private TableColumn<Supplier,String> bnk_col;

    @FXML
    private Label nme_err_mess;

    @FXML
    private Label email_err_mess;

    @FXML
    private TextField filterSearch;

    @FXML
    private TableColumn<Supplier,String> mail_col;

    @FXML
    private TableColumn<Supplier,String> tel_col;

    @FXML
    private TextField tel;

    @FXML
    private Label c_tel_c_err_mess;

    @FXML
    private TableColumn<Supplier,String> cnct_col;

    @FXML
    private TextField bnk;

    @FXML
    private Label code_err_mess;

    @FXML
    private Button btnAddSupplier;

    @FXML
    private TableColumn<?, ?> acc_num_col;

    @FXML
    public  TextArea console;

    @FXML
    private Label c_tel_w_err_mess;

    @FXML
    private TextField ctc_p;

    @FXML
    private TableColumn<?, ?> bnk_cde_col;

    @FXML
    private TextField bnk_cde;

    @FXML
    private Label c_tel_h_err_mess;

    @FXML
    private TextField supli_id;


    @FXML
    private ImageView refresh;
    @FXML
    private Label ref_err_mess;

    @FXML
    private Label s_name_err_mess;



    @FXML
    private TableView<Supplier> supplier_view;
    @FXML
    private TableColumn<Supplier,String> sup_id_col;
    @FXML
    private TableColumn<Supplier,String> acc_type_col;


    Connection con= DbConnector.getConnection();
    ObservableList<Supplier> suppList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            searchSuppliers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void searchSuppliers() throws SQLException {
        //  filter search textfield
        sup_id_col.setCellValueFactory(new PropertyValueFactory<>("supp_id"));
        cnct_col.setCellValueFactory(new PropertyValueFactory<>("cntct_p"));
        tel_col.setCellValueFactory(new PropertyValueFactory<>("supp_tel"));
        mail_col.setCellValueFactory(new PropertyValueFactory<>("supp_mail"));
        bnk_col.setCellValueFactory(new PropertyValueFactory<>("bank"));
        bnk_cde_col.setCellValueFactory(new PropertyValueFactory<>("bank_cde"));
        acc_num_col.setCellValueFactory(new PropertyValueFactory<>("bank_num"));
        acc_type_col.setCellValueFactory(new PropertyValueFactory<>("bank_acc_type"));


        suppList = DbConnector.getAllSuppliers();
        supplier_view.setItems(suppList);
        FilteredList<Supplier> filteredData = new FilteredList<>(suppList, b -> true);
        filterSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return false;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getSupp_id().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches id
                } else if (person.getCntct_p().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches cntct name
                }else if (person.getBank_num().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches bank num
                } else if (person.getSupp_tel().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches getTel_h
                }
                else if (String.valueOf(person.getSupp_mail()).indexOf(lowerCaseFilter)!=-1)
                    return true;// Filter matches email

                else
                    return false; // Does not match.
            });
        });
        SortedList<Supplier> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(supplier_view.comparatorProperty());
        supplier_view.setItems(sortedData);
    }

    @FXML
    public void refresh(MouseEvent mouseEvent) throws SQLException {
    searchSuppliers();
    }

    @FXML
    private void onAddItem(javafx.event.ActionEvent actionEvent) throws SQLException {
        // Called when we need to add a supplier
        boolean valid_id= jdbcDAO.IDexists(supli_id);

     /*   try {
            boolean supplId = Client_Validation.txtfieldNotEmpty(supli_id, id_err_mess);
            boolean contact_p = Client_Validation.txtfieldNotEmpty(ctc_p, nme_err_mess);
            boolean tele = Client_Validation.txtfieldNotEmpty(tel, s_name_err_mess);
            boolean validateEmailRegex = Client_Validation.isEmailValid(mail, email_err_mess);
            if ((supplId) && (contact_p) && (tele) && (validateEmailRegex)) {
                Supplier supplier = new Supplier(supli_id.getText(), ctc_p.getText(), tel.getText(),
                        mail.getText(), bnk.getText(), bnk_cde.getText(), acc_num.getText(), acc_type.getText());
                jdbcDAO.addSupplier(supplier);
                console.setText("");
                console.setText("-Client added successfully-");
                System.out.println(valid_id);
            } else {
                console.setText("");
                console.setText("-Supplier not added, please try again-");

            }
        }//end try
        catch (Exception e) {
          System.out.println("exception caught here too");


        }  //end onAddItem method  */


    }
}
