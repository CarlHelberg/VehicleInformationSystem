// Import the libraries we need for error handling with the menu
// And to get input from the user
import java.util.InputMismatchException;
import java.util.Scanner;

// Define the Menu class
public class Menu {
    public static int showMenu() {
        /*
         * Displays the menu options for the user. If input is valid, returns an integer.
         * If not valid input, calls showMenu() -itself- again to try again.
         */

        // Define the string that makes up the main menu.
        String menuString =
                "Please select one of the following options to interact with the our rental portal. \n " +
                "Type the number of the vehicle you're interested in \n" +
                "1) Car \n" +
                "2) Motorcycle \n" +
                "3) Truck \n" +
                "4) Exit \n";

        // Prints the menu to the screen
        System.out.println(menuString);

        // Create a new scanner object.
        Scanner s = new Scanner(System.in);

        // Using try because the user can enter a string/symbol/decimal, which is illegal
        try {
            // use scanner to get next value if it's an int
            // move to catch if not
            int input = s.nextInt();

            // Check if the input is a valid number 1-4
            if ((input > 0) & (input < 5)){
                // Returns the integer option the user entered
                return input;
            }else{
                // invalid int input x > 1 ; 4 < x
                System.out.println("That's not a valid option! Please choose 1 - 4");
                showMenu();
            }
        }catch (InputMismatchException ime) {
            // The wrong value type entered by the user results in a message
            // and a prompt to re-enter by showing the menu again
            // This catches decimals, letters and symbols
            System.out.println("That's not a number!");
            showMenu();
        }
        // This should never execute as we covered all cases,
        // but java requires a return int at this level
        // In the event of a run time failure this block may well execute
        // returns 4 to gracefully shutdown, but if this executes there is a problem elsewhere
        System.out.println("The Rental Portal had to perform an emergency shutdown!");
        return 4;
    }

    public static int showSecondaryMenu() {
        /*
         * Displays a secondary menu options for the user. If input is valid, returns an integer.
         * If not valid input, calls showMenu() again.
         */

        // Define a menu string
        String menuString =
                "Please select one of the following options to interact with the our rental portal. \n " +
                        "Type the number of the vehicle you're interested in \n" +
                        "1) Rent \n" +
                        "2) See Available Vehicles In This Category \n" +
                        "3) Main menu \n";

        // Prints the menu string to the screen
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
                // We will return to the main menu if the input is out of bounds
                // There's only 1 step to get back to this point, and we assume that the user
                // wanted to take a different action
                System.out.println("That's not a valid option! Please choose 1 - 3");
                showMenu();
            }
        }catch (InputMismatchException ime) {
            // The wrong value type entered by the user results in a message
            // and a prompt to re-enter by showing the menu again
            // This catches decimals, letters and symbols
            System.out.println("That's not a number! ");
            showMenu();
        }
        // This should never execute as we covered all cases,
        // but java requires a return int at this level
        // In the event of a run time failure this block may well execute
        // Tries to recover by returning to the main menu
        System.out.println("Something went wrong, returning to the main menu!");
        return 3;
    }

    public static void handleMenu (){
        /*
         * This function handles the option the user chooses form showMenu() and showSecondaryMenu()
         * Menu functions returns an int, that response is handled here
         * All lower functions have try_catch built in for error handling.
         */

        // Use a switch case for the first menu function
        // The first behaviour for all first-menu option is to display the second menu
        // A nested switch case will handle the value for the second menu and call the
        // appropriate function.
        switch (showMenu()) {
            case 1:
                switch (showSecondaryMenu()) {
                    case 1:
                        Car.rentCarVehicle();
                        break;
                    case 2:
                        Car.listCarVehicle();
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (showSecondaryMenu()) {
                    case 1:
                        Motorcycle.rentMotorcycleVehicle();
                        break;
                    case 2:
                        Motorcycle.listMotorcycleVehicle();
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch (showSecondaryMenu()) {
                    case 1:
                        Truck.rentTruckVehicle();
                        break;
                    case 2:
                        Truck.listTruckVehicle();
                        break;
                    default:
                        break;
                }
                break;
            case 4:
                // Defined as exit, display goodbye msg and exit gracefully
                // This option does not have a second menu option, but could be used as a
                // confirmation in future versions.
                System.out.println("====================================================");
                System.out.println("Thank you for using the Vehicle Information System! Good bye!");
                System.out.println("====================================================");
                // Exit the program, 0 indicates no errors as a reason for exit
                System.exit(0);
                // Exit the switch case, we only need to execute the option chosen
                break;
        }
    }
}
