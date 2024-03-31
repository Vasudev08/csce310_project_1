package Views;

import javax.swing.*;
import java.awt.*;

public class ProductScreen extends JFrame {
    private JTextField txtProductID = new JTextField(10);
    private JTextField txtProductName = new JTextField(10);
    private JTextField txtProductQuantity = new JTextField(10);
    private JTextField txtProductCost =new JTextField(10);

    private JButton btnAddProduct = new JButton("Add Product");
    private JButton btnUpdateProudct = new JButton("Update Product");
    private JButton btnLoadProduct = new JButton("Load Product");

    private JButton btnDeleteProduct = new JButton("Delete Product");

    public JTextField getTxtProductID() {return txtProductID;}
    public JTextField getTxtProductName() {return txtProductName;}
    public JTextField getTxtProductQuantity() {return txtProductQuantity;}
    public JTextField getTxtProductCost() {return txtProductCost;}

    public JButton getBtnAddProduct() {return btnAddProduct;}
    public JButton getBtnUpdateProudct() {return btnUpdateProudct;}
    public JButton getBtnLoadProduct() {return btnLoadProduct;}

    public JButton getBtnDeleteProduct() {return btnDeleteProduct;}

    public void  setTxtProductID(String value) {
        txtProductID.setText(value);
    }

    public void  setTxtProductName(String value) {
        txtProductName.setText(value);
    }

    public void  setTxtProductQuantity(String value) {
        txtProductQuantity.setText(value);
    }

    public void  setTxtProductCost(String value) {
        txtProductCost.setText(value);
    }

    public ProductScreen() {
        System.out.println("Product Screen Constructor");

        this.setSize(500, 200);
        this.setTitle("Store Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5,5 ));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        inputPanel.add(new JLabel("Product ID:"));
        inputPanel.add(txtProductID);

        inputPanel.add(new JLabel("Product Name"));
        inputPanel.add(txtProductName);

        inputPanel.add(new JLabel("Product Quantity"));
        inputPanel.add(txtProductQuantity);

        inputPanel.add(new JLabel("Product Cost"));
        inputPanel.add(txtProductCost);



        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5)); // 2 rows, 1 column, with 5 pixels gap
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        buttonPanel.add(btnAddProduct);
        buttonPanel.add(btnUpdateProudct);
        buttonPanel.add(btnLoadProduct);
        buttonPanel.add(btnDeleteProduct);



        this.add(inputPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }
}
