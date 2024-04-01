import Models.Customer;
import Views.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    private static Application instance;

    private Connection connection;

    private static DataAccess dataAccess;

    private MainScreen mainScreen = new MainScreen();
    private CustomerScreen customerScreen = new CustomerScreen();

    private ProductScreen productScreen = new ProductScreen();

    private SupplierScreen supplierScreen = new SupplierScreen();

    private MakeOrderScreen makeOrderScreen = new MakeOrderScreen();

    private PaymentScreen paymentScreen = new PaymentScreen();

    private EditOrderScreen editOrderScreen = new EditOrderScreen();

    private EditPaymentScreen editPaymentScreen = new EditPaymentScreen();

    private SalesReportScreen salesReportScreen = new SalesReportScreen();


    private MainController mainController;
    private CustomerController customerController;

    private ProductController productController;

    private SupplierController supplierController;

    private MakeOrderController makeOrderController;

    private PaymentController paymentController;

    private EditOrderController editOrderController;

    private EditPaymentController editPaymentController;

    private SalesReportController salesReportController;

    public CustomerScreen getCustomerScreen() {
        return customerScreen;
    }

    public EditPaymentScreen getEditPaymentScreen() {
        return editPaymentScreen;
    }

    public EditOrderScreen getEditOrderScreen() {return editOrderScreen;}

    public MakeOrderScreen getMakeOrderScreen() {
        return makeOrderScreen;
    }

    public ProductScreen getProductScreen() {
        return  productScreen;
    }

    public SupplierScreen getSupplierScreen() {
        return supplierScreen;
    }

    public SalesReportScreen getSalesReportScreen() {
        return salesReportScreen;
    }

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public PaymentScreen getPaymentScreen() {
        return paymentScreen;
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
        supplierController = new SupplierController(supplierScreen, dataAccess);
        makeOrderController = new MakeOrderController(makeOrderScreen, paymentScreen,dataAccess);
        paymentController = new PaymentController(paymentScreen, dataAccess);
        editOrderController = new EditOrderController(editOrderScreen, dataAccess);
        editPaymentController = new EditPaymentController(editPaymentScreen, dataAccess);
        salesReportController = new SalesReportController(salesReportScreen, dataAccess);

        // TO-DO
        // Create an order screen where you input customer, input product and product quantity
        // have to display product in the table, two inputs to select product and product quantity
        // and once select an product and product quantity add it to an order list/array
        // here, for now we will manually input a existing customerID but in future, the user can
        // select whether it's an new customer or existing customer, if new add all the details of an cutsomer in
        // next page
    }


    public static void main(String[] args) {
        Application application = new Application();

        System.out.println("Hello World!");

        Customer customer = dataAccess.loadCustomer(6000);
        System.out.println(customer.getCustomerName());

        Application.getInstance().getMainScreen().setVisible(true);
    }
}
