// The Reservable interface represents an entity that can be reserved, such as a bus seat.

package busreserv.update;

// Interface defining methods for reserving and canceling reservations.
public interface Reservable {
    // Method to reserve a seat.
    public boolean reserveSeat();

    // Method to cancel a reservation.
    public boolean cancelReservation();
}
