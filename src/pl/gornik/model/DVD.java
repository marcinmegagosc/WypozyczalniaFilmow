package pl.gornik.model;

public class DVD extends Movie {
    private String format;

    public DVD(String director, String genre, boolean isRented, int releaseYear, String title, String format) {
        super(director, genre, isRented, releaseYear, title);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "format='" + format + '\'' +
                '}';
    }

}
