import Models.Customer;
import Views.CustomerScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerController implements ActionListener {
    private CustomerScreen customerScreen;

    private DataAccess dataAccess;

    public CustomerController(CustomerScreen customerScreen, DataAccess dataAccess) {
        this.customerScreen = customerScreen;
        this.dataAccess = dataAccess;

        this.customerScreen.getBtnAddCustomer().addActionListener(this);
        this.customerScreen.getBtnLoadCustomer().addActionListener(this);
        this.customerScreen.getBtnUpdateCustomer().addActionListener(this);
        this.customerScreen.getBtnDeleteCustomer().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerScreen.getBtnAddCustomer()) {
            System.out.println("Customer Add Button Pressed");
            Customer customer = new Customer();

            String cname = customerScreen.getTxtCustomerName().getText();
            int cid = Integer.parseInt(customerScreen.getTxtCustomerID().getText());
            String caddress = customerScreen.getTxtCustomerAddress().getText();
            String cphone = customerScreen.getTxtCustomerPhone().getText();

            customer.setCustomerID(cid);
            customer.setCustomerName(cname);
            customer.setCustomerAddress(caddress);
            customer.setCustomerPhone(cphone);

            dataAccess.addCustomer(customer);
        } else if (e.getSource() == customerScreen.getBtnUpdateCustomer()) {
            System.out.println("Customer Update Button Pressed");
            Customer customer = new Customer();

            String cname = customerScreen.getTxtCustomerName().getText();
            int cid = Integer.parseInt(customerScreen.getTxtCustomerID().getText());
            String caddress = customerScreen.getTxtCustomerAddress().getText();
            String cphone = customerScreen.getTxtCustomerPhone().getText();

            customer.setCustomerID(cid);
            customer.setCustomerName(cname);
            customer.setCustomerAddress(caddress);
            customer.setCustomerPhone(cphone);

            dataAccess.updateCustomer(customer);

        } else if (e.getSource() == customerScreen.getBtnLoadCustomer()) {
            System.out.println("Customer Load Button Pressed");
            int cid = Integer.parseInt(customerScreen.getTxtCustomerID().getText());
            Customer customer = dataAccess.loadCustomer(cid);

            customerScreen.setTxtCustomerName(customer.getCustomerName());
            customerScreen.setTxtCustomerAddress(customer.getCustomerAddress());
            customerScreen.setTxtCustomerPhone(customer.getCustomerPhone());


        } else if (e.getSource() == customerScreen.getBtnDeleteCustomer()) {
            System.out.println("Customer Delete Button Pressed");
            int cid = Integer.parseInt(customerScreen.getTxtCustomerID().getText());
            dataAccess.deleteCustomer(cid);
            System.out.println("Customer Delete Successful");



        }

    }
}
