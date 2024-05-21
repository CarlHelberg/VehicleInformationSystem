import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VehicleInformationSystem {
    // public ArrayList<MotorVehicle> motorVehicleList;
    public static ArrayList<CarVehicle> carVehicleList = new ArrayList<CarVehicle>();
    // public ArrayList<TruckVehicle> truckVehicleList;
    public static void main(String[] args) {
        while (true){
            handleMenu();
        }
    }

    public static int showMenu() {
        /*
         * Displays the menu options for the user. If input is valid, returns an integer.
         * If not valid input, calls showMenu() again.
         */
        String menuString =
        "Please select one of the following options to interact with the our rental portal. \n " + 
        "Type the number of the vehicle you're interested in \n" +
        "1) Car \n" +
        "2) Motorcycle \n" +
        "3) Truckn \n" +
        "4) Exit";

        System.out.println(menuString);
        // Create a new scanner object.
        Scanner s = new Scanner(System.in);
        
        // Using try because the user can enter a string/symbol/decimal, which is illegal
        try {
            // use scanner to get next value if it's an int, move to catch if not
            int input = s.nextInt();
            // Check if the input is a valid number 1-4
            if ((input > 0) & (input < 5)){
                return input;
            }else{
                // invalid int input x > 1 ; 4 < x
                System.out.println("That's not a valid option! Please choose 1 - 4");
                showMenu();
            }
        }catch (InputMismatchException ime) {
            System.out.println("That's not a number! ");
            showMenu();
            // The wrong value type entered by the user results in a message and a prompt to re enter
            // This catches decimals, letters and symbols
        }
        // This will never execute as we covered all cases, but java requires a return int at this level
        System.out.println("The Rental Portal had to perform an emergency shutdown!");
        return 4;
    }

    public static int showSecondaryMenu() {
        /*
         * Displays the menu options for the user. If input is valid, returns an integer.
         * If not valid input, calls showMenu() again.
         */
        String menuString =
        "Please select one of the following options to interact with the our rental portal. \n " + 
        "Type the number of the vehicle you're interested in \n" +
        "1) Rent \n" +
        "2) See Available Vehicles \n" +
        "3) Main menu";

        System.out.println(menuString);
        // Create a new scanner object.
        Scanner s = new Scanner(System.in);
        
        // Using try because the user can enter a string/symbol/decimal, which is illegal
        try {
            // use scanner to get next value if it's an int, move to catch if not
            int input = s.nextInt();
            // Check if the input is a valid number 1-4
            if ((input > 0) & (input < 4)){
                return input;
            }else{
                // invalid int input x > 1 ; 4 < x
                System.out.println("That's not a valid option! Please choose 1 - 3");
                showMenu();
            }
        }catch (InputMismatchException ime) {
            System.out.println("That's not a number! ");
            showMenu();
            // The wrong value type entered by the user results in a message and a prompt to re enter
            // This catches decimals, letters and symbols
        }
        // This will never execute as we covered all cases, but java requires a return int at this level
        System.out.println("Something went wrong, returning to the main menu!");
        return 3;
    }

    public static void handleMenu (){
        /*
         * This function handles the option the user chooses form showMenu()
         * showMenu() returns an int, that response is handled here
         * All functions have try_catch built in for error handling.
         */
        
        switch (showMenu()) {
            case 1:
                switch (showSecondaryMenu()) {
                    case 1:
                        rentCarVehicle();
                        break;
                    case 2:
                        listCarVehicle();
                        break;
                
                    default:
                        showMenu();
                        break;
                }
                break;
            case 2:
                // updateStudent();
                break;
            case 3:
                // viewStudentDetails();
                break;
            case 4:
                // Defined as exit, display goodbye msg and exit gracefully
                System.out.println("====================================================");
                System.out.println("Thank you for using the Vehicle Information System! Good bye!");
                System.out.println("====================================================");
                // Exit the program, 0 indicates no errors as a reason for exit
                System.exit(0);
                // Exit the switch case, we only need to execute the option chosen
                break;
        }
    }

    public static void listCarVehicle (){
        System.out.println("=========================");
        for (CarVehicle car : carVehicleList){
            System.out.println("Make : " + car.getMake());
            System.out.println("Model : " + car.getModel());
            System.out.println("Year model : " + car.getYear());
            System.out.println("Number of doors : " + car.getNumberOfDoors());
            System.out.println("Fuel type : " + car.getFuelType());
            System.out.println("=========================");
        }
    }

    public static void rentCarVehicle (){
        int numberOfDoors = 0;
        int year = 0;
        // Instantiate a new scanner object
        Scanner s = new Scanner(System.in);

        // Neatly print prompts and get input
        // Use nextLine to avoid crashes
        System.out.println("");
        System.out.print("Enter car make: ");
        String make = s.nextLine();
        System.out.print("Enter car model: ");
        String model = s.nextLine();
        System.out.print("Enter maufacture year: ");
        try {
            year = s.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("That's not a number! ");
            showMenu();
        }
        
        System.out.print("Enter number of doors: ");
        try {
            numberOfDoors = s.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("That's not a number! ");
            showMenu();
        }
        System.out.print("Enter fuel type: ");
        String fuelType = s.nextLine();

        // Validate user input
        // If the input values cannot be parsed or assigned in the array of the required type
        // the input is not valid.
        try {
            // Validate name is not empty string
            if ((make.length() > 0) & 
                (model.length() > 0) & 
                (fuelType.length() > 0))
            {
                CarVehicle newCar = CarVehicle(make, model, year, numberOfDoors, fuelType);
                carVehicleList.add(newCar);
                // Success message
                System.out.println("");
                System.out.println("--------------------------------------------------------------");
                System.out.println("Your " + make + " has been added successfully.");
                System.out.println("--------------------------------------------------------------");
                System.out.println("");
            }else{
                // Failure message
                System.out.println("");
                System.out.println("Sorry, the Information entered could not be processed. Returning to the main menu.");
                System.out.println("");
            }

        } catch (Exception e) { 
            System.out.println("");
            System.out.println("INPUT ERROR:");
            System.out.println("The Manufacture Year and Number of doors should be integers. Returning to the main menu");
            System.out.println("");
        }
    }
    
}
/*
public class Truck implements TruckVehicle {

    private String make; 
    private String model; 
    private int year; 
    private double cargoCapacity; 
    private String transmissionType; 
    // Implement the constructor and other methods here
    // Implementing methods from the Vehicle interface 

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
    // Implementing methods from the TruckVehicle interface 
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public String getTransmissionType() {
        return transmissionType;
    }
    public void setCargoCapacity(double capacity) {
        this.cargoCapacity = capacity;
    }
    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
}

public class Motorcycle implements MotorVehicle {

    private String make; 
    private String model; 
    private int year; 
    private int numberOfWheels; 
    private String motorcycleType; 
    
    // Implement the constructor and other methods here // Implementing methods from the Vehicle interface 
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
    // Implementing methods from the MotorVehicle interface 
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    public String getMotorcycleType() {
        return motorcycleType;
    }

    public void setNumberOfWheels(int wheels) {
        this.numberOfWheels = wheels;
    }
    public void setMotorcycleType(String type) {
        this.motorcycleType = type;
    }
} 
*/


/*
public interface TruckVehicle extends Vehicle {
    double getCargoCapacity(); 
    String getTransmissionType(); 
    void setCargoCapacity(double capacity); 
    void setTransmissionType(String transmissionType);
}

public interface MotorVehicle extends Vehicle {
    int getNumberOfWheels(); 
    String getMotorcycleType(); 
    void setNumberOfWheels(int wheels); 
    void setMotorcycleType(String type);
}
*/