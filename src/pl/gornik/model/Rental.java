package pl.gornik.model;

import java.time.LocalDate;

public class Rental {
    private Customer customer;
    private Movie movie;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    public Rental(Customer customer, Movie movie, LocalDate rentalDate, LocalDate returnDate) {
        this.customer = customer;
        this.movie = movie;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "Wypożyczenie: " + movie.getTitle() +
                " przez " + customer.toString() +
                " (Od: " + rentalDate + " Do: " + returnDate + ")";
    }
}