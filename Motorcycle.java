// Import necessary classes from the java.util library
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Define the Motorcycle class that implements both Vehicle and MotorcycleVehicle interfaces
public class Motorcycle implements Vehicle, MotorcycleVehicle {
    // Declare class variables
    // make of the motorcycle, accessible within the package
    String make;

    // model of the motorcycle, private to the class
    private String model;

    // year of the motorcycle, accessible within the package
    int year;

    // number of wheels, accessible within the package
    int numberOfWheels;

    // body type of the motorcycle, accessible within the package
    String bodyType;

    // Declare a static list to hold instances of Motorcycle objects
    public static ArrayList<Motorcycle> motorcycleVehicleList = new ArrayList<Motorcycle>();

    // Constructor to initialize the Motorcycle object with specified values
    public Motorcycle(String _make, String _model, int _year, int _numberOfWheels, String _bodyType) {
        make = _make;
        model = _model;
        year = _year;
        numberOfWheels = _numberOfWheels;
        bodyType = _bodyType;
    }

    // Static method to list all motorcycles in the motorcycleVehicleList
    public static void listMotorcycleVehicle() {
        System.out.println("=========================");
        // Iterate through each motorcycle in the list and print its details
        for (Motorcycle motorcycle : motorcycleVehicleList) {
            System.out.println("Make : " + motorcycle.getMake());
            System.out.println("Model : " + motorcycle.getModel());
            System.out.println("Year model : " + motorcycle.getYear());
            System.out.println("Number of Wheels : " + motorcycle.getNumberOfWheels());
            System.out.println("Body type : " + motorcycle.getBodyType());
            System.out.println("=========================");
        }
    }

    // Static method to handle motorcycle rental process
    public static void rentMotorcycleVehicle() {
        // Initialise local variables needed for this operation
        int numberOfWheels = 0;
        int year = 0;
        String bodyType = "";

        // Instantiate a new Scanner object to read user input
        Scanner s = new Scanner(System.in);

        // Prompt user for motorcycle details
        System.out.println("");
        System.out.print("Enter Motorcycle Make: ");
        String make = s.nextLine();
        System.out.print("Enter Motorcycle Model: ");
        String model = s.nextLine();
        System.out.print("Choose Body Type: \n" +
                "1) Cruiser \n" +
                "2) Sport \n" +
                "3) Off-road \n");

        // Read and set the body type based on user input
        switch (s.nextLine()) {
            case "1":
                bodyType = "Cruiser";
                break;
            case "2":
                bodyType = "Sport";
                break;
            case "3":
                bodyType = "Off-road";
                break;
            default:
                // Invalid input will break out of switch case, parent fn will call main menu
                System.out.println("\n!!! That's not a valid body type option !!! \n");
                return;
        }

        // Prompt user for the manufacture year
        System.out.print("Enter Manufacture Year: ");
        try {
            year = s.nextInt();
        } catch (InputMismatchException ime) {
            // Handle invalid input for year
            System.out.println("\n !!!That's not a number !!! \n");
            return;
        }

        // Prompt user for the number of wheels
        System.out.print("Enter Number Of Wheels: ");
        try {
            numberOfWheels = s.nextInt();
        } catch (InputMismatchException ime) {
            // Handle invalid input for number of wheels
            System.out.println("\n !!!That's not a number !!! \n");
            return;
        }

        // Validate user input and add new Motorcycle to the list
        try {
            if ((!make.isEmpty()) &
                (!model.isEmpty()) &
                (!bodyType.isEmpty())) {
                // Create a new motorcycle object with validated inputs
                Motorcycle newMotorcycle = new Motorcycle(make, model, year, numberOfWheels, bodyType);
                motorcycleVehicleList.add(newMotorcycle);

                // Success message
                System.out.println("\n--------------------------------------------------------------");
                System.out.println("Your " + make + " motorcycle has been rented successfully.");
                System.out.println("--------------------------------------------------------------\n");
            } else {
                // Failure message for empty input fields
                System.out.println("\nSorry, the Information entered could not be processed. Returning to the main menu.\n");
            }
        } catch (Exception e) {
            // Handle any other input errors
            System.out.println("\nINPUT ERROR:");
            System.out.println("The Manufacture Year and Number of doors should be integers. Returning to the main menu.\n");
        }
    }

    // Implementing methods from the MotorcycleVehicle interface
    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public String getBodyType() {
        return bodyType;
    }

    @Override
    public void setNumberOfWheels(int _numberOfWheels) {
        numberOfWheels = _numberOfWheels;
    }

    @Override
    public void setBodyType(String _bodyType) {
        bodyType = _bodyType;
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
