package pl.gornik.model;

public class Movie {
    private String title;       // Tytuł filmu
    private String director;    // Reżyser filmu
    private int year;           // Rok wydania filmu
    private String genre;       // Gatunek filmu
    private boolean isRented;   // Status wypożyczenia filmu


    public Movie(String title, String director, int year, String genre) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.isRented = false; // Domyślnie film jest dostępny
    }


    public String getTitle() {
        return title;
    }


    public boolean isRented() {
        return isRented;
    }


    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("Movie rented: " + title);
        } else {
            System.out.println("Movie is already rented: " + title);
        }
    }


    public void returnMovie() {
        if (isRented) {
            isRented = false;
            System.out.println("Movie returned: " + title);
        } else {
            System.out.println("Movie is not rented: " + title);
        }
    }

    // Reprezentacja tekstowa obiektu Movie
    @Override
    public String toString() {
        return title + " (" + year + ") - " + director + " | Genre: " + genre +
                (isRented ? " [RENTED]" : " [AVAILABLE]");
    }
}