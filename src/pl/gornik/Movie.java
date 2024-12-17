package pl.gornik;

public class Movie {
    private String title;
    private String director;
    private int releaseYear;
    private String genre;
    private boolean isRented;

    public Movie(String director, String genre, boolean isRented, int releaseYear, String title) {
        this.director = director;
        this.genre = genre;
        this.isRented = isRented;
        this.releaseYear = releaseYear;
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "director='" + director + '\'' +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", isRented=" + isRented +
                '}';
    }
}

