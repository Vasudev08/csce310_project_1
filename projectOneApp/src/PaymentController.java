import Views.PaymentScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PaymentController implements ActionListener {
    private PaymentScreen paymentScreen;
    private DataAccess dataAccess;

    public PaymentController(PaymentScreen paymentScreen, DataAccess dataAccess) {
        this.paymentScreen = paymentScreen;
        this.dataAccess = dataAccess;
        this.paymentScreen.getbtnOder().addActionListener(this);

        List<OrderItem> orderItems = this.dataAccess.getOrderItems();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == paymentScreen.getbtnOder()) {
            System.out.println("Order Button Pressed");
            int oid = Integer.parseInt(paymentScreen.getTxtOrderID().getText());
            int cid = Integer.parseInt(paymentScreen.getTxtCustomerID().getText());
            String payment = paymentScreen.getSelectedPaymentType();
            dataAccess.addOrder(oid, cid, payment);
            dataAccess.addPayment(cid, paymentScreen.getEnteredCardNumber(), paymentScreen.getEnteredExpiryDate());



            paymentScreen.setVisible(false);
            Application.getInstance().getMainScreen().setVisible(true);
            // update the backend for productPayment and productOrder

        }

    }
}
