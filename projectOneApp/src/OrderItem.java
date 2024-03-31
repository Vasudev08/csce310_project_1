public class OrderItem {
    private String productID;
    private int productQuantity;

    public OrderItem(String productID, int productQuantity) {
        this.productID = productID;
        this.productQuantity = productQuantity;
    }

    public String getProductID() {
        return productID;
    }

    public int getProductQuantity() {
        return productQuantity;
    }
}
