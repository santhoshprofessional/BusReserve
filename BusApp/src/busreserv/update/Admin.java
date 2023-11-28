package busreserv.update;

//The Admin class represents an administrator with a username and password for authentication.

public class Admin {
 // Private fields to store the administrator's username and password.
 private String adminname;
 private String adpassword;

 // Constructor to initialize the Admin object with a username and password.
 public Admin(String adminname, String adpassword) {
     this.adminname = adminname;
     this.adpassword = adpassword;
 }

 // Getter method to retrieve the administrator's username.
 public String getAdminname() {
     return adminname;
 }

 // Setter method to update the administrator's username.
 public void setAdminname(String adminname) {
     this.adminname = adminname;
 }

 // Method to authenticate the administrator by comparing entered password with stored password.
 public boolean authenticate(String enteredPassword) {
     return adpassword.equals(enteredPassword);
 }
}
