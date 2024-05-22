// Define a new interface named CarVehicle
public interface CarVehicle extends Vehicle{

    // Declare a method to get the number of doors of the car, which returns an int
    int getNumberOfDoors();

    // Declare a method to get the fuel type of the car, which returns a String
    String getFuelType();

    // Declare a method to set the number of doors of the car, which takes an int as a parameter
    void setNumberOfDoors(int doors);

    // Declare a method to set the fuel type of the car, which takes a String as a parameter
    void setFuelType(String fuelType);
}
