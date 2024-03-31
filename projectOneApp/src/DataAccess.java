import Models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    //Constructor Getting connection from the Application
    //And saving it as a private Property

    public DataAccess(Connection connection) {
        this.connection = connection;

    }


    public Customer loadCustomer(int customerID) {
        try {
            String query = "SELECT * FROM Customer WHERE customerID = " + customerID;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Customer customer = new Customer();

                customer.setCustomerID(resultSet.getInt(1));
                customer.setCustomerName(resultSet.getString(2));
                customer.setCustomerAddress(resultSet.getString(3));
                customer.setCustomerPhone(resultSet.getString(4));
                resultSet.close();
                statement.close();

                return customer;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }


    public boolean deleteCustomer(int customerID) {
        try {
            String query = "DELETE FROM Customer WHERE customerID =  ?";

            PreparedStatement statement = connection.prepareStatement((query));
            statement.setInt(1, customerID);


            int rowsAffected = statement.executeUpdate();

            statement.close();

            // If rowsAffected is greater than 0, it means a record was deleted
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }


}
