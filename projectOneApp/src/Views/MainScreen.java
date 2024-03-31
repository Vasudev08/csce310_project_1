package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    private JButton btnCustomer = new JButton("Customer");
    private JButton btnProduct = new JButton("Product");
    private JButton btnSupplier = new JButton("Supplier");
    private JButton btnMakeOrder = new JButton("Make Order");

    private JButton btnEditOrder = new JButton("Edit Order");

    private JButton btnEditPayment = new JButton("Edit Payment");



    public JButton getBtnCustomer() {
        return btnCustomer;
    }

    public JButton getBtnProduct() {return btnProduct;}

    public JButton getBtnSupplier() {return btnSupplier;}

    public JButton getBtnMakeOrder() {return btnMakeOrder;}

    public JButton getBtnEditOrder() {return btnEditOrder;}

    public JButton getBtnEditPayment() {return btnEditPayment;}


    public MainScreen() {
        System.out.println("MainScreen Constructor"); // Debugging statement

        this.setSize(300, 250);
        this.setTitle("Store Management System");
        //this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        //this.getContentPane().add(new JLabel ("Project Management System"));

        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 5, 5)); // 2 rows, 1 column, with 5 pixels gap
        buttonPanel.add(btnCustomer);
        buttonPanel.add(btnProduct);
        buttonPanel.add(btnSupplier);
        buttonPanel.add(btnMakeOrder);
        buttonPanel.add(btnEditOrder);
        buttonPanel.add(btnEditPayment);


        // Connect the above two button to two different views
        // Each having create, read, update and delete funtilaligty
        this.add(buttonPanel, BorderLayout.CENTER);




    }



}
