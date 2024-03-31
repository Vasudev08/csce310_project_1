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

    private DefaultTableModel tblProductModel;
    private JTable tblProduct;

    public JTextField getTxtProductID() {return txtProductID;}

    public JTextField getTxtProductQuantity() {return txtProductQuantity;}

    public void setTxtProductID(String value) {txtProductID.setText(value);}

    public void setTxtProductQuantity(String value) {txtProductQuantity.setText(value);}

    public MakeOrderScreen() {
        System.out.println("MakeOrder Screen Construstor");

        this.setSize(850, 650);
        this.setTitle("Store Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        tblProductModel = new DefaultTableModel();
        tblProductModel.addColumn("productID");
        tblProductModel.addColumn("productName");
        tblProductModel.addColumn("currentQuantity");
        tblProductModel.addColumn("productCost");

        tblProduct = new JTable(tblProductModel);
        JScrollPane scrollPane = new JScrollPane(tblProduct);
        add(scrollPane, BorderLayout.NORTH);



        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5,5 ));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Enter Product ID:"));
        inputPanel.add(txtProductID);

        inputPanel.add(new JLabel("Enter Product Quantity:"));
        inputPanel.add(txtProductQuantity);



//        inputPanel.add(new JLabel("Supplier ID:"));
//        inputPanel.add(txtSupplierID);
//
//        inputPanel.add(new JLabel("Supplier Name"));
//        inputPanel.add(txtSupplierName);
//
//        inputPanel.add(new JLabel("Supplier Address"));
//        inputPanel.add(txtSupplierAddress);
//
//        inputPanel.add(new JLabel("Supplier Phone"));
//        inputPanel.add(txtSupplierPhone);



        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5)); // 2 rows, 1 column, with 5 pixels gap
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

//        buttonPanel.add(btnAddSupplier);
//        buttonPanel.add(btnUpdateSupplier);
//        buttonPanel.add(btnLoadSupplier);
//        buttonPanel.add(btnDeleteSupplier);



        this.add(inputPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);


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
}
