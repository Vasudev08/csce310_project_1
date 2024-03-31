package Views;

import javax.swing.*;
import java.awt.*;

public class EditPaymentScreen extends JFrame {

    private JTextField txtCustomerID = new JTextField(10);

    private JTextField txtCustomerCardNumber = new JTextField(10);

    private JTextField txtCustomerCardExpiry = new JTextField(10);

    private JButton btnUpdateCard = new JButton("Update Card");

    private JButton btnLoadCard = new JButton("Load Card");

    public JTextField getTxtCustomerCardNumber() {
        return txtCustomerCardNumber;
    }

    public JTextField getTxtCustomerID() {
        return txtCustomerID;
    }

    public JTextField getTxtCustomerCardExpiry() {
        return txtCustomerCardExpiry;
    }

    public JButton getBtnLoadCard() {
        return btnLoadCard;
    }

    public JButton getBtnUpdateCard() {
        return btnUpdateCard;
    }

    public void setTxtCustomerID(String value) {
        txtCustomerID.setText(value);
    }

    public void setTxtCustomerCardNumber(String value) {
        txtCustomerCardNumber.setText(value);
    }

    public void setTxtCustomerCardExpiry(String value) {
        txtCustomerCardExpiry.setText(value);
    }

    public EditPaymentScreen() {
        this.setSize(500, 200);
        this.setTitle("Store Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5,5 ));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        inputPanel.add(new JLabel("Customer ID:"));
        inputPanel.add(txtCustomerID);

        inputPanel.add(new JLabel("Card Number"));
        inputPanel.add(txtCustomerCardNumber);

        inputPanel.add(new JLabel("Card Expiry"));
        inputPanel.add(txtCustomerCardExpiry);




        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5)); // 2 rows, 1 column, with 5 pixels gap
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        buttonPanel.add(btnLoadCard);
        buttonPanel.add(btnUpdateCard);



        this.add(inputPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }
}
