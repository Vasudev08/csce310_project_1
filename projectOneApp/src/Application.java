
import Models.Customer;
import Views.CustomerScreen;
import Views.MainScreen;
import Views.ProductScreen;
import Views.SupplierScreen;

import javax.xml.crypto.Data;
import java.sql.*;

public class Application {
    private static Application instance;

    private Connection connection;

    private static DataAccess dataAccess;

    private MainScreen mainScreen = new MainScreen();
    private CustomerScreen customerScreen = new CustomerScreen();

    private ProductScreen productScreen = new ProductScreen();

    private SupplierScreen supplierScreen = new SupplierScreen();

    private MainController mainController;
    private CustomerController customerController;

    private ProductController productController;

    public CustomerScreen getCustomerScreen() {
        return customerScreen;
    }

    public ProductScreen getProductScreen() {
        return  productScreen;
    }

    public SupplierScreen getSupplierScreen() {
        return supplierScreen;
    }

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public Connection getConnection() {
        return connection;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }

        return instance;
    }

    private Application() {

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:storeDB.db";

            connection = DriverManager.getConnection(url);
            System.out.println("Connection Made");

            dataAccess = new DataAccess(connection);



        }
        catch (ClassNotFoundException ex) {
            System.out.println("SQLite is not installed. System exits with error!");
            ex.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("SQLite database is not ready. System exits with error!" + e.getMessage());

            System.exit(2);
        }

        mainController = new MainController(mainScreen, dataAccess);
        customerController = new CustomerController(customerScreen, dataAccess);
        productController = new ProductController(productScreen, dataAccess);
    }


    public static void main(String[] args) {
        Application application = new Application();

        System.out.println("Hello World!");

        Customer customer = dataAccess.loadCustomer(6000);
        System.out.println(customer.getCustomerName());

        Application.getInstance().getMainScreen().setVisible(true);
    }
}
