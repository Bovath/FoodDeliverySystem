

import java.util.ArrayList;

public class Order implements Displayable, Calculable{
    private int orderID;
    private Customer customer;
    private Restaurant restaurant;
    private ArrayList<OrderDetail> orderDetails;
    private String orderDate;
    private String status;
    private static int orderCount = 0;

    public Order(Customer customer, Restaurant restaurant, String orderDate, String status) {
        orderCount++;
        this.orderID = orderCount;
        this.orderDetails = new ArrayList<>();
        setCustomer(customer);
        setRestaurant(restaurant);
        setOrderDate(orderDate);
        setStatus(status);
    }

    public int getOrderID() { return orderID; }
    public int getOrderId() { return orderID; }
    public Customer getCustomer() { return customer; }
    public Restaurant getRestaurant() { return restaurant; }
    public ArrayList<OrderDetail> getOrderDetails() { return orderDetails; }
    public String getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
    public static int getOrderCount() { return orderCount; }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            System.out.println("Invalid customer!");
            return;
        }
        this.customer = customer;
    }

    public void setRestaurant(Restaurant restaurant) {
        if (restaurant == null) {
            System.out.println("Invalid restaurant!");
            return;
        }
        this.restaurant = restaurant;
    }

    public void setOrderDate(String orderDate) {
        if (orderDate == null || orderDate.trim().isEmpty()) {
            System.out.println("Invalid order date!");
            return;
        }
        this.orderDate = orderDate;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            System.out.println("Invalid order status!");
            return;
        }
        this.status = status;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        if (orderDetail == null) {
            System.out.println("Invalid order detail!");
            return;
        }
        if (orderDetail.getMenuItem().getRestaurant() != restaurant) {
            System.out.println("Invalid item! This food does not belong to the order restaurant.");
            return;
        }
        orderDetails.add(orderDetail);
    }

    public boolean hasOrderDetails() {
        return !orderDetails.isEmpty();
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderDetail detail : orderDetails) {
            total += detail.calculateSubtotal();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Date: " + orderDate);
        System.out.println("Status: " + status);
        System.out.println("Total: $" + calculateTotal());
    }

    @Override
    public void display() {
        displayOrder();

    }
    @Override
    public double calculate() {

    double total = 0;

    for (OrderDetail detail : orderDetails) {
        total += detail.calculate();
    }

    return total;
    }
}
