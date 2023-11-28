package busreserv.update;

//The CancelException class represents a custom exception that is thrown when attempting to cancel a seat
//that has not been reserved first. This exception extends the standard Java Exception class.

public class CancelException extends Exception {
 
 // Override the getMessage method to provide a specific error message for this exception.
 @Override
 public String getMessage() {
     return "Sorry, no seats are available to cancel. Please reserve a seat first and then proceed to cancel.";
 }
}
