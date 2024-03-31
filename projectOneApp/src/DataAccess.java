import Models.Customer;
import Models.Product;

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

    public boolean addCustomer(Customer customer) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customer WHERE customerID = ?");
            statement.setInt(1, customer.getCustomerID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Customer SET customerID = ?, customerName = ?, customerAddress = ?, customerPhone = ? WHERE customerID = ?");
                statement.setInt(1, customer.getCustomerID());
                statement.setString(2, customer.getCustomerName());
                statement.setString(3, customer.getCustomerAddress());
                statement.setString(4, customer.getCustomerPhone());


            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Customer VALUES (?, ?, ?, ?)");
                statement.setInt(1, customer.getCustomerID());
                statement.setString(2, customer.getCustomerName());
                statement.setString(3, customer.getCustomerAddress());
                statement.setString(4, customer.getCustomerPhone());
            }
            statement.execute();
            resultSet.close();
            statement.close();
            return true;        // save successfully

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }

    }

    public boolean updateCustomer(Customer customer) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Customer SET customerID = ?, customerName = ?, customerAddress = ?, customerPhone = ? WHERE customerID = ?");
            statement.setInt(1, customer.getCustomerID());
            statement.setString(2, customer.getCustomerName());
            statement.setString(3, customer.getCustomerAddress());
            statement.setString(4, customer.getCustomerPhone());
            statement.setInt(5, customer.getCustomerID()); // Bind the last parameter




            int rowsAffected = statement.executeUpdate();
            statement.close();     // save successfully
            System.out.println(String.format("Customer Updated: %s", customer.getCustomerID()));


            if (rowsAffected > 0) {
                System.out.println("Customer Data Updated");
                return true;
            } else {
                System.out.println("No customer found with the given ID.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }
    }

    public Product loadProduct(int productID) {
        try {
            String query = "SELECT * FROM Product WHERE productID = " + productID;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Product product = new Product();

                product.setProductID(resultSet.getInt(1));
                product.setProductName(resultSet.getString(2));
                product.setProductQuantity(resultSet.getInt(3));
                product.setProductCost(resultSet.getDouble(4));


                resultSet.close();
                statement.close();

                return product;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;

    }

    public boolean deleteProduct(int productID) {
        try {
            String query = "DELETE FROM Product WHERE productID =  ?";

            PreparedStatement statement = connection.prepareStatement((query));
            statement.setInt(1, productID);


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

    public boolean addProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE productID = ?");
            statement.setInt(1, product.getProductID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Product SET productID = ?, productName = ?, productQuantity = ?, productCost = ? WHERE productID = ?");
                statement.setInt(1, product.getProductID());
                statement.setString(2, product.getProductName());
                statement.setInt(3, product.getProductQuantity());
                statement.setDouble(4, product.getProductCost());
                statement.setInt(5, product.getProductID());



            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?)");
                statement.setInt(1, product.getProductID());
                statement.setString(2, product.getProductName());
                statement.setInt(3, product.getProductQuantity());
                statement.setDouble(4, product.getProductCost());
            }
            statement.execute();
            resultSet.close();
            statement.close();
            return true;        // save successfully

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }

    }

    public boolean updateProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Product SET productID = ?, productName = ?, productQuantity = ?, productCost = ? WHERE productID = ?");
            statement.setInt(1, product.getProductID());
            statement.setString(2, product.getProductName());
            statement.setInt(3, product.getProductQuantity());
            statement.setDouble(4, product.getProductCost());
            statement.setInt(5, product.getProductID());

            int rowAffected = statement.executeUpdate();
            statement.close();
            System.out.println(String.format("Product Updated: %s", product.getProductID()));

            if (rowAffected > 0) {
                System.out.println("Product Data Updated");
                return true;
            } else {
                System.out.println("No Proudct found with the given ID");
                return false;
            }


        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }


}
