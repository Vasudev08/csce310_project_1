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

        }

    }
}
