package pl.gornik.model;

public class DVD {
    private String title;
    private boolean isRented;

    public DVD(String title) {
        this.title = title;
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
            System.out.println("DVD wypożyczone: " + title);
        } else {
            System.out.println("DVD zostało już przez kogoś wypożyczone: " + title);
        }
    }

    public void returnDVD() {
        if (isRented) {
            isRented = false;
            System.out.println("DVD zwrócone: " + title);
        } else {
            System.out.println("DVD nie było jeszcze wypożyczone: " + title);
        }
    }

    @Override
    public String toString() {
        return "DVD: " + title + (isRented ? " [RENTED]" : " [AVAILABLE]");
    }
}