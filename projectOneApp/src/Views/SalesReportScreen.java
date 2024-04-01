package Views;

import javax.swing.*;
import java.awt.*;

public class SalesReportScreen extends JFrame {
    private JButton btnSaleMonth = new JButton("Sales Per Month Report");
    private JButton btnSaleProduct = new JButton("Sales Per Product Report");
    private JButton btnSaleCustomer = new JButton("Sales Per Customer Report");

    private JTextField txtStartDate = new JTextField(10);
    private JTextField txtEndDate = new JTextField(10);

    private JSpinner spinnerStartDate;
    private JSpinner spinnerEndDate;

    private JCheckBox chkSortDescending = new JCheckBox("Sort Descending");


    public SalesReportScreen() {
        System.out.println("Sales Report Screen Constructor");

        this.setSize(850, 650);
        this.setTitle("Store Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create spinner models for start and end dates
        SpinnerDateModel startDateModel = new SpinnerDateModel();
        SpinnerDateModel endDateModel = new SpinnerDateModel();

        // Create spinners with spinner models
        spinnerStartDate = new JSpinner(startDateModel);
        spinnerEndDate = new JSpinner(endDateModel);

        // Customize spinners to display date format
        JSpinner.DateEditor startDateEditor = new JSpinner.DateEditor(spinnerStartDate, "yyyy-MM-dd");
        JSpinner.DateEditor endDateEditor = new JSpinner.DateEditor(spinnerEndDate, "yyyy-MM-dd");
        spinnerStartDate.setEditor(startDateEditor);
        spinnerEndDate.setEditor(endDateEditor);

        // Add spinners to input panel
        inputPanel.add(new JLabel("Start Date:"));
        inputPanel.add(spinnerStartDate);

        inputPanel.add(new JLabel("End Date:"));
        inputPanel.add(spinnerEndDate);

        inputPanel.add(new JLabel("Sort Order:"));
        inputPanel.add(chkSortDescending);

        inputPanel.add(btnSaleMonth);
        inputPanel.add(btnSaleProduct);
        inputPanel.add(btnSaleCustomer);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(inputPanel, BorderLayout.CENTER);

        this.add(contentPanel);
    }

    public JTextField getTxtStartDate() {
        return txtStartDate;
    }

    public JTextField getTxtEndDate() {
        return txtEndDate;
    }

    public JButton getBtnSaleMonth() {
        return btnSaleMonth;
    }

    public JButton getBtnSaleProduct() {
        return btnSaleProduct;
    }

    public JButton getBtnSaleCustomer() {
        return btnSaleCustomer;
    }

    public JSpinner getSpinnerStartDate() {
        return spinnerStartDate;
    }

    public JSpinner getSpinnerEndDate() {
        return spinnerEndDate;
    }

    public boolean isSortDescending() {
        return chkSortDescending.isSelected();
    }
}
