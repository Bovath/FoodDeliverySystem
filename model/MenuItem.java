package model;
import interfaces.*;

public class MenuItem implements Displayable {
    private int menuID;
    private String foodName;
    private double price;
    private String category;
    private Restaurant restaurant;

    public MenuItem(int menuID, String foodName, double price, String category, Restaurant restaurant) {
        setMenuID(menuID);
        setFoodName(foodName);
        setPrice(price);
        setCategory(category);
        setRestaurant(restaurant);
    }

    public int getMenuID() { return menuID; }
    public String getFoodName() { return foodName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public Restaurant getRestaurant() { return restaurant; }

    public void setMenuID(int menuID) {
        if (menuID <= 0) {
            System.out.println("Invalid menu ID!");
            return;
        }
        this.menuID = menuID;
    }

    public void setFoodName(String foodName) {
        if (foodName == null || foodName.trim().isEmpty()) {
            System.out.println("Invalid food name!");
            return;
        }
        this.foodName = foodName;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            System.out.println("Invalid price!");
            return;
        }
        this.price = price;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            System.out.println("Invalid category!");
            return;
        }
        this.category = category;
    }

    public void setRestaurant(Restaurant restaurant) {
        if (restaurant == null) {
            System.out.println("Invalid restaurant!");
            return;
        }
        this.restaurant = restaurant;
    }

    public void displayMenuItem() {
        System.out.println("Menu ID: " + menuID);
        System.out.println("Food: " + foodName);
        System.out.println("Price: $" + price);
        System.out.println("Category: " + category);
        System.out.println("Restaurant: " + restaurant.getName());
    }

    @Override
    public void display() {
        displayMenuItem();
    }

}
