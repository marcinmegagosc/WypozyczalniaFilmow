package pl.gornik.model;

public class Admin {
    private String email;
    private String password;

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean verifyCredentials(String inputEmail, String inputPassword) {
        return this.email.equals(inputEmail) && this.password.equals(inputPassword);
    }
}
