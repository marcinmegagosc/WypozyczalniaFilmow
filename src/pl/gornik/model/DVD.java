package pl.gornik.model;

public class DVD extends Movie {
    public DVD(String title, String director, int year, String genre) {
        super(title, director, year, genre);
    }

    @Override
    public String toString() {
        return "DVD: " + super.toString();
    }
}