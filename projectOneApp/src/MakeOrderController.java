import Views.MakeOrderScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeOrderController implements ActionListener {
    private MakeOrderScreen makeOrderScreen;

    private DataAccess dataAccess;

    public MakeOrderController(MakeOrderScreen makeOrderScreen, DataAccess dataAccess) {
        this.makeOrderScreen = makeOrderScreen;
        this.dataAccess = dataAccess;

        this.makeOrderScreen.updateTable(this.dataAccess.getAllProduct());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
