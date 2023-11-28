package busreserv.update;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// The MainClass contains the main method and serves as the entry point for the Bus Reservation System application.

/* @author  santhosh
 * @version 14-11-2023
 * @code    Java Program for Bus Reservation System App
 */
public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();
        int choice, innerChoice, innerChoice1;

        // Main loop for the application
        do {
            System.out.println("  Bus Reservation System App");
            System.out.println(" ____________________________");
            System.out.println("|1.ADMIN                     |");
            System.out.println("|2.USER                      |");
            System.out.println("|3.EXIT                      |");
            System.out.println("|____________________________|");
            System.out.println(" Enter your choice: ");
            choice = scanner.nextInt();

            // Switch statement to handle user's main menu choice
            switch (choice) {
                case 1:
                    // Admin menu
                    do {
                        System.out.println(" ____________________________");
                        System.out.println("|1. Admin Login              |");
                        System.out.println("|2. Add Bus                  |");
                        System.out.println("|3. Display Available Buses  |");
                        System.out.println("|4. Admin Logout             |");
                        System.out.println("|5. Exit                     |");
                        System.out.println("|____________________________|");
                        System.out.println(" Enter your choice: ");
                        innerChoice = scanner.nextInt();

                        // Switch statement to handle admin menu choices
                        switch (innerChoice) {
                            case 1:
                                // Admin login
                                System.out.print("Enter your admin name: ");
                                String adminUsername = scanner.next();
                                System.out.print("Enter your admin password: ");
                                String adminPassword = scanner.next();
                                reservationSystem.adlogin(adminUsername, adminPassword);
                                break;
                            case 2:
                                // Add Bus
                                if (reservationSystem.getCurrentAdmin() == null) {
                                    System.out.println("Please log in admin before Adding Bus.");
                                } else {
                                    System.out.print("Enter bus number: ");
                                    String busNumber = scanner.next();
                                    System.out.print("Enter Destination: ");
                                    String route = scanner.next();
                                    System.out.print("Enter total seats: ");
                                    int totalSeats = scanner.nextInt();
                                    System.out.println("Enter Date:dd-MM-yyyy");
                                    String dateInput = scanner.next();
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                    Date date = null;
                                    try {
                                        date = dateFormat.parse(dateInput);
                                    } catch (ParseException e) {
                                        System.out.println("ParseException is Handled");
                                    }
                                    reservationSystem.addBus(busNumber, route, totalSeats, date);
                                }
                                break;
                            case 3:
                                // Display Available Buses
                                reservationSystem.displayAvailableBuses();
                                break;
                            case 4:
                                // Admin Logout
                                reservationSystem.setCurrentAdmin();
                                break;
                            case 5:
                                // Exit admin menu
                                System.out.println("Thank you!");
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter a valid option.");
                        }
                    } while (innerChoice != 5);
                    break;

                case 2:
                    // User menu
                    do {
                        System.out.println(" ____________________________");
                        System.out.println("|1. Register User            |");
                        System.out.println("|2. User Login               |");
                        System.out.println("|3. Display Available Buses  |");
                        System.out.println("|4. Reserve Seat             |");
                        System.out.println("|5. Cancel Reservation       |");
                        System.out.println("|6. User Logout              |");
                        System.out.println("|7. Exit                     |");
                        System.out.println("|____________________________|");
                        System.out.println(" Enter your choice: ");
                        innerChoice1 = scanner.nextInt();

                        // Switch statement to handle user menu choices
                        switch (innerChoice1) {
                            case 1:
                                // Register User
                                System.out.print("Enter a username: ");
                                String regUsername = scanner.next();
                                System.out.print("Enter a password: ");
                                String regPassword = scanner.next();
                                reservationSystem.registerUser(regUsername, regPassword);
                                break;
                            case 2:
                                // User Login
                                System.out.print("Enter your username: ");
                                String loginUsername = scanner.next();
                                System.out.print("Enter your password: ");
                                String loginPassword = scanner.next();
                                reservationSystem.login(loginUsername, loginPassword);
                                break;
                            case 3:
                                // Display Available Buses
                                reservationSystem.displayAvailableBuses();
                                break;
                            case 4:
                                // Reserve Seat
                                if (reservationSystem.getCurrentUser() == null) {
                                    System.out.println("Please log in before reserving a seat.");
                                } else {
                                    System.out.print("Enter the bus number to reserve a seat: ");
                                    String reserveBusNumber = scanner.next();
                                    System.out.println("Enter the bus Destination:");
                                    String reserveBusDestination = scanner.next();
                                    System.out.println("Enter date dd-MM-yyyy");
                                    String dateInput = scanner.next();
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                    Date date = null;
                                    try {
                                        date = dateFormat.parse(dateInput);
                                    } catch (ParseException e) {
                                        System.out.println("ParseException is Handled");
                                    }
                                    try {
                                        reservationSystem.reserveSeat(reserveBusNumber, reserveBusDestination, date);
                                    } catch (ReserveException r) {
                                        System.out.println("Reservation is Failed:" + r.getMessage());
                                    }
                                }
                                break;
                            case 5:
                                // Cancel Reservation
                                if (reservationSystem.getCurrentUser() == null) {
                                    System.out.println("Please log in before canceling a reservation.");
                                } else {
                                    System.out.print("Enter the bus number to cancel the reservation: ");
                                    String cancelBusNumber = scanner.next();
                                    System.out.println("Enter the bus Destination:");
                                    String cancelBusDestination = scanner.next();
                                    System.out.println("Enter date dd-MM-yyyy");
                                    String cancelDateInput = scanner.next();
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                    Date cancelDate = null;
                                    try {
                                        cancelDate = dateFormat.parse(cancelDateInput);
                                    } catch (ParseException e) {
                                        System.out.println("ParseException is Handled");
                                    }
                                    try {
                                        reservationSystem.cancelReservation(cancelBusNumber, cancelBusDestination, cancelDate);
                                    } catch (CancelException c) {
                                        System.out.println("Cancellation is Failed:" + c.getMessage());
                                    }
                                }
                                break;
                            case 6:
                                // User Logout
                                reservationSystem.setCurrentUser();
                                break;
                            case 7:
                                // Exit user menu
                                System.out.println("Thank you! please visit again");
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter a valid option.");
                        }
                    } while (innerChoice1 != 7);
                    break;
                case 3:
                    // Exit the application
                    System.out.println("Thank you! please visit again");
                    break;
            }
        } while (choice != 3);
    }
}
