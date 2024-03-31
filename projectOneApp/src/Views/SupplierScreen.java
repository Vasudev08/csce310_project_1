package Views;

import javax.swing.*;
import java.awt.*;

public class SupplierScreen extends JFrame {
    private JTextField txtSupplierID = new JTextField(10);
    private JTextField txtSupplierName = new JTextField(10);
    private JTextField txtSupplierAddress = new JTextField(10);
    private JTextField txtSupplierPhone = new JTextField(10);

    private JButton btnAddSupplier = new JButton("Add Supplier");
    private JButton btnUpdateSupplier = new JButton("Update Supplier");

    private JButton btnLoadSupplier = new JButton("Load Supplier");

    private JButton btnDeleteSupplier = new JButton("Delete Supplier");


    public JTextField getTxtSupplierName() {
        return txtSupplierName;
    }

    public JTextField getTxtSupplierAddress() {
        return txtSupplierAddress;
    }

    public JTextField getTxtSupplierPhone() {
        return txtSupplierPhone;
    }

    public JTextField getTxtSupplierID() {
        return  txtSupplierID;
    }

    public void setTxtSupplierID(String value) {
        txtSupplierID.setText(value);
    }

    public void setTxtSupplierName(String value) {
        txtSupplierName.setText(value);
    }

    public void setTxtSupplierAddress(String value) {
        txtSupplierAddress.setText(value);
    }

    public void setTxtSupplierPhone(String value) {
        txtSupplierPhone.setText(value);
    }

    public JButton getBtnAddSupplier() {
        return btnAddSupplier;
    }

    public JButton getBtnUpdateSupplier() {
        return btnUpdateSupplier;
    }

    public JButton getBtnLoadSupplier() {
        return btnLoadSupplier;
    }

    public JButton getBtnDeleteSupplier() {
        return btnDeleteSupplier;
    }



    public SupplierScreen() {
        System.out.println("Supplier Screen Constructor");

        this.setSize(500, 200);
        this.setTitle("Store Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5,5 ));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        inputPanel.add(new JLabel("Supplier ID:"));
        inputPanel.add(txtSupplierID);

        inputPanel.add(new JLabel("Supplier Name"));
        inputPanel.add(txtSupplierName);

        inputPanel.add(new JLabel("Supplier Address"));
        inputPanel.add(txtSupplierAddress);

        inputPanel.add(new JLabel("Supplier Phone"));
        inputPanel.add(txtSupplierPhone);



        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5)); // 2 rows, 1 column, with 5 pixels gap
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        buttonPanel.add(btnAddSupplier);
        buttonPanel.add(btnUpdateSupplier);
        buttonPanel.add(btnLoadSupplier);
        buttonPanel.add(btnDeleteSupplier);



        this.add(inputPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

}
