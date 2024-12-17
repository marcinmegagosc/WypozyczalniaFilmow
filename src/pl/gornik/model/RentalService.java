package pl.gornik.model;

import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private List<Movie> movies = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public boolean removeMovieByTitle(String title){
        for(Movie movie : movies){
            if(movie.getTitle().equalsIgnoreCase(title)){
                movies.remove(movie);
                return true;
            }
        }
        return false;
    }

   public void listMovies(){
        if(movies.isEmpty()){
            System.out.println("Niestety, brakuje filmów");
        }else{
            for(Movie movie: movies){
                System.out.println(movie);
            }
        }
   }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public Customer findCustomerByEmail(String email){
        for(Customer customer: customers){
            if(customer.getEmail().equalsIgnoreCase(email)){
                return customer;
            }
        }
        return null;
    }

    public Movie findMovieByTitle(String title){
        for(Movie movie: movies){
            if(movie.getTitle().equalsIgnoreCase(title)){
                return movie;
            }
        }
        return null;
    }

    public void rentMovie(Customer customer, Movie movie, int rentalDays) {
        if (!movie.isRented()) {
            movie.rent();
            Rental rental = new Rental(customer, movie, java.time.LocalDate.now(), java.time.LocalDate.now().plusDays(rentalDays));
            rentals.add(rental);
            System.out.println("Film został wypożyczony: " + movie.getTitle());
        } else {
            System.out.println("Ten film, został już przez kogoś wypożyczony " + movie.getTitle());
        }
    }

    public void returnMovie(Movie movie){
        movie.returnMovie();
        System.out.println("Film zwrócony: " + movie.getTitle());
    }

    public void listRentals(){
        if(rentals.isEmpty()){
            System.out.println("Nie ma obecnie żadnych wypożyczeń");
        }else{
            for(Rental rental: rentals){
                System.out.println(rental);
            }
        }
    }

}
