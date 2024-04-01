import Models.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

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

//    OrderItem.getProductID();

    private List<OrderItem> orderItems = new ArrayList<>();

    public void addSelectedProduct(String productID, int productQuantity) {
        orderItems.add(new OrderItem(productID, productQuantity));
        System.out.println(orderItems);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
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

    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList<>();

        try {
            String query = "SELECT * FROM Product";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Product product = new Product();

                product.setProductID(resultSet.getInt(1));
                product.setProductName(resultSet.getString(2));
                product.setProductQuantity(resultSet.getInt(3));
                product.setProductCost(resultSet.getDouble(4));

                productList.add(product);
            }

            resultSet.close();
            statement.close();




        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
//            throw new RuntimeException(e);
        }

        return productList;
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


    public boolean addSupplier(Supplier supplier) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Supplier WHERE supplierID = ?");
            statement.setInt(1, supplier.getSupplierID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Supplier SET supplierID = ?, supplierName = ?, supplierAddress = ?, supplierPhone = ? WHERE supplierID = ?");
                statement.setInt(1, supplier.getSupplierID());
                statement.setString(2, supplier.getSupplierName());
                statement.setString(3, supplier.getSupplierAddress());
                statement.setString(4, supplier.getSupplierPhone());
                statement.setInt(5, supplier.getSupplierID());


            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Supplier VALUES (?, ?, ?, ?)");
                statement.setInt(1, supplier.getSupplierID());
                statement.setString(2, supplier.getSupplierName());
                statement.setString(3, supplier.getSupplierAddress());
                statement.setString(4, supplier.getSupplierPhone());

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

    public boolean updateSupplier(Supplier supplier) {
        try {
            PreparedStatement statement = connection.prepareStatement(  "UPDATE Supplier SET supplierID = ?, supplierName = ?, supplierAddress = ?, supplierPhone = ? WHERE supplierID = ?");
            statement.setInt(1, supplier.getSupplierID());
            statement.setString(2, supplier.getSupplierName());
            statement.setString(3, supplier.getSupplierAddress());
            statement.setString(4, supplier.getSupplierPhone());
            statement.setInt(5, supplier.getSupplierID());

            int rows = statement.executeUpdate();
            statement.close();
            System.out.println((String.format("Product Updated: %s", supplier.getSupplierID())) );

            if (rows > 0) {
                System.out.println("Supplier Data Updated");
                return true;
            } else {
                System.out.println("No Supplier found with the given ID");
                return false;
            }


        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }
    }


    public Supplier loadSupplier(int supplierID) {
        try {
            String query = "SELECT * FROM Supplier WHERE supplierID = " + supplierID;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                Supplier supplier = new Supplier();

                supplier.setSupplierID(resultSet.getInt(1));
                supplier.setSupplierName(resultSet.getString(2));
                supplier.setSupplierAddress(resultSet.getString(3));
                supplier.setSupplierPhone(resultSet.getString(4));

                resultSet.close();
                statement.close();

                return supplier;
            }
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();

        }
        return null;
    }


    public boolean deleteSupplier(int supplierID) {
        try {
            String query = "DELETE FROM Supplier WHERE supplierID = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, supplierID);


            int rows = statement.executeUpdate();
            statement.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }

    public int getLastOrderID() {
        int lastOrderID = -1;

        try {
            String query = "SELECT MAX(orderID) FROM ProductPayment";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                lastOrderID = resultSet.getInt(1);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving last orderId: " + e.getMessage());

        }

        return lastOrderID;
    }

    public double getOrderCost() {
        double cost = 0;
        orderItems = getOrderItems();

        for (OrderItem orderItem : orderItems) {
            int pid = parseInt(orderItem.getProductID());
            int pqua = orderItem.getProductQuantity();

            Product product = loadProduct(pid);

            cost +=  (product.getProductCost() * pqua);

        }

        return cost;
    }

    public void addOrder(int orderID, int customerID, String payment) {
        System.out.println("working add Order");

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ProductPayment VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, orderID);
            statement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            statement.setInt(3, customerID);
            statement.setDouble(4, getOrderCost());
            statement.setString(5, payment);


            statement.execute();
            statement.close();




        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }

        orderItems = getOrderItems();

        for (OrderItem orderItem : orderItems) {
            int pid = parseInt(orderItem.getProductID());
            int pqua = orderItem.getProductQuantity();

            try {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO ProductOrder VALUES (?, ?, ?)");
                statement.setInt(1, orderID);
                statement.setInt(2, pid);
                statement.setInt(3, pqua);

                statement.execute();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Database access error!");
                e.printStackTrace();
            }
        }
    }

    public void addPayment(int cid, String customerCardNumber, String customerCardExpiry) {
        System.out.println("Adding Payment method");

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO CustomerPayment VALUES (?, ?, ?)");
            statement.setInt(1, cid);
            statement.setString(2, customerCardNumber);
            statement.setString(3, customerCardExpiry);

            statement.execute();
            statement.close();


        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }

    }

    public Orders loadOrder(int orderID) {
        try {
            String query = "SELECT * FROM ProductPayment WHERE orderID = " + orderID;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                Orders orders = new Orders();

                orders.setOrderDate(resultSet.getString(2));
                orders.setCustomerID(String.valueOf(resultSet.getInt(3)));
                orders.setPaymentType(resultSet.getString(5));



                resultSet.close();
                statement.close();

                return orders;
            }
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();

        }
        return null;
    }


    public boolean updateOrder(Orders orders) {
        try {
            PreparedStatement statement = connection.prepareStatement(  "UPDATE ProductPayment SET orderID = ?, orderDate = ?, customerID = ? WHERE orderID = ?");
            statement.setInt(1, orders.getOrderID());
            statement.setString(2, orders.getOrderDate());
            String cid;
            cid = orders.getCustomerID();
//            System.out.println(cid);
//            System.out.println(orders.getOrderDate());
            statement.setString(3, cid);
            statement.setInt(4, orders.getOrderID());




            int rows = statement.executeUpdate();
            statement.close();
            System.out.println((String.format("Orders Updated: %s", orders.getOrderID())) );

            if (rows > 0) {
                System.out.println("Orders Data Updated");
                return true;
            } else {
                System.out.println("No Orders found with the given ID");
                return false;
            }


        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }
    }

    public Payment loadPayment(int customerID) {
        try {
            String query = "SELECT * FROM CustomerPayment WHERE customerID = " + customerID;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                Payment payment = new Payment();
                payment.setCustomerCardNumber(resultSet.getString(2));
                payment.setCustomerCardExpiry(resultSet.getString(3));

                resultSet.close();
                statement.close();

                return payment;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean updatePayment(Payment payment) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE CustomerPayment SET customerID = ?, customerCardNumber = ?, customerCardExpiry = ? WHERE customerID = ?");
            statement.setInt(1, payment.getCustomerID());
            statement.setString(2, payment.getCustomerCardNumber());
            statement.setString(3, payment.getCustomerCardExpiry());
            statement.setInt(4, payment.getCustomerID());

            int rows = statement.executeUpdate();
            statement.close();
            System.out.println((String.format("Payment Updated: %s", payment.getCustomerID())));

            if (rows > 0) {
                System.out.println("Payment Data Updated");
                return true;
            } else {
                System.out.println("No Payment Found with the Given ID");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
//            throw new RuntimeException(e);
        }
    }

    public List<ProductSale> getTotalSalePerProduct(String startDate, String endDate, boolean sortDescending) {
        List<ProductSale> productSales = new ArrayList<>();

        try {
            String query = "SELECT Product.productID, Product.productName, " +
                    "SUM(ProductOrder.orderQuantity) AS totalQuantity, " +
                    "SUM(ProductOrder.orderQuantity * Product.productCost) AS totalSale " +
                    "FROM Product " +
                    "JOIN ProductOrder ON Product.productID = ProductOrder.productID " +
                    "JOIN ProductPayment ON ProductOrder.orderID = ProductPayment.orderID " +
                    "WHERE ProductPayment.orderDate BETWEEN ? AND ? " +
                    "GROUP BY Product.productID, Product.productName " + // Ensure there is a space here
                    (sortDescending ? "ORDER BY totalSale DESC" : "ORDER BY totalSale ASC");



            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, startDate);
            statement.setString(2, endDate);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productID = resultSet.getInt("productID");
                String productName = resultSet.getString("productName");
                int totalQuantity = resultSet.getInt("totalQuantity");
                double totalSale = resultSet.getDouble("totalSale");

                ProductSale productSale = new ProductSale(productID, productName, totalQuantity, totalSale);
                productSales.add(productSale);
            }

            statement.close();
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(productSales.get(0).getProductID());
        System.out.println(productSales.get(0).getProductName());

        System.out.println(productSales.get(0).getTotalSale());

        return productSales;
    }

    public List<CustomerSale> getTotalSalePerCustomer(String startDate, String endDate, boolean sortDescending) {
        List<CustomerSale> customerSales = new ArrayList<>();

        try {
            String query = "SELECT c.customerID, c.customerName, SUM(p.orderCost) AS totalSale " +
                    "FROM ProductPayment p " +
                    "JOIN Customer c ON p.customerID = c.customerID " +
                    "WHERE p.orderDate BETWEEN ? AND ? " +
                    "GROUP BY c.customerID, c.customerName " +  // Added space here
                    (sortDescending ? "ORDER BY totalSale DESC" : "ORDER BY totalSale ASC");


            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, startDate);
            statement.setString(2, endDate);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int customerID = resultSet.getInt("customerID");
                String customerName = resultSet.getString("customerName");
                double totalSale = resultSet.getDouble("totalSale");
                CustomerSale customerSale = new CustomerSale(customerID, customerName, totalSale);
                customerSales.add(customerSale);
            }

            statement.close();
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(customerSales.get(0).getCustomerID());
        System.out.println(customerSales.get(0).getCustomerName());

        System.out.println(customerSales.get(0).getTotalSale());

        return customerSales;
    }


    public void writeMonthlySalesToFile(String startDate, String endDate, boolean sortDescending, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
//            writer.println("Inside getTotalSalePerMonth");
//            writer.println(startDate);
//            writer.println(endDate);
            String query = "SELECT strftime('%Y-%m', orderDate) AS month, SUM(orderCost) AS totalSale " +
                    "FROM ProductPayment " +
                    "WHERE orderDate BETWEEN ? AND ? " +
                    "GROUP BY month " +
                    (sortDescending ? "ORDER BY totalSale DESC" : "ORDER BY totalSale ASC");

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, startDate);
            statement.setString(2, endDate);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String month = resultSet.getString("month");
                double totalSale = resultSet.getDouble("totalSale");
                writer.println("Month: " + month + ", Total Sale: " + totalSale);
            }

            statement.close();
            resultSet.close();
        } catch (SQLException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void writeProductSalesToFile(List<ProductSale> productSales, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (ProductSale productSale : productSales) {
                writer.println("Product ID: " + productSale.getProductID());
                writer.println("Product Name: " + productSale.getProductName());
                writer.println("Total Quantity: " + productSale.getTotalQuantity());
                writer.println("Total Sale: " + productSale.getTotalSale());
                writer.println(); // Add a blank line for separation
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void writeCustomerSalesToFile(List<CustomerSale> customerSales, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (CustomerSale customerSale : customerSales) {
                writer.println("Customer ID: " + customerSale.getCustomerID());
                writer.println("Customer Name: " + customerSale.getCustomerName());
                writer.println("Total Sale: " + customerSale.getTotalSale());
                writer.println(); // Add a blank line for separation
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}
