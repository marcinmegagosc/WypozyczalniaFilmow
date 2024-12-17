package pl.gornik.model;

public class VHS {
    private String title;
    private boolean isRented;

    public VHS(String title) {
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
            System.out.println("Kaseta VHS została wypozyczone: " + title);
        } else {
            System.out.println("Ktoś już wypożyczył tą kasetę VHS: " + title);
        }
    }

    public void returnVHS() {
        if (isRented) {
            isRented = false;
            System.out.println("Kaseta VHS została zwrócona" + title);
        } else {
            System.out.println("Kaseta VHS nie była wypożyczona" + title);
        }
    }

    @Override
    public String toString() {
        return "VHS: " + title + (isRented ? " [RENTED]" : " [AVAILABLE]");
    }
}