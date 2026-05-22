import java.util.ArrayList;
import java.util.HashMap;

public class FoodDeliverySystem {
    private ArrayList<Customer> customers;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Order> orders;
    private HashMap<Integer, MenuItem> menuMap;

    public FoodDeliverySystem() {
        customers = new ArrayList<>();
        restaurants = new ArrayList<>();
        orders = new ArrayList<>();
        menuMap = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        if (customer != null) customers.add(customer);
    }

    public void addRestaurant(Restaurant restaurant) {
        if (restaurant != null) restaurants.add(restaurant);
    }

    public void addOrder(Order order) {
        if (order == null) {
            System.out.println("Invalid order!");
            return;
        }

        if (!order.hasOrderDetails()) {
            System.out.println("Cannot add order. Order has no items.");
            return;
        }

        orders.add(order);
    }

    public void addMenuItemToMap(MenuItem menuItem) {
        if (menuItem != null) menuMap.put(menuItem.getMenuID(), menuItem);
    }

    public MenuItem selectMenuItem(int menuID) {
        MenuItem selectedItem = menuMap.get(menuID);
        if (selectedItem == null) {
            System.out.println("Wrong menu selection! Menu ID " + menuID + " does not exist.");
        }
        return selectedItem;
    }

    public void processPayment(Payment payment) {
        if (payment == null) {
            System.out.println("Invalid payment!");
            return;
        }

        payment.pay();
    }

    public void processDelivery(Delivery delivery) {
        if (delivery == null) {
            System.out.println("Invalid delivery!");
            return;
        }

        delivery.updateStatus("Delivered");
    }

    public void displayCustomers() {
        for (Customer customer : customers) {
            customer.display();
            System.out.println();
        }
    }

    public void displayRestaurants() {
        for (Restaurant restaurant : restaurants) {
            restaurant.display();
            System.out.println();
        }
    }

    public void displayOrders() {
        for (Order order : orders) {
            order.display();
            System.out.println();
        }
    }
}
