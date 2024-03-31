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
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainScreen.getBtnCustomer()) {
            System.out.println("Customer Button Pressed");
            this.mainScreen.setVisible(false);
            Application.getInstance().getCustomerScreen().setVisible(true);

        }

    }
}
