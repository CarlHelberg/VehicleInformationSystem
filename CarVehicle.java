public interface CarVehicle extends Vehicle {
    int getNumberOfDoors(); 
    String getFuelType(); 
    void setNumberOfDoors(int doors); 
    void setFuelType(String fuelType);
}