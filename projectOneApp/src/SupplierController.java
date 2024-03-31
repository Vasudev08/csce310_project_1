import Models.Supplier;
import Views.SupplierScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupplierController implements ActionListener {
    private SupplierScreen supplierScreen;

    private DataAccess dataAccess;

    public SupplierController(SupplierScreen supplierScreen, DataAccess dataAccess) {
        this.supplierScreen = supplierScreen;
        this.dataAccess = dataAccess;

        this.supplierScreen.getBtnAddSupplier().addActionListener(this);
        this.supplierScreen.getBtnLoadSupplier().addActionListener(this);
        this.supplierScreen.getBtnUpdateSupplier().addActionListener(this);
        this.supplierScreen.getBtnDeleteSupplier().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == supplierScreen.getBtnAddSupplier()) {
            System.out.println("Supplier Add Button Pressed");
            Supplier supplier = new Supplier();

            String cname = supplierScreen.getTxtSupplierName().getText();
            int cid = Integer.parseInt(supplierScreen.getTxtSupplierID().getText());
            String caddress = supplierScreen.getTxtSupplierAddress().getText();
            String cphone = supplierScreen.getTxtSupplierPhone().getText();

            supplier.setSupplierID(cid);
            supplier.setSupplierName(cname);
            supplier.setSupplierAddress(caddress);
            supplier.setSupplierPhone(cphone);

            dataAccess.addSupplier(supplier);
        } else if (e.getSource() == supplierScreen.getBtnUpdateSupplier()) {
            System.out.println("Supplier Update Button Pressed");
            Supplier supplier = new Supplier();

            String cname = supplierScreen.getTxtSupplierName().getText();
            int cid = Integer.parseInt(supplierScreen.getTxtSupplierID().getText());
            String caddress = supplierScreen.getTxtSupplierAddress().getText();
            String cphone = supplierScreen.getTxtSupplierPhone().getText();

            supplier.setSupplierID(cid);
            supplier.setSupplierName(cname);
            supplier.setSupplierAddress(caddress);
            supplier.setSupplierPhone(cphone);

            dataAccess.updateSupplier(supplier);

        } else if (e.getSource() == supplierScreen.getBtnLoadSupplier()) {
            System.out.println("Supplier Load Button Pressed");
            int cid = Integer.parseInt(supplierScreen.getTxtSupplierID().getText());
            Supplier supplier = dataAccess.loadSupplier(cid);

            supplierScreen.setTxtSupplierName(supplier.getSupplierName());
            supplierScreen.setTxtSupplierAddress(supplier.getSupplierAddress());
            supplierScreen.setTxtSupplierPhone(supplier.getSupplierPhone());


        } else if (e.getSource() == supplierScreen.getBtnDeleteSupplier()) {
            System.out.println("Supplier Delete Button Pressed");
            int cid = Integer.parseInt(supplierScreen.getTxtSupplierID().getText());
            dataAccess.deleteSupplier(cid);
            System.out.println("Supplier Delete Successful");



        }

    }
}
