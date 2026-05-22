public class Customer extends Person implements Displayable {
    private int customerID;
    private static int customerCount = 0;

    public Customer(String name, String phone, String address) {
        super(name, phone, address);
        customerCount++;
        this.customerID = customerCount;
    }

    public int getCustomerID() { return customerID; }
    public static int getCustomerCount() { return customerCount; }

    public void displayCustomer() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Customer Name: " + getName());
        System.out.println("Customer Phone: " + getPhone());
        System.out.println("Customer Address: " + getAddress());
    }

    @Override
public void display() {
    displayCustomer();
}

    @Override
    public double calculate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculate'");
    }
}
