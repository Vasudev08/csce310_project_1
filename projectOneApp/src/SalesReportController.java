import Views.SalesReportScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SalesReportController implements ActionListener {
    private SalesReportScreen salesReportScreen;

    private DataAccess dataAccess;

    public SalesReportController(SalesReportScreen salesReportScreen, DataAccess dataAccess) {
        this.salesReportScreen = salesReportScreen;
        this.dataAccess = dataAccess;

        salesReportScreen.getBtnSaleMonth().addActionListener(this);
        salesReportScreen.getBtnSaleProduct().addActionListener(this);
        salesReportScreen.getBtnSaleCustomer().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salesReportScreen.getBtnSaleMonth()) {
            System.out.println("Sales Report by Month");
            boolean sortDescending = salesReportScreen.isSortDescending();

            JSpinner spinner = salesReportScreen.getSpinnerStartDate();
            SpinnerDateModel model = (SpinnerDateModel) spinner.getModel();
            Date startDate = model.getDate();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedStartDate = dateFormat.format(startDate);

            JSpinner spinner1 = salesReportScreen.getSpinnerEndDate();
            SpinnerDateModel model1 = (SpinnerDateModel) spinner1.getModel();
            Date endDate = model1.getDate();

            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedEndDate = dateFormat1.format(endDate);


//            String endDate = String.valueOf(salesReportScreen.getSpinnerEndDate());

            dataAccess.writeMonthlySalesToFile(formattedStartDate, formattedEndDate, sortDescending, "monthly_sales.txt");



        } else if (e.getSource() == salesReportScreen.getBtnSaleProduct()) {
            System.out.println("Sales Report by Month");
            boolean sortDescending = salesReportScreen.isSortDescending();

            JSpinner spinner = salesReportScreen.getSpinnerStartDate();
            SpinnerDateModel model = (SpinnerDateModel) spinner.getModel();
            Date startDate = model.getDate();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedStartDate = dateFormat.format(startDate);

            JSpinner spinner1 = salesReportScreen.getSpinnerEndDate();
            SpinnerDateModel model1 = (SpinnerDateModel) spinner1.getModel();
            Date endDate = model1.getDate();

            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedEndDate = dateFormat1.format(endDate);
            List<ProductSale> productSales = dataAccess.getTotalSalePerProduct(formattedStartDate, formattedEndDate, sortDescending);
            dataAccess.writeProductSalesToFile(productSales, "product_sales.txt");


        } else if (e.getSource() == salesReportScreen.getBtnSaleCustomer()) {
            System.out.println("Sales Report by Month");
            boolean sortDescending = salesReportScreen.isSortDescending();

            JSpinner spinner = salesReportScreen.getSpinnerStartDate();
            SpinnerDateModel model = (SpinnerDateModel) spinner.getModel();
            Date startDate = model.getDate();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedStartDate = dateFormat.format(startDate);

            JSpinner spinner1 = salesReportScreen.getSpinnerEndDate();
            SpinnerDateModel model1 = (SpinnerDateModel) spinner1.getModel();
            Date endDate = model1.getDate();

            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedEndDate = dateFormat1.format(endDate);

            List<CustomerSale> customerSales = dataAccess.getTotalSalePerCustomer(formattedStartDate, formattedEndDate, sortDescending);
            dataAccess.writeCustomerSalesToFile(customerSales, "customer_sales.txt");


        }

    }
}
