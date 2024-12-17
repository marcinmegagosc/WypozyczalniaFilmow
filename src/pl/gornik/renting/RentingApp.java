package pl.gornik.renting;

import pl.gornik.model.Admin;
import pl.gornik.model.RentalService;
import pl.gornik.model.VHS;

import java.util.Scanner;

public class RentingApp {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("admin@rental.com","admin123");

    }
}