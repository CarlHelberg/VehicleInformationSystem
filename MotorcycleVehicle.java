// Define a new interface named MotorcycleVehicle
public interface MotorcycleVehicle extends Vehicle{

    // Declare a method to get the number of wheels of the motorcycle, which returns an int
    int getNumberOfWheels();

    // Declare a method to get the body type of the motorcycle, which returns a String
    String getBodyType();

    // Declare a method to set the number of wheels of the motorcycle, which takes an int as a parameter
    void setNumberOfWheels(int wheels);

    // Declare a method to set the body type of the motorcycle, which takes a String as a parameter
    void setBodyType(String bodyType);
}
