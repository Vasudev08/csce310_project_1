import Views.MakeOrderScreen;
import Views.PaymentScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MakeOrderController implements ActionListener {
    private MakeOrderScreen makeOrderScreen;
    private PaymentScreen paymentScreen;

    private DataAccess dataAccess;

    public MakeOrderController(MakeOrderScreen makeOrderScreen, PaymentScreen paymentScreen, DataAccess dataAccess) {
        this.makeOrderScreen = makeOrderScreen;
        this.dataAccess = dataAccess;
        this.paymentScreen = paymentScreen;

        this.makeOrderScreen.getBtnAddProduct().addActionListener(this);
        this.makeOrderScreen.getBtnPayment().addActionListener(this);

        this.makeOrderScreen.updateTable(this.dataAccess.getAllProduct());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == makeOrderScreen.getBtnAddProduct()) {
            String productID = String.valueOf(makeOrderScreen.getTxtProductID().getText());
            int productQuantity = Integer.parseInt(makeOrderScreen.getTxtProductQuantity().getText());


            dataAccess.addSelectedProduct(productID, productQuantity);

            makeOrderScreen.displaySelectedProduct(productID, productQuantity);

        } else if (e.getSource() == makeOrderScreen.getBtnPayment()) {
            System.out.println("Payment Button Pressed");
            makeOrderScreen.setVisible(false);

            paymentScreen.setVisible(true);

            updatePaymentScreenTable();
            int order = dataAccess.getLastOrderID() + 1;
            paymentScreen.setTxtOrderID(String.valueOf(order));

            double cost = dataAccess.getOrderCost();
            paymentScreen.setTxtOrderCost(String.valueOf(cost));


        }


    }

    private void updatePaymentScreenTable() {
        // Get OrderItems from DataAccess
        List<OrderItem> orderItems = dataAccess.getOrderItems();

        // Clear existing table in PaymentScreen
//        paymentScreen.clearTable();

        // Add OrderItems to PaymentScreen table
        for (OrderItem orderItem : orderItems) {
            paymentScreen.displaySelectedProduct(orderItem.getProductID(), orderItem.getProductQuantity());
        }
    }
}
