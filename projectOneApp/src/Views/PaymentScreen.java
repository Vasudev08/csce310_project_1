package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PaymentScreen extends JFrame {
    private DefaultTableModel tblSelectedProductModel;

    private JTable tblSelectedProduct;

    private String enteredCardNumber;
    private String enteredExpiryDate;
    private JTextField txtOrderID = new JTextField(20);
    private JTextField txtOrderDate = new JTextField(20);

    private JTextField txtCustomerID = new JTextField(20);

    private JTextField txtOrderCost = new JTextField(20);

    private JTextField txtPaymentType = new JTextField(20);
    private JComboBox<String> cboPaymentType = new JComboBox<>(new String[]{"","Credit", "Debit", "Cash"});

    private JButton btnOrder = new JButton("Order");

    public JButton getbtnOder() {
        return btnOrder;
    }
    public JTextField getTxtPaymentType() {
        return txtPaymentType;
    }

    public void setTxtPaymentType(String value) {
        txtPaymentType.setText(value);
    }


    public JTextField getTxtOrderCost() {
        return txtOrderCost;
    }

    public void setTxtOrderCost(String value) {
        txtOrderCost.setText(value);
    }

    public JTextField getTxtCustomerID() {
        return txtCustomerID;
    }

    public void setTxtCustomerID(String value) {
        txtCustomerID.setText(value);
    }

    public JTextField getTxtOrderDate() {
        return txtOrderDate;
    }

    public void setTxtOrderDate(String value) {
        txtOrderDate.setText(value);
    }

    public JTextField getTxtOrderID() {
        return txtOrderID;
    }

    public void setTxtOrderID(String value) {
        txtOrderID.setText(value);
    }

    public PaymentScreen() {
        System.out.println("Payment Screen Constructor");

        this.setSize(850, 650);
        this.setTitle("Store Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        tblSelectedProductModel = new DefaultTableModel();
        tblSelectedProductModel.addColumn("Selected productID");
        tblSelectedProductModel.addColumn("Selected product Quantity");

        tblSelectedProduct = new JTable(tblSelectedProductModel);
        JScrollPane selectedProductScrollPane = new JScrollPane(tblSelectedProduct);

        JPanel tablePanel = new JPanel(new GridLayout(1, 2));
        tablePanel.add(selectedProductScrollPane);

        JPanel leftPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        leftPanel.add(new JLabel("Order ID:"));
        leftPanel.add(txtOrderID);
        txtOrderID.setEditable(false);

        leftPanel.add(new JLabel("Order Date:"));
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        txtOrderDate.setText(currentDate);
        txtOrderDate.setEditable(false); // To prevent user input
        leftPanel.add(txtOrderDate);

        leftPanel.add(new JLabel("Customer ID:"));
        leftPanel.add(txtCustomerID);

        leftPanel.add(new JLabel("Order Cost:"));
        leftPanel.add(txtOrderCost);
        txtOrderCost.setEditable(false);

        leftPanel.add(new JLabel("Payment Type:"));
        leftPanel.add(cboPaymentType);

        cboPaymentType.addActionListener(e -> {
            String selectedPayementType = (String) cboPaymentType.getSelectedItem();
            if (selectedPayementType != null & (selectedPayementType.equals("Credit") || selectedPayementType.equals("Debit"))) {
                enterCardDetailsPopup();
            }
        });

        leftPanel.add(btnOrder);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(tablePanel, BorderLayout.CENTER);
        contentPanel.add(leftPanel, BorderLayout.WEST);

        this.add(contentPanel);




    }

    public void displaySelectedProduct(String productID, int productQuantity) {
        System.out.println("Payment table");
//        tblSelectedProductModel.setRowCount(0);
        tblSelectedProductModel.addRow(new Object[]{productID, productQuantity});


    }

    public String getSelectedPaymentType() {
        return (String) cboPaymentType.getSelectedItem();
    }

    public void enterCardDetailsPopup() {
        JFrame cardDetailsFrame = new JFrame("Enter Card Details");
        cardDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cardDetailsFrame.setSize(300, 200);

        JPanel cardDetailsPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        cardDetailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField txtCardNumber = new JTextField(20);
        JTextField txtExpiryDate = new JTextField(20);
        JTextField txtCVV = new JTextField(20);



        cardDetailsPanel.add(new JLabel("Card Number:"));
        cardDetailsPanel.add(txtCardNumber);

        cardDetailsPanel.add(new JLabel("Expiry Date:"));
        cardDetailsPanel.add(txtExpiryDate);

        cardDetailsPanel.add(new JLabel("CVV:"));
        cardDetailsPanel.add(txtCVV);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(e -> {
            // Add logic to handle card details submission here
            // For now, let's just print the entered details
            enteredCardNumber = txtCardNumber.getText();
            enteredExpiryDate = txtExpiryDate.getText();


            cardDetailsFrame.dispose(); // Close the pop-up after submission
        });

        cardDetailsPanel.add(btnSubmit);

        cardDetailsFrame.add(cardDetailsPanel);
        cardDetailsFrame.setVisible(true);
    }

    public String getEnteredCardNumber() {
        return enteredCardNumber;
    }

    public String getEnteredExpiryDate() {
        return enteredExpiryDate;
    }

}
