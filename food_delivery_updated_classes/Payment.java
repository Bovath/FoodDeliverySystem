
public class Payment implements Displayable, Payable{
    private int paymentID;
    private Order order;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    public Payment(int paymentID, Order order, String paymentMethod) {
        setPaymentID(paymentID);
        setOrder(order);
        this.amount = order.calculateTotal();
        setPaymentMethod(paymentMethod);
        this.paymentStatus = "Pending";
    }

    public int getPaymentID() { return paymentID; }
    public int getPaymentId() { return paymentID; }
    public Order getOrder() { return order; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }

    public void setPaymentID(int paymentID) {
        if (paymentID <= 0) {
            System.out.println("Invalid payment ID!");
            return;
        }
        this.paymentID = paymentID;
    }

    public void setOrder(Order order) {
        if (order == null) {
            System.out.println("Invalid order!");
            return;
        }
        this.order = order;
    }

    public void setPaymentMethod(String paymentMethod) {
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            System.out.println("Invalid payment method!");
            return;
        }
        this.paymentMethod = paymentMethod;
    }

    @Override
    public void pay() {
        if (!order.hasOrderDetails()) {
            System.out.println("Payment failed! Order has no items.");
            return;
        }
    
        this.amount = order.calculateTotal();
        this.paymentStatus = "Paid";
        order.setStatus("Paid");
    
        System.out.println("Payment successful. Order status updated to Paid.");
    }
    public void markAsPaid() {
        this.paymentStatus = "Paid";
        order.setStatus("Paid");
    }

    public void displayPayment() {
        System.out.println("Payment ID: " + paymentID);
        System.out.println("Order ID: " + order.getOrderID());
        System.out.println("Amount: $" + amount);
        System.out.println("Method: " + paymentMethod);
        System.out.println("Status: " + paymentStatus);
    }
    @Override
        public void display() {
    displayPayment();
    }


}
