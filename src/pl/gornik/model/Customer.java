package pl.gornik.model;

public class Customer {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

    public Customer(String email, String firstName, String password, String lastName, String phoneNumber) {
        this.email = email;
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (Email: " + email + ", Tel: " + phoneNumber + ")";
    }
}
