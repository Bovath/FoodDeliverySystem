import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Bora", "012345678", "Phnom Penh");
        Customer c2 = new Customer("Dara", "099999999", "Siem Reap");

        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(c1);
        customerList.add(c2);

        Restaurant r1 = new Restaurant("Burger King", "Phnom Penh", "011222355");
        Restaurant r2 = new Restaurant("Pizza Hut", "Phnom Penh", "033222355");

        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(r1);
        restaurantList.add(r2);

        MenuItem m1 = new MenuItem(1, "Cheese Burger", 4.0, "Burger", r1);
        MenuItem m2 = new MenuItem(2, "Chicken Burger", 5.0, "Burger", r1);
        MenuItem m3 = new MenuItem(3, "Cheese Pizza", 6.0, "Pizza", r2);

        r1.addMenuItem(m1);
        r1.addMenuItem(m2);
        r2.addMenuItem(m3);

        int wrongMenuID = 99;
        if (r1.getMenuItemByID(wrongMenuID) == null) {
            System.out.println("Wrong menu selection! Menu ID " + wrongMenuID + " does not exist.");
        }

        Order order = new Order(c1, r1, "2026-04-30", "Pending");

        MenuItem selectedItem1 = r1.getMenuItemByID(1);
        MenuItem selectedItem2 = r1.getMenuItemByID(2);

        order.addOrderDetail(new OrderDetail(1, selectedItem1, 2));
        order.addOrderDetail(new OrderDetail(2, selectedItem2, 3));

        Payment payment = new Payment(1, order, "ABA");
        Payable payable = payment;

        if (order.hasOrderDetails()) {
            payable.pay();
        }

        DeliveryDriver driver1 = new DeliveryDriver(1, "John", "0881234567", "Phnom Penh", "Motorbike");
        Delivery delivery = new Delivery(1, order, driver1);
        Deliverable deliverable = delivery;

        if (order.getStatus().equalsIgnoreCase("Paid") ||
        order.getStatus().equalsIgnoreCase("Confirmed")) {
        deliverable.updateStatus("Delivered");
        }



        System.out.println("\n===== CUSTOMERS =====");
        for (Customer customer : customerList) {
            customer.display();
                
            System.out.println();
        }

         System.out.println("===== RESTAURANTS =====");
        for (Restaurant restaurant : restaurantList) {
            restaurant.display();
            System.out.println();
            restaurant.display(true);   // overloaded display: restaurant only

         
        }

        System.out.println("===== UNIQUE CATEGORIES =====");
        HashSet<String> categorySet = new HashSet<>();

        for (Restaurant restaurant : restaurantList) {
            for (MenuItem item : restaurant.getMenuMap()) {
                categorySet.add(item.getCategory());
            }
        }

        for (String category : categorySet) {
            System.out.println(category);
        }

        System.out.println("\n===== ORDER =====");
        order.display();

        System.out.println("\n===== ORDER DETAILS =====");
        for (OrderDetail detail : order.getOrderDetails()) {
            detail.display();
            System.out.println();
        }


        System.out.println("\n===== PAYMENT =====");
        payment.display();

        System.out.println("\n===== DELIVERY =====");
        delivery.display();
    }
}
