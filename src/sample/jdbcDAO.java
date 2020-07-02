package sample;

import Controllers.Supplier_Menu_Controler;
import javafx.scene.control.TextField;
import obj.Client;
import obj.Supplier;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcDAO {

    private static final String INSERT_CLIENT = "INSERT INTO tblclientinfo" +
            " (Client_id, C_name, C_surname,Address,Code,C_Tel_H,C_Tel_W,C_Tel_C,C_Email,Reference_ID)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final String INSERT_SUPPLIER = "INSERT INTO tblsupplier_info" +
            " (Supplier_ID,Contact_Person,Supplier_Tel,Supplier_Email,Bank,Bank_code,Supplier_BankNum,Supplier_Type_Bank_Account)" +
            " VALUES (?,?,?,?,?,?,?,?)";


    public static void addClient(Client client) throws SQLException {

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (
                Connection connection= DbConnector.getConnection();


             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT)) {
            preparedStatement.setString(1, client.getId());
            preparedStatement.setString(2,client.getNme());
            preparedStatement.setString(3, client.getSnme());
            preparedStatement.setString(4, client.getAdrss());
            preparedStatement.setString(5, client.getCode());
            preparedStatement.setString(6, client.getTel_h());
            preparedStatement.setString(7,client.getTel_w());
            preparedStatement.setString(8, client.getTel_c());
            preparedStatement.setString(9, client.getEmail());
            preparedStatement.setString(10, client.getRef_id());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            e.printStackTrace();
        }
    }


    public static void addSupplier(Supplier supplier) throws Exception {

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        Connection connection= DbConnector.getConnection();


        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SUPPLIER);
        try
                {
            preparedStatement.setString(1, supplier.getSupp_id());
            preparedStatement.setString(2,supplier.getCntct_p());
            preparedStatement.setString(3, supplier.getSupp_tel());
            preparedStatement.setString(4, supplier.getSupp_mail());
            preparedStatement.setString(5, supplier.getBank());
            preparedStatement.setString(6, supplier.getBank_cde());
            preparedStatement.setString(7,supplier.getBank_num());
            preparedStatement.setString(8, supplier.getBank_acc_type());

            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // print SQL exception information
            System.out.println("exception caught dao"  );

        }
    }

    public static boolean IDexists(TextField id) throws SQLException {
        boolean recordAdded = false;
        Connection con = DbConnector.getConnection();
        try {

            PreparedStatement stmt = con.prepareStatement(
                    "SELECT Supplier_ID FROM tblsupplier_info where Supplier_ID = ?");
            stmt.setString(1, (id.getText()));
            ResultSet rs = stmt.executeQuery();
            while (!rs.next()) {
                recordAdded = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            con.close();
        }
      return recordAdded;
    }//end

}
