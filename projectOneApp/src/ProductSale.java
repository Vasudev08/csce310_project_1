
public class ProductSale {
    private int productID;
    private String productName;
    private int totalQuantity;
    private double totalSale;

    public ProductSale(int productID, String productName, int totalQuantity, double totalSale) {
        this.productID = productID;
        this.productName = productName;
        this.totalQuantity = totalQuantity;
        this.totalSale = totalSale;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public double getTotalSale() {
        return totalSale;
    }
}
