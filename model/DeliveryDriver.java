package model;

public class DeliveryDriver extends Person {

    private int driverID;
    private String vehicleType;

    public DeliveryDriver(int driverID,
                          String name,
                          String phone,
                          String address,
                          String vehicleType) {

        super(name, phone, address);

        this.driverID = driverID;
        this.vehicleType = vehicleType;
    }

    public int getDriverID() {
        return driverID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Driver ID: " + driverID);
        System.out.println("Vehicle Type: " + vehicleType);
    }
}