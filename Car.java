// Import necessary classes from the java.util library
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Define the Car class that implements both CarVehicle and Vehicle interfaces
public class Car implements CarVehicle, Vehicle {
    // Declare class variables
    // Make of the car, accessible within the package
    String make;

    // Model of the car, private to the class
    private String model;

    // Year of the car, accessible within the package
    int year;

    // Number of doors, private to the class
    private int numberOfDoors;

    // Type of fuel, private to the class
    private String fuelType;

    // Declare a static list to hold instances of Car objects
    public static ArrayList<Car> carVehicleList = new ArrayList<Car>();

    // Constructor to initialize the Car object with specified values
    public Car(String _make, String _model, int _year, int _numberOfDoors, String _fuelType) {
        make = _make;
        model = _model;
        year = _year;
        numberOfDoors = _numberOfDoors;
        fuelType = _fuelType;
    }

    // Static method to handle car rental process
    public static void rentCarVehicle() {
        int numberOfDoors = 0;
        int year = 0;

        // Instantiate a new Scanner object to read user input
        Scanner s = new Scanner(System.in);

        // Prompt user for car details
        System.out.println("");
        System.out.print("Enter car make: ");
        String make = s.nextLine();
        System.out.print("Enter car model: ");
        String model = s.nextLine();
        System.out.print("Enter fuel type: ");
        String fuelType = s.nextLine();
        System.out.print("Enter manufacture year: ");

        try {
            // Read year input from the user
            year = s.nextInt();
        } catch (InputMismatchException ime) {
            // Handle invalid input for year
            System.out.println("\n!!! That's not a number !!! \n");
            return;
        }

        System.out.print("Enter number of doors: ");
        try {
            // Read number of doors input from the user
            numberOfDoors = s.nextInt();
        } catch (InputMismatchException ime) {
            // Handle invalid input for number of doors
            System.out.println("\n!!! That's not a number !!! \n");
            return;
        }

        // Validate user input and add new Car to the list
        try {
            if ((!make.isEmpty()) &
                (!model.isEmpty()) &
                (!fuelType.isEmpty())) {

                // Create a new Car object with the validated inputs
                Car newCar = new Car(make, model, year, numberOfDoors, fuelType);
                // Add the new object to the list of Cars
                carVehicleList.add(newCar);

                // Success message neatly printed
                System.out.println("\n--------------------------------------------------------------");
                System.out.println("Your " + make + " car has been rented successfully.");
                System.out.println("-------------------------------------------------------------- \n");
            } else {
                // Failure message for empty input fields
                System.out.println(" \n Sorry, the information entered could not be processed. Returning to the main menu. \n");
            }
        } catch (Exception e) {
            // Handle any other input errors
            System.out.println("\n INPUT ERROR:");
            System.out.println("The Manufacture Year and Number of doors should be integers. Returning to the main menu. \n");
        }
    }

    // Static method to list all cars in the carVehicleList
    public static void listCarVehicle() {
        System.out.println("=========================");
        for (Car car : carVehicleList) {
            // Print details of each car
            System.out.println("Make : " + car.getMake());
            System.out.println("Model : " + car.getModel());
            System.out.println("Year model : " + car.getYear());
            System.out.println("Number of doors : " + car.getNumberOfDoors());
            System.out.println("Fuel type : " + car.getFuelType());
            System.out.println("=========================");
        }
    }

    // Implementing methods from the CarVehicle interface
    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }

    @Override
    public void setNumberOfDoors(int doors) {
        this.numberOfDoors = doors;
    }

    @Override
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    // Implementing methods from the Vehicle interface
    @Override
    public String getMake() {
        return this.make;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }
}
