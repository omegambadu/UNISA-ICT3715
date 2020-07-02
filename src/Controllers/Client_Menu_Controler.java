package Controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import obj.Client;
import obj.Client_Validation;
import sample.DbConnector;
import sample.jdbcDAO;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Client_Menu_Controler implements Initializable {
    //TEXTFIELDS
    @FXML
    public TextField id_In;
    @FXML
    public TextField nme_In;
    @FXML
    public TextField c_tel_h_In;
    @FXML
    public TextField c_tel_w_In;
    @FXML
    public TextField s_nme_In;
    @FXML
    public TextField code_In;
    @FXML
    public TextField email_In;
    @FXML
    public TextField c_tel_c_In;
    @FXML
    public TextField filterSearch_In;
    @FXML
    public TextArea addrIn;

    @FXML
    public static TextArea console;


    @FXML
    public Label nme_err_mess;
    @FXML
    public Label email_err_mess;
    @FXML
    public Label code_err_mess;
    @FXML
    public Label s_name_err_mess;
    @FXML
    public Label c_tel_h_err_mess;
    @FXML
    public Label c_tel_w_err_mess;
    @FXML
    public Label c_tel_c_err_mess;
    @FXML
    public Label ref_err_mess;
    @FXML
    public Label id_err_mess;




    @FXML
    public Label sname_lbl;
    @FXML
    public Label c_id_lbel;
    @FXML
    public Label adress_lbl;
    @FXML
    public Label mail_lbl;
    @FXML
    public Label c_tel_h_lbl;
    @FXML
    public Label c_tel_c_lbl;
    @FXML
    public Label rfr_lbl;
    @FXML
    public Label nme_lbl;
    @FXML
    public Label c_tel_w_lbl;
    @FXML
    public Label code_lbl;


    @FXML
    public Button btnClear;

    @FXML
    public Button btnAddClient;




    @FXML
    public ChoiceBox<String> ref_In;






            //TABLE CLIENTS FXML
    @FXML
    private TableView <Client>client_view;
    @FXML
    private TableColumn<Client,String > col_id;
    @FXML
    private TableColumn<Client,String > col_nme;
    @FXML
    private TableColumn<Client,String > col_snme;
    @FXML
    private TableColumn<Client,String > col_adrr;
    @FXML
    private TableColumn<Client,String > col_code;
    @FXML
    private TableColumn<Client,String > col_tel_h;
    @FXML
    private TableColumn<Client,String > col_tel_w;
    @FXML
    private TableColumn<Client,String > col_tel_c;
    @FXML
    private TableColumn<Client,String > col_mail;
    @FXML
    private TableColumn<Client,String > col_ref_id;



    ObservableList<String>ref_Options= FXCollections.observableArrayList();
    Connection con= DbConnector.getConnection();

    ObservableList<Client> listM;
    ObservableList<Client> dataList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadChoiceBoxData();
         searchClients();
    }


    @FXML
    private void onAddItem(javafx.event.ActionEvent actionEvent) throws SQLException {
    // Called when we need to add a client
        boolean clientId= Client_Validation.txtfieldNotEmpty(id_In,id_err_mess);
        boolean  name= Client_Validation.txtfieldNotEmpty(nme_In,nme_err_mess);
        boolean  surname= Client_Validation.txtfieldNotEmpty(s_nme_In,s_name_err_mess);
      // boolean mail= Client_Validation.txtfieldNotEmpty(email_In,email_err_mess);
        boolean code= Client_Validation.txtfieldNotEmpty(code_In,code_err_mess);
        boolean  c_tel_h= Client_Validation.txtfieldNotEmpty(c_tel_h_In,c_tel_h_err_mess);
        boolean c_tel_w= Client_Validation.txtfieldNotEmpty(c_tel_w_In,c_tel_w_err_mess);
        boolean c_tel_c=Client_Validation.txtfieldNotEmpty(c_tel_c_In,c_tel_c_err_mess);
        boolean choiceBox=Client_Validation.getChoiceBox(ref_In,ref_err_mess);
        boolean validateEmailRegex=Client_Validation.isEmailValid(email_In,email_err_mess);

        if ((clientId)&&(choiceBox)&& (name)) {
              Client client= new Client(id_In.getText(),nme_In.getText(),s_nme_In.getText(),
                      addrIn.getText(),code_In.getText(),c_tel_h_In.getText(),c_tel_w_In.getText(),
                      c_tel_c_In.getText(),email_In.getText(), ref_In.getValue() );
              jdbcDAO.addClient(client);
         }
          else System.out.println("client not entered");

    }

    @FXML
    public void refresh(MouseEvent mouseEvent) throws SQLException {
        searchClients();
    }

    private void loadChoiceBoxData(){
    ref_Options.removeAll(ref_Options);
    String op1=  "1-Website";
    String op2=  "2-Word by mouth";
    String op3=  "3-Friend" ;
    String op4=  "4-Facebook";
    String op5=  "5-Myself";
    String op6=  "6-Other";
    ref_Options.addAll(op1,op2,op3,op4,op5,op6);
    ref_In.getItems().addAll(ref_Options);
    }

    private void searchClients(){
   //  filter search textfield
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nme.setCellValueFactory(new PropertyValueFactory<>("nme"));
        col_snme.setCellValueFactory(new PropertyValueFactory<>("snme"));
        col_adrr.setCellValueFactory(new PropertyValueFactory<>("adrss"));
        col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
        col_tel_h.setCellValueFactory(new PropertyValueFactory<>("tel_h"));
        col_tel_w.setCellValueFactory(new PropertyValueFactory<>("tel_w"));
        col_tel_c.setCellValueFactory(new PropertyValueFactory<>("tel_c"));
        col_mail.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_ref_id.setCellValueFactory(new PropertyValueFactory<>("ref_id"));

        dataList = DbConnector.getAllClients();
        client_view.setItems(dataList);
        FilteredList<Client> filteredData = new FilteredList<>(dataList, b -> true);
        filterSearch_In.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return false;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getId().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches id
                } else if (person.getNme().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches nme
                }else if (person.getCode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches code
                } else if (person.getTel_h().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true; // Filter matches getTel_h
                }
                else if (String.valueOf(person.getEmail()).indexOf(lowerCaseFilter)!=-1)
                    return true;// Filter matches email

                else
                    return false; // Does not match.
            });
        });
        SortedList<Client> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(client_view.comparatorProperty());
        client_view.setItems(sortedData);
    }

}