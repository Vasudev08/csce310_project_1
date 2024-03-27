package Models;

public class Product {

    private int productID;

    private String productName;

    private int productQuantity;

    private double productCost;


    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public double getProductCost() {
        return productCost;
    }




}
