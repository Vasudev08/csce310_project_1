package Views;

import javax.swing.*;
import java.awt.*;

public class EditOrderScreen extends JFrame {

    private JTextField txtOrderID = new JTextField(10);

    private JTextField txtOrderDate = new JTextField(10);
    private JTextField txtCustomerID = new JTextField(10);
    private JTextField txtPaymentType = new JTextField(10);

    private JButton btnUpdateOrder = new JButton("Update Order");
    private JButton btnLoadOrder = new JButton("Load Order");



    public JButton getBtnUpdateOrder() {return btnUpdateOrder;}

    public JButton getBtnLoadOrder() {return btnLoadOrder;}
    public JTextField getTxtOrderID() {
        return txtOrderID;
    }

    public JTextField getTxtOrderDate() {
        return txtOrderDate;
    }

    public JTextField getTxtCustomerID() {
        return txtCustomerID;
    }

    public JTextField getTxtPaymentType() {
        return txtPaymentType;
    }

    public void setTxtOrderDate(String value) {
        txtOrderDate.setText(value);
    }

    public void setTxtOrderID(String value) {
        txtOrderID.setText(value);
    }

    public void setTxtCustomerID(String value) {
        txtCustomerID.setText(value);
    }

    public void setTxtPaymentType(String value) {
        txtPaymentType.setText(value);
    }

    public EditOrderScreen() {
        this.setSize(500, 200);
        this.setTitle("Store Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5,5 ));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        inputPanel.add(new JLabel("Order ID:"));
        inputPanel.add(txtOrderID);

        inputPanel.add(new JLabel("Order Date"));
        inputPanel.add(txtOrderDate);

        inputPanel.add(new JLabel("CustomerID"));
        inputPanel.add(txtCustomerID);

//        inputPanel.add(new JLabel("Payment Type"));
//        inputPanel.add(txtPaymentType);



        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5)); // 2 rows, 1 column, with 5 pixels gap
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        buttonPanel.add(btnUpdateOrder);
        buttonPanel.add(btnLoadOrder);



        this.add(inputPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }


}
