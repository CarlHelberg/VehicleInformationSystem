// Define a new interface named TruckVehicle that extends the Vehicle interface
public interface TruckVehicle extends Vehicle {

    // Declare a method to get the cargo capacity of the truck, which returns a double
    double getCargoCapacity();

    // Declare a method to get the transmission type of the truck, which returns a String
    String getTransmissionType();

    // Declare a method to set the cargo capacity of the truck, which takes a double as a parameter
    void setCargoCapacity(double capacity);

    // Declare a method to set the transmission type of the truck, which takes a String as a parameter
    void setTransmissionType(String transmissionType);
}
