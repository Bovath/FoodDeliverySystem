
import java.util.ArrayList;


public class Restaurant implements Displayable {
    private int restaurantID;
    private String name;
    private String location;
    private String phone;
    private ArrayList<MenuItem> menuItems;
    

    private static int restaurantCount = 0;

    public Restaurant(String name, String location, String phone) {
        restaurantCount++;
        this.restaurantID = restaurantCount;
        this.menuItems = new ArrayList<>();

        setName(name);
        setLocation(location);
        setPhone(phone);
    }

    public int getRestaurantID() { return restaurantID; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getPhone() { return phone; }
    public ArrayList<MenuItem> getMenuItems() { return menuItems; }
    public static int getRestaurantCount() { return restaurantCount; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid restaurant name!");
            return;
        }
        this.name = name;
    }

    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            System.out.println("Invalid location!");
            return;
        }
        this.location = location;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{9,11}")) {
            System.out.println("Invalid restaurant phone! Use 9-11 digits only.");
            return;
        }
        this.phone = phone;
    }

    public void addMenuItem(MenuItem menuItem) {
        if (menuItem == null) {
            System.out.println("Invalid menu item!");
            return;
        }
    
        if (menuItem.getRestaurant() != this) {
            System.out.println("This menu item does not belong to " + name + ".");
            return;
        }
    
        menuItems.add(menuItem);
    }


    public void displayRestaurant() {
        System.out.println("Restaurant ID: " + restaurantID);
        System.out.println("Restaurant Name: " + name);
        System.out.println("Restaurant Location: " + location);
        System.out.println("Restaurant Phone: " + phone);
    }

    public void displayMenu() {
        System.out.println("Menu for " + name + ":");
        for (MenuItem item : menuItems) {
            System.out.println(item.getMenuID() + ". " + item.getFoodName() + " - $" + item.getPrice());
        }
    }
    

    public MenuItem getMenuItemByID(int menuID) {
        for (MenuItem item : menuItems) {
            if (item.getMenuID() == menuID) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<MenuItem> getMenuMap() {
        return menuItems;
    }

    @Override
public void display() {
    displayRestaurant();
    displayMenu();
}
    public void display(boolean showMenu) {

    displayRestaurant();

    if (showMenu) {

        displayMenu();

    }

}

   
}
