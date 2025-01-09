package pl.gornik.model;

public class VHS extends Movie {
    public VHS(String title, String director, int year, String genre) {
        super(title, director, year, genre);
    }

    @Override
    public String toString() {
        return "VHS: " + super.toString();
    }
}