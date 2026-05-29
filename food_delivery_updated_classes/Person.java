public class Person implements Displayable {

    protected String name;
    protected String phone;
    protected String address;

    // Constructor
    public Person(String name, String phone, String address) {
        setName(name);
        setPhone(phone);
        setAddress(address);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setName(String name) {

        if(name == null || name.trim().isEmpty()
                || name.matches(".*\\d.*")) {

            System.out.println("Invalid person name!");
            return;
        }

        this.name = name;
    }

    public void setPhone(String phone) {

        if(phone == null
                || !phone.matches("\\d{9,11}")) {

            System.out.println(
                    "Invalid phone number! Use 9-11 digits only."
            );

            return;
        }

        this.phone = phone;
    }

    public void setAddress(String address) {

        if(address == null
                || address.trim().isEmpty()) {

            System.out.println("Invalid address!");
            return;
        }

        this.address = address;
    }

    public void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
    }

    @Override
    public void display() {
        displayPerson();
    }

    
}