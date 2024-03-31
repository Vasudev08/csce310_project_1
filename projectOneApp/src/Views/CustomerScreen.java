package Views;

import Models.Customer;

import javax.swing.*;
import java.awt.*;

public class CustomerScreen extends JFrame {

    private JTextField txtCustomerID = new JTextField(10);
    private JTextField txtCustomerName = new JTextField(10);
    private JTextField txtCustomerAddress = new JTextField(10);
    private JTextField txtCustomerPhone = new JTextField(10);

    private JButton btnAddCustomer = new JButton("Add Customer");
    private JButton btnUpdateCustomer = new JButton("Update Customer");

    private JButton btnLoadCustomer = new JButton("Load Customer");

    private JButton btnDeleteCustomer = new JButton("Delete Customer");


    public JTextField getTxtCustomerName() {
        return txtCustomerName;
    }

    public JTextField getTxtCustomerAddress() {
        return txtCustomerAddress;
    }

    public JTextField getTxtCustomerPhone() {
        return txtCustomerPhone;
    }

    public JTextField getTxtCustomerID() {
        return  txtCustomerID;
    }

    public void setTxtCustomerID(String value) {
        txtCustomerID.setText(value);
    }

    public void setTxtCustomerName(String value) {
        txtCustomerName.setText(value);
    }

    public void setTxtCustomerAddress(String value) {
        txtCustomerAddress.setText(value);
    }

    public void setTxtCustomerPhone(String value) {
        txtCustomerPhone.setText(value);
    }

    public JButton getBtnAddCustomer() {
        return btnAddCustomer;
    }

    public JButton getBtnUpdateCustomer() {
        return btnUpdateCustomer;
    }

    public JButton getBtnLoadCustomer() {
        return btnLoadCustomer;
    }

    public JButton getBtnDeleteCustomer() {
        return btnDeleteCustomer;
    }



    public CustomerScreen() {
        System.out.println("Customer Screen Constructor");

        this.setSize(500, 200);
        this.setTitle("Store Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5,5 ));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        inputPanel.add(new JLabel("Customer ID:"));
        inputPanel.add(txtCustomerID);

        inputPanel.add(new JLabel("Customer Name"));
        inputPanel.add(txtCustomerName);

        inputPanel.add(new JLabel("Customer Address"));
        inputPanel.add(txtCustomerAddress);

        inputPanel.add(new JLabel("Customer Phone"));
        inputPanel.add(txtCustomerPhone);



        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5)); // 2 rows, 1 column, with 5 pixels gap
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        buttonPanel.add(btnAddCustomer);
        buttonPanel.add(btnUpdateCustomer);
        buttonPanel.add(btnLoadCustomer);
        buttonPanel.add(btnDeleteCustomer);



        this.add(inputPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
