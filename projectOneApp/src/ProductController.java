import Models.Product;
import Views.ProductScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController implements ActionListener {

    private ProductScreen productScreen;

    private DataAccess dataAccess;

    public ProductController(ProductScreen productScreen, DataAccess dataAccess) {
        this.productScreen = productScreen;
        this.dataAccess = dataAccess;

        this.productScreen.getBtnAddProduct().addActionListener(this);
        this.productScreen.getBtnLoadProduct().addActionListener(this);
        this.productScreen.getBtnUpdateProudct().addActionListener(this);
        this.productScreen.getBtnDeleteProduct().addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == productScreen.getBtnAddProduct()) {
            System.out.println("Product Add Button Pressed");
            Product product = new Product();

            String pname = productScreen.getTxtProductName().getText();
            int pid = Integer.parseInt(productScreen.getTxtProductID().getText());
            int pqu = Integer.parseInt(productScreen.getTxtProductQuantity().getText());
            double pcost = Double.parseDouble(productScreen.getTxtProductCost().getText());

            product.setProductID(pid);
            product.setProductName(pname);
            product.setProductQuantity(pqu);
            product.setProductCost(pcost);

            dataAccess.addProduct(product);

        } else if (e.getSource() == productScreen.getBtnUpdateProudct()) {
            System.out.println("Product Update Button Pressed");
            Product product = new Product();


            String pname = productScreen.getTxtProductName().getText();
            int pid = Integer.parseInt(productScreen.getTxtProductID().getText());
            int pqu = Integer.parseInt(productScreen.getTxtProductQuantity().getText());
            double pcost = Double.parseDouble(productScreen.getTxtProductCost().getText());

            product.setProductID(pid);
            product.setProductName(pname);
            product.setProductQuantity(pqu);
            product.setProductCost(pcost);

            dataAccess.updateProduct(product);
        } else if (e.getSource() == productScreen.getBtnLoadProduct()) {
            System.out.println("Product Load Button Pressed");
            int pid = Integer.parseInt(productScreen.getTxtProductID().getText());
            Product product = dataAccess.loadProduct(pid);

            productScreen.setTxtProductName(product.getProductName());
            int qua = product.getProductQuantity();
            productScreen.setTxtProductQuantity(String.valueOf(qua));
            productScreen.setTxtProductCost(String.valueOf(product.getProductCost()));

        } else if (e.getSource() == productScreen.getBtnDeleteProduct()) {
            System.out.println("Product Delete Button Pressed");
            int pid = Integer.parseInt(productScreen.getTxtProductID().getText());
            dataAccess.deleteProduct(pid);
            System.out.println("Product Delete Successful");

        }

    }
}
