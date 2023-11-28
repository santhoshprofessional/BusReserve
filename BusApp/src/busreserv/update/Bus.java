package busreserv.update;

import java.util.Date;

class Bus implements Reservable{
    private String busNumber;
    private String route;
    private int capacity;
    private Date date;
    private int availableSeats;
    
    // Constructor to initialize the Bus object with given details
    public Bus(String busNumber, String route, int capacity,Date date) {
        this.busNumber = busNumber;
        this.route = route;
        this.capacity = capacity;
        this.availableSeats = capacity; // Initially, all seats are available
        this.date=date;
    }

    // Getter method to retrieve the bus number
    public String getBusNumber() {
        return busNumber;
    }
    // Getter method to retrieve the bus route
    public String getRoute() {
        return route;
    }
    public Date getDate() {
    	return date;
    }
    // Getter method to retrieve the number of available seats
    public int getAvailableSeats() {
        return availableSeats;
    }

    // Method to reserve a seat
    @Override
    public boolean reserveSeat() {
        if (availableSeats > 0) { // Check if there are available seats
            availableSeats--; // Reduce the available seats by 1
            return true; // Return true to indicate a successful reservation
        } else {
            return false; // Return false to indicate that no seats are available
        }
    }



    // Method to cancel a reservation and increase the available seats
    @Override
    public boolean cancelReservation() {
        if (availableSeats < capacity) { // Check if there are reserved seats
            availableSeats++; // Increase the available seats by 1
            return true;
        }else if(capacity <= 0) { // The capacity is 0 or less, cancellation not possible, return false
        	return false;
        }
        else {
        	return false; // No reserved seats, return false as there is nothing to cancel
        }
    }
}