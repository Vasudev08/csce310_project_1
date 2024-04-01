public class CustomerSale {
    private int customerID;
    private String customerName;
    private double totalSale;

    public CustomerSale(int customerID, String customerName, double totalSale) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.totalSale = totalSale;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalSale() {
        return totalSale;
    }
}
