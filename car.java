public class Car implements CarVehicle {
    private String make; 
    private String model; 
    private int year; 
    private int numberOfDoors; 
    private String fuelType;

    // Implement the constructor and other methods here // Implementing methods from the Vehicle interface 

    // Constructor
    public Car(String make, String model, int year, int numberOfDoors, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    // Implementing methods from the CarVehicle interface 
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    public String getFuelType() {
        return fuelType;
    }
    public void setNumberOfDoors(int doors) {
        this.numberOfDoors = doors;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}