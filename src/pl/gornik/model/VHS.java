package pl.gornik.model;

public class VHS extends Movie {
    private String standard;


    public VHS(String director, String genre, boolean isRented, int releaseYear, String title, String standard) {
        super(director, genre, isRented, releaseYear, title);
        this.standard = standard;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "VHS{" +
                "standard='" + standard + '\'' +
                '}';
    }

}
