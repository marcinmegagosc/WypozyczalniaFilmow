package pl.gornik.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private List<Movie> movies = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();

    private static final double DAILY_RATE = 5.0;
    private static final double LATE_FEE = 10.0;

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public boolean removeMovieByTitle(String title) {
        return movies.removeIf(movie -> movie.getTitle().equalsIgnoreCase(title));
    }

    public void listMovies() {
        if (movies.isEmpty()) {
            System.out.println("Brak dostępnych filmów");
            return;
        }
        System.out.println("\n=== LISTA FILMÓW ===");
        movies.forEach(System.out::println);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomerByEmail(String email) {
        return customers.stream()
                .filter(c -> c.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public Movie findMovieByTitle(String title) {
        return movies.stream()
                .filter(m -> m.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public void rentMovie(Customer customer, Movie movie, int rentalDays) {
        if (!movie.isRented()) {
            movie.rent();
            Rental rental = new Rental(customer, movie,
                    LocalDate.now(),
                    LocalDate.now().plusDays(rentalDays));
            rentals.add(rental);
            System.out.println("Opłata za wypożyczenie: " +
                    calculateInitialRentalFee(rental) + " PLN");
        } else {
            System.out.println("Film jest już wypożyczony: " + movie.getTitle());
        }
    }

    public void returnMovie(Movie movie) {
        movie.returnMovie();
        Rental rental = findRentalByMovie(movie);
        if (rental != null) {
            double totalFee = calculateTotalFee(rental);
            rentals.remove(rental);
            System.out.println("Całkowita opłata: " + totalFee + " PLN");
        }
    }

    private Rental findRentalByMovie(Movie movie) {
        return rentals.stream()
                .filter(r -> r.getMovie().equals(movie))
                .findFirst()
                .orElse(null);
    }

    private double calculateInitialRentalFee(Rental rental) {
        return DAILY_RATE * ChronoUnit.DAYS.between(
                rental.getRentalDate(),
                rental.getReturnDate()
        );
    }

    private double calculateTotalFee(Rental rental) {
        LocalDate today = LocalDate.now();
        double baseFee = calculateInitialRentalFee(rental);

        if (today.isAfter(rental.getReturnDate())) {
            long daysLate = ChronoUnit.DAYS.between(rental.getReturnDate(), today);
            double lateFee = LATE_FEE * daysLate;
            System.out.println("Naliczono karę za spóźnienie (" + daysLate +
                    " dni): " + lateFee + " PLN");
            return baseFee + lateFee;
        }

        return baseFee;
    }

    public void listRentals() {
        if (rentals.isEmpty()) {
            System.out.println("Brak aktywnych wypożyczeń");
            return;
        }
        System.out.println("\n=== AKTYWNE WYPOŻYCZENIA ===");
        rentals.forEach(rental -> {
            System.out.println(rental);
            System.out.println("Aktualna opłata: " +
                    calculateTotalFee(rental) + " PLN");
        });
    }
}