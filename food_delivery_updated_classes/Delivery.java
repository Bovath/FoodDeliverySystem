

public class Delivery implements Displayable, Deliverable{
    private int deliveryID;
    private Order order;
    private DeliveryDriver deliveryDriver;
    private String deliveryStatus;

    public Delivery(int deliveryID,
        Order order,
        DeliveryDriver deliveryDriver){
        setDeliveryID(deliveryID);
        setOrder(order);
        setDeliveryDriver(deliveryDriver);
        this.deliveryStatus = "Preparing";
    }

    public int getDeliveryID() { return deliveryID; }
    public int getDeliveryId() { return deliveryID; }
    public Order getOrder() { return order; }
    public DeliveryDriver getDeliveryDriver() {
        return deliveryDriver;
    }
    
    public void setDeliveryDriver(DeliveryDriver deliveryDriver) {
    
        if(deliveryDriver == null){
            System.out.println("Invalid driver!");
            return;
        }
    
        this.deliveryDriver = deliveryDriver;
    }
    public String getDeliveryStatus() { return deliveryStatus; }

    public void setDeliveryID(int deliveryID) {
        if (deliveryID <= 0) {
            System.out.println("Invalid delivery ID!");
            return;
        }
        this.deliveryID = deliveryID;
    }

    public void setOrder(Order order) {
        if (order == null) {
            System.out.println("Invalid order!");
            return;
        }
        this.order = order;
    }


    public void updateStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            System.out.println("Invalid delivery status!");
            return;
        }
    
        if (!order.hasOrderDetails()) {
            System.out.println("Delivery failed! Order has no items.");
            return;
        }
    
        if (!order.getStatus().equalsIgnoreCase("Paid") &&
            !order.getStatus().equalsIgnoreCase("Confirmed")) {
            System.out.println("Delivery failed! Order must be paid first.");
            return;
        }
    
        this.deliveryStatus = status;
    
    }
    public void displayDelivery() {
        System.out.println("Delivery ID: " + deliveryID);
        System.out.println("Order ID: " + order.getOrderID());
        System.out.println("Delivery Person: " + deliveryDriver.getName());
        System.out.println("Delivery Status: " + deliveryStatus);
    }
    @Override
    public void display() {
        displayDelivery();
        deliveryDriver.display();

    }

    

}
