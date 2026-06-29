package model;
import interfaces.*;

public class OrderDetail implements Displayable, Calculable {
    private int orderDetailID;
    private MenuItem menuItem;
    private int quantity;

    public OrderDetail(int orderDetailID, MenuItem menuItem, int quantity) {
        setOrderDetailID(orderDetailID);
        setMenuItem(menuItem);
        setQuantity(quantity);
    }

    public int getOrderDetailID() { return orderDetailID; }
    public MenuItem getMenuItem() { return menuItem; }
    public int getQuantity() { return quantity; }

    public void setOrderDetailID(int orderDetailID) {
        if (orderDetailID <= 0) {
            System.out.println("Invalid order detail ID!");
            return;
        }
        this.orderDetailID = orderDetailID;
    }

    public void setMenuItem(MenuItem menuItem) {
        if (menuItem == null) {
            System.out.println("Invalid menu item!");
            return;
        }
        this.menuItem = menuItem;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
            return;
        }
        this.quantity = quantity;
    }

    public double calculateSubtotal() {
        return calculate();
    }

    public void displayOrderDetail() {
        System.out.println("Food: " + menuItem.getFoodName());
        System.out.println("Price: $" + menuItem.getPrice());
        System.out.println("Quantity: " + quantity);
        System.out.println("Subtotal: $" + calculateSubtotal());
    }

    @Override
    public void display() {
        displayOrderDetail();
    }
    @Override
    public double calculate() {
    return menuItem.getPrice() * quantity;
    }
}

