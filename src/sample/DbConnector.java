package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import obj.Client;
import obj.Supplier;

import java.sql.*;

public class DbConnector {


    public static Connection getConnection (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/67608566","root","");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;

    }


    public static ObservableList<Client> getAllClients(){
        Connection conn = getConnection();
        ObservableList<Client> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from tblclientinfo ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Client(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));

            }
        } catch (Exception e) {

        }

        return list;
    }


    public static ObservableList<Supplier> getAllSuppliers() throws SQLException {
        Connection con = getConnection();
        ObservableList<Supplier> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("select * from tblsupplier_info ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Supplier(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }

        }
        catch (Exception e) {
        }
        finally{
            con.close();
        }
        return list;
    }





}

