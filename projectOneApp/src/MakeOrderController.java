import Views.MakeOrderScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeOrderController implements ActionListener {
    private MakeOrderScreen makeOrderScreen;

    private DataAccess dataAccess;

    public MakeOrderController(MakeOrderScreen makeOrderScreen, DataAccess dataAccess) {
        this.makeOrderScreen = makeOrderScreen;
        this.dataAccess = dataAccess;
        this.makeOrderScreen.getBtnAddProduct().addActionListener(this);

        this.makeOrderScreen.updateTable(this.dataAccess.getAllProduct());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == makeOrderScreen.getBtnAddProduct()) {
            String productID = String.valueOf(makeOrderScreen.getTxtProductID().getText());
            int productQuantity = Integer.parseInt(makeOrderScreen.getTxtProductQuantity().getText());


            dataAccess.addSelectedProduct(productID, productQuantity);

            makeOrderScreen.displaySelectedProduct(productID, productQuantity);

        }


    }
}
