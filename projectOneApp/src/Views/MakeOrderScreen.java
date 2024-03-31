package Views;

import Models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Objects;


public class MakeOrderScreen extends JFrame {
    private JTextField txtProductID = new JTextField(10);

    private JTextField txtProductQuantity = new JTextField(10);

    private JButton btnAddProduct = new JButton("Add Product");

    private DefaultTableModel tblProductModel;
    private JTable tblProduct;

    private DefaultTableModel tblSelectedProductModel;

    private JTable tblSelectedProduct;

    public JButton getBtnAddProduct() {return btnAddProduct;}
    public JTextField getTxtProductID() {return txtProductID;}

    public JTextField getTxtProductQuantity() {return txtProductQuantity;}

    public void setTxtProductID(String value) {txtProductID.setText(value);}

    public void setTxtProductQuantity(String value) {txtProductQuantity.setText(value);}



    public MakeOrderScreen() {System.out.println("MakeOrder Screen Constructor");

        this.setSize(850, 650);
        this.setTitle("Store Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        // Product table setup
        tblProductModel = new DefaultTableModel();
        tblProductModel.addColumn("productID");
        tblProductModel.addColumn("productName");
        tblProductModel.addColumn("currentQuantity");
        tblProductModel.addColumn("productCost");

        tblProduct = new JTable(tblProductModel);
        JScrollPane scrollPane = new JScrollPane(tblProduct);

        // Selected Product table setup
        tblSelectedProductModel = new DefaultTableModel();
        tblSelectedProductModel.addColumn("Selected productID");
        tblSelectedProductModel.addColumn("Selected prodcut Quantity");

        tblSelectedProduct = new JTable(tblSelectedProductModel);
        JScrollPane selectedProductScrollPane = new JScrollPane(tblSelectedProduct);

        JPanel tablePanel = new JPanel(new GridLayout(1, 2));
        tablePanel.add(scrollPane);
        tablePanel.add(selectedProductScrollPane);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Enter Product ID:"));
        inputPanel.add(txtProductID);

        inputPanel.add(new JLabel("Enter Product Quantity:"));
        inputPanel.add(txtProductQuantity);

        inputPanel.add(btnAddProduct);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(tablePanel, BorderLayout.CENTER);
        contentPanel.add(inputPanel, BorderLayout.SOUTH);

        this.add(contentPanel);
    }

    public void updateTable(List<Product> productList) {
        tblProductModel.setRowCount(0);

        for (Product product: productList) {
            Object[] rowData = {
                    product.getProductID(),
                    product.getProductName(),
                    product.getProductQuantity(),
                    product.getProductCost()
            };
            tblProductModel.addRow(rowData);
        }

    }

    public void displaySelectedProduct(String productID, int productQuantity) {
//        tblSelectedProductModel.setRowCount(0);
        tblSelectedProductModel.addRow(new Object[]{productID, productQuantity});

        setTxtProductID("");
        setTxtProductQuantity("");

    }


}
