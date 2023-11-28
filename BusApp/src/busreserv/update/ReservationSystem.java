// The ReservationSystem class represents the core system for managing bus reservations.

package busreserv.update;

import java.util.ArrayList;
import java.util.Date;

public class ReservationSystem {
    // Lists to store information about buses, users, and administrators.
    private ArrayList<Bus> buses;
    private ArrayList<User> users;
    private ArrayList<Admin> admins;

    // Variables to keep track of the current user and admin in the system.
    private User currentUser;
    private Admin currentAdmin;

    // Constructor to initialize the ReservationSystem with empty lists and default admin accounts.
    public ReservationSystem() {
        this.buses = new ArrayList<>();
        this.users = new ArrayList<>();
        this.admins = new ArrayList<Admin>();
        this.currentUser = null;
        
        // Default admin accounts for system access.
        admins.add(new Admin("admin1","123"));
        admins.add(new Admin("admin2","123"));
        this.currentAdmin = null;
    }

    // Method to register a new user with the system.
    public void registerUser(String username, String password) {
        users.add(new User(username, password));
        System.out.println("User registered successfully!");
    }

    // Method to handle user login, setting the currentUser if successful.
    public void login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.authenticate(password)) {
                currentUser = user;
                System.out.println("Login successful!");
                return; // Exit the method immediately if login is successful
            }
        }
        // If the loop completes without finding a matching user, print a failure message
        System.out.println("Invalid username or password. Login failed.");
    }

    // Method to handle admin login, setting the currentAdmin if successful.
    public void adlogin(String adminname, String adpassword) {
        for (Admin admin : admins) {
            if (admin.getAdminname().equals(adminname) && admin.authenticate(adpassword)) {
                currentAdmin = admin;
                System.out.println("Admin Login successful!");
                return; // Exit the method immediately if login is successful
            }
        }
        // If the loop completes without finding a matching admin, print a failure message
        System.out.println("Invalid adminname or password. Login failed.");
    }

    // Method to add a new bus to the system.
    public void addBus(String busNumber, String route, int totalSeats, Date date) {
        buses.add(new Bus(busNumber, route, totalSeats, date));
        System.out.println("Bus added successfully!");
    }

    // Method to display available buses in the system.
    public void displayAvailableBuses() {
        System.out.println("Available Buses:");
        for (Bus bus : buses) {
            System.out.println(bus.getBusNumber() + " - " + bus.getRoute() +
                    " (" + bus.getAvailableSeats() + " seats available) " + bus.getDate());
        }
    }

    // Method to reserve a seat on a specific bus, throwing ReserveException if unsuccessful.
    public void reserveSeat(String busNumber, String route, Date date) throws ReserveException {
        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber) && bus.getRoute().equals(route) && bus.getDate().equals(date)) {
                if (bus.reserveSeat()) {
                    System.out.println("Seat reserved successfully!");
                } else {
                    throw new ReserveException();
                }
                return;
            }
        }
        System.out.println("Invalid bus.");
    }

    // Method to cancel a reservation on a specific bus, throwing CancelException if unsuccessful.
    public void cancelReservation(String busNumber, String route, Date date) throws CancelException {
        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber) && bus.getRoute().equals(route) && bus.getDate().equals(date)) {
                if (bus.cancelReservation()) {
                    System.out.println("Reservation canceled successfully.");
                } else {
                    throw new CancelException();
                }
                return;
            }
        }
        System.out.println("Invalid bus.");
    }

    // Getter method to retrieve the current user in the system.
    public User getCurrentUser() {
        return currentUser;
    }

    // Getter method to retrieve the current admin in the system.
    public Admin getCurrentAdmin() {
        return currentAdmin;
    }

    // Method to log out the current admin.
    public void setCurrentAdmin() {
        currentAdmin = null;
        System.out.println("Admin Log Out Successful");
    }

    // Method to log out the current user.
    public void setCurrentUser() {
        currentUser = null;
        System.out.println("User Log Out successful!");
    }
}
