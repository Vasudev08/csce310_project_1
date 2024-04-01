package Models;

public class Payment {
    private int customerID;
    private String customerCardNumber;

    private String customerCardExpiry;

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerCardNumber() {
        return customerCardNumber;
    }

    public String getCustomerCardExpiry() {
        return customerCardExpiry;
    }

    public void setCustomerCardExpiry(String customerCardExpiry) {
        this.customerCardExpiry = customerCardExpiry;
    }

    public void setCustomerCardNumber(String customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
