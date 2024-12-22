package pl.gornik.model;

public class Movie {
    private String title;       
    private String director;    
    private int year;           
    private String genre;      
    private boolean isRented;   


    public Movie(String title, String director, int year, String genre) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.isRented = false; 
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
            System.out.println("Film wypożyczony: " + title);
        } else {
            System.out.println("Ktoś już wypożyczył ten film: " + title);
        }
    }


    public void returnMovie() {
        if (isRented) {
            isRented = false;
            System.out.println("Film zwrócony: " + title);
        } else {
            System.out.println("Film nie został wypożyczony: " + title);
        }
    }

    
    @Override
    public String toString() {
        return title + " (" + year + ") - " + director + " | Genre: " + genre +
                (isRented ? " [RENTED]" : " [AVAILABLE]");
    }
}
