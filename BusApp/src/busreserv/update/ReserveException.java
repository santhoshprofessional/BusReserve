package busreserv.update;

//The ReserveException class represents a custom exception that is thrown when attempting to reserve a seat
//on a bus that has no available seats. This exception extends the standard Java Exception class.

public class ReserveException extends Exception {
 
 // Override the getMessage method to provide a specific error message for this exception.
 @Override
 public String getMessage() {
     return "Sorry, no available seats on this bus. Please choose another bus or try again later.";
 }
}
