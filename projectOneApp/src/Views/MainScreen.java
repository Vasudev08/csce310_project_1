package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    private JButton btnCustomer = new JButton("Customer");


    public JButton getBtnCustomer() {
        return btnCustomer;
    }


    public MainScreen() {
        System.out.println("MainScreen Constructor"); // Debugging statement

        this.setSize(300, 150);
        this.setTitle("Store Management System");
        //this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        //this.getContentPane().add(new JLabel ("Project Management System"));

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5)); // 2 rows, 1 column, with 5 pixels gap
        buttonPanel.add(btnCustomer);


        // Connect the above two button to two different views
        // Each having create, read, update and delete funtilaligty
        this.add(buttonPanel, BorderLayout.CENTER);




    }



}
