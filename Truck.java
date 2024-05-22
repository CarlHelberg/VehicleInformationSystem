// Import necessary classes from the java.util library
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Define the Truck class that implements both Vehicle and TruckVehicle interfaces
public class Truck implements Vehicle, TruckVehicle {
    // Declare class variables
    // make of the truck, accessible within the package
    String make;

    // model of the truck, private to the class
    private String model;

    // year of the truck, accessible within the package
    int year;

    // cargo capacity of the truck, accessible within the package
    double cargoCapacity;

    // transmission type of the truck, accessible within the package
    String transmissionType;

    // Declare a static list to hold instances of Truck objects
    public static ArrayList<Truck> truckVehicleList = new ArrayList<Truck>();

    // Constructor to initialize the Truck object with specified values
    public Truck(String _make, String _model, int _year, double _cargoCapacity, String _transmissionType) {
        make = _make;
        model = _model;
        year = _year;
        transmissionType = _transmissionType;
        cargoCapacity = _cargoCapacity;
    }

    // Static method to list all trucks in the truckVehicleList
    public static void listTruckVehicle() {
        System.out.println("=========================");
        // Iterate through each truck in the list and print its details
        for (Truck truck : truckVehicleList) {
            System.out.println("Make : " + truck.getMake());
            System.out.println("Model : " + truck.getModel());
            System.out.println("Year model : " + truck.getYear());
            System.out.println("Transmission Type : " + truck.getTransmissionType());
            System.out.println("Cargo Capacity In Tonnes : " + truck.getCargoCapacity());
            System.out.println("=========================");
        }
    }

    // Static method to handle truck rental process
    public static void rentTruckVehicle() {
        // Initialise local variable needed for this process
        int year = 0;
        double cargoCapacity = 0;

        // Instantiate a new Scanner object to read user input
        Scanner s = new Scanner(System.in);

        // Prompt user for truck details
        System.out.println("");
        System.out.print("Enter Truck Make: ");
        String make = s.nextLine();
        System.out.print("Enter Truck Model: ");
        String model = s.nextLine();
        System.out.print("Enter Transmission Type: ");
        String transmissionType = s.nextLine();
        System.out.print("Enter Manufacture Year: ");
        try {
            year = s.nextInt();
        } catch (InputMismatchException ime) {
            // Handle invalid input for year
            System.out.println("\n !!!That's not a number !!! \n");
            return;
        }

        System.out.print("Enter Cargo Capacity in Tonnes: ");
        try {
            cargoCapacity = s.nextDouble();
        } catch (InputMismatchException ime) {
            // Handle invalid input for cargo capacity
            System.out.println("\n !!!That's not a number !!! \n");
            return;
        }

        // Validate user input and add new Truck to the list
        try {
            // Validate name is not empty string
            if ((!make.isEmpty()) &
                (!model.isEmpty()) &
                (!transmissionType.isEmpty())) {
                // Create new Truck object with validated inputs
                Truck newTruck = new Truck(make, model, year, cargoCapacity, transmissionType);
                truckVehicleList.add(newTruck);

                // Success message
                System.out.println("\n--------------------------------------------------------------");
                System.out.println("Your " + make + " truck has been rented successfully.");
                System.out.println("--------------------------------------------------------------\n");
            } else {
                // Failure message for empty input fields
                System.out.println("\nSorry, the Information entered could not be processed. Returning to the main menu.\n");
            }
        } catch (Exception e) {
            // Handle any other input errors
            System.out.println("\nINPUT ERROR:");
            System.out.println("The Manufacture Year and Cargo Capacity should be integers. Returning to the main menu.\n");
        }
    }

    // Implementing methods from the TruckVehicle interface
    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    @Override
    public void setCargoCapacity(double _capacity) {
        cargoCapacity = _capacity;
    }

    @Override
    public void setTransmissionType(String _transmissionType) {
        transmissionType = _transmissionType;
    }

    // Implementing methods from the Vehicle interface
    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setMake(String _make) {
        make = _make;
    }

    @Override
    public void setModel(String _model) {
        model = _model;
    }

    @Override
    public void setYear(int _year) {
        year = _year;
    }
}
