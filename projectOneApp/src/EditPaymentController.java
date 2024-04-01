import Models.Payment;
import Views.EditPaymentScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPaymentController implements ActionListener {
    private EditPaymentScreen editPaymentScreen;
    private DataAccess dataAccess;

    public EditPaymentController(EditPaymentScreen editPaymentScreen, DataAccess dataAccess) {
        this.editPaymentScreen = editPaymentScreen;
        this.dataAccess = dataAccess;

        editPaymentScreen.getBtnLoadCard().addActionListener(this);
        editPaymentScreen.getBtnUpdateCard().addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editPaymentScreen.getBtnLoadCard()) {
            Payment payment;
            payment = dataAccess.loadPayment(Integer.parseInt(editPaymentScreen.getTxtCustomerID().getText()));

            editPaymentScreen.setTxtCustomerCardNumber(payment.getCustomerCardNumber());
            editPaymentScreen.setTxtCustomerCardExpiry(payment.getCustomerCardExpiry());


        } else if (e.getSource() == editPaymentScreen.getBtnUpdateCard()) {
            Payment payment = new Payment();
            payment.setCustomerID(Integer.parseInt(editPaymentScreen.getTxtCustomerID().getText()));
            payment.setCustomerCardNumber(editPaymentScreen.getTxtCustomerCardNumber().getText());
            String eps = editPaymentScreen.getTxtCustomerCardExpiry().getText();
            payment.setCustomerCardExpiry(eps);

            dataAccess.updatePayment(payment);


        }

    }
}
