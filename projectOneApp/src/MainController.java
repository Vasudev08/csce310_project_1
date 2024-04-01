import Views.MainScreen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainController implements ActionListener {
    private MainScreen mainScreen;

    private DataAccess dataAccess;

    public MainController(MainScreen mainScreen, DataAccess dataAccess) {
        this.dataAccess = dataAccess;
        this.mainScreen = mainScreen;

        this.mainScreen.getBtnCustomer().addActionListener(this);
        this.mainScreen.getBtnProduct().addActionListener(this);
        this.mainScreen.getBtnSupplier().addActionListener(this);
        this.mainScreen.getBtnMakeOrder().addActionListener(this);
        this.mainScreen.getBtnEditOrder().addActionListener(this);
        this.mainScreen.getBtnEditPayment().addActionListener(this);
        this.mainScreen.getBtnSalesReport().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainScreen.getBtnCustomer()) {
            System.out.println("Customer Button Pressed");
            this.mainScreen.setVisible(false);
            Application.getInstance().getCustomerScreen().setVisible(true);

        } else if (e.getSource() == mainScreen.getBtnProduct()) {
            System.out.println("Product Button Pressed");
            this.mainScreen.setVisible(false);
            Application.getInstance().getProductScreen().setVisible(true);

        } else if (e.getSource() == mainScreen.getBtnSupplier()) {
            System.out.println("Supplier Button Pressed");
            this.mainScreen.setVisible(false);
            Application.getInstance().getSupplierScreen().setVisible(true);

        } else if (e.getSource() == mainScreen.getBtnMakeOrder()) {
            System.out.println("MakeOrder Button Pressed");
            this.mainScreen.setVisible(false);
            Application.getInstance().getMakeOrderScreen().setVisible(true);

        } else if (e.getSource() == mainScreen.getBtnEditOrder()) {
            System.out.println("EditOrder Button Pressed");
            this.mainScreen.setVisible(false);
            Application.getInstance().getEditOrderScreen().setVisible(true);


        } else if (e.getSource() == mainScreen.getBtnEditPayment()) {
            System.out.println("EditPayment Button Pressed");
            this.mainScreen.setVisible(false);
            Application.getInstance().getEditPaymentScreen().setVisible(true);

        } else if (e.getSource() == mainScreen.getBtnSalesReport()) {
            System.out.println("Sales Report Button Pressed");
            this.mainScreen.setVisible(false);
            Application.getInstance().getSalesReportScreen().setVisible(true);

        }

    }
}
