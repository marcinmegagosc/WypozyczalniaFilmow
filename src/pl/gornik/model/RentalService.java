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

    public void addCustomer(Customer customer){
        customers.add(customer);
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



}
