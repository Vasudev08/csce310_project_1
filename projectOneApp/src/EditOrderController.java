import Models.Orders;
import Views.EditOrderScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EditOrderController implements ActionListener {

    private EditOrderScreen editOrderScreen;
    private DataAccess dataAccess;

    public EditOrderController(EditOrderScreen editOrderScreen, DataAccess dataAccess) {
        this.editOrderScreen = editOrderScreen;
        this.dataAccess = dataAccess;

        editOrderScreen.getBtnLoadOrder().addActionListener(this);
        editOrderScreen.getBtnUpdateOrder().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editOrderScreen.getBtnLoadOrder()) {
            Orders orders = dataAccess.loadOrder(Integer.parseInt(editOrderScreen.getTxtOrderID().getText()));
            editOrderScreen.setTxtOrderDate(orders.getOrderDate());
            editOrderScreen.setTxtCustomerID(orders.getCustomerID());
//            editOrderScreen.setTxtPaymentType(orders.getPaymentType());

        } else if (e.getSource() == editOrderScreen.getBtnUpdateOrder()) {
            Orders orders = new Orders();
            int oid = Integer.parseInt(editOrderScreen.getTxtOrderID().getText());
            System.out.println("Controller");
            System.out.println(oid);
            System.out.println(editOrderScreen.getTxtCustomerID().getText());
            System.out.println(editOrderScreen.getTxtOrderDate().getText());

            orders.setOrderID(Integer.parseInt(editOrderScreen.getTxtOrderID().getText()));
            orders.setOrderDate(String.valueOf(editOrderScreen.getTxtOrderDate().getText()));
            orders.setCustomerID(String.valueOf(editOrderScreen.getTxtCustomerID().getText()));

            dataAccess.updateOrder(orders);


        }


    }
}
