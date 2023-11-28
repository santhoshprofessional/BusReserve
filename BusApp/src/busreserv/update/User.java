package busreserv.update;

class User {
    private String username;
    private String password;

    // Constructor to initialize a User object with the given username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter method to retrieve the username
    public String getUsername() {
        return username;
    }

    // Method to authenticate the user by comparing the entered password with the stored password
    //password must be safer one so it should not go outside class so only comparision inside a class
    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }
}