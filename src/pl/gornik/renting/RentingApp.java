package pl.gornik.renting;

import pl.gornik.model.*;
import pl.gornik.model.Validator;
import java.util.Scanner;

public class RentingApp {
    private static void initializeMovies(RentalService rentalService) {

        rentalService.addMovie(new DVD("Inception", "Christopher Nolan", 2010, "Sci-Fi"));
        rentalService.addMovie(new DVD("Pulp Fiction", "Quentin Tarantino", 1994, "Crime"));
        rentalService.addMovie(new DVD("Matrix", "Wachowski Sisters", 1999, "Sci-Fi"));
        rentalService.addMovie(new DVD("Shrek", "Andrew Adamson", 2001, "Animacja"));
        rentalService.addMovie(new DVD("Władca Pierścieni", "Peter Jackson", 2001, "Fantasy"));
        rentalService.addMovie(new DVD("Zielona Mila", "Frank Darabont", 1999, "Dramat"));
        rentalService.addMovie(new DVD("Forrest Gump", "Robert Zemeckis", 1994, "Dramat"));
        rentalService.addMovie(new DVD("Skazani na Shawshank", "Frank Darabont", 1994, "Dramat"));
        rentalService.addMovie(new DVD("Gladiator", "Ridley Scott", 2000, "Akcja"));
        rentalService.addMovie(new DVD("Titanic", "James Cameron", 1997, "Dramat"));


        rentalService.addMovie(new VHS("E.T.", "Steven Spielberg", 1982, "Sci-Fi"));
        rentalService.addMovie(new VHS("Rambo", "Ted Kotcheff", 1982, "Akcja"));
        rentalService.addMovie(new VHS("Terminator", "James Cameron", 1984, "Sci-Fi"));
        rentalService.addMovie(new VHS("Obcy", "Ridley Scott", 1979, "Horror"));
        rentalService.addMovie(new VHS("Indiana Jones", "Steven Spielberg", 1981, "Przygodowy"));
        rentalService.addMovie(new VHS("Szczęki", "Steven Spielberg", 1975, "Horror"));
        rentalService.addMovie(new VHS("Rocky", "John G. Avildsen", 1976, "Dramat"));
        rentalService.addMovie(new VHS("Gwiezdne Wojny", "George Lucas", 1977, "Sci-Fi"));
        rentalService.addMovie(new VHS("Top Gun", "Tony Scott", 1986, "Akcja"));
        rentalService.addMovie(new VHS("Powrót do przyszłości", "Robert Zemeckis", 1985, "Sci-Fi"));
    }

    private static boolean validateAndAddCustomer(Scanner scanner, RentalService rentalService) {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (!Validator.isValidEmail(email)) {
            System.out.println("Nieprawidłowy format email!");
            return false;
        }

        if (rentalService.findCustomerByEmail(email) != null) {
            System.out.println("Użytkownik o tym emailu już istnieje!");
            return false;
        }

        System.out.print("Hasło (min. 8 znaków): ");
        String password = scanner.nextLine();
        if (!Validator.isValidPassword(password)) {
            System.out.println("Hasło musi mieć minimum 8 znaków!");
            return false;
        }

        System.out.print("Imię: ");
        String firstName = scanner.nextLine();

        System.out.print("Nazwisko: ");
        String lastName = scanner.nextLine();

        System.out.print("Telefon (9 cyfr): ");
        String phone = scanner.nextLine();
        if (!Validator.isValidPhone(phone)) {
            System.out.println("Nieprawidłowy format numeru telefonu!");
            return false;
        }

        Customer newCustomer = new Customer(email, firstName, password, lastName, phone);
        rentalService.addCustomer(newCustomer);
        System.out.println("Użytkownik został dodany!");
        return true;
    }

    public static void main(String[] args) {
        RentalService rentalService = new RentalService();
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("admin@rental.com", "admin123");

        initializeMovies(rentalService);

        boolean running = true;
        while (running) {
            System.out.println("\n=== WYPOŻYCZALNIA FILMÓW ===");
            System.out.println("1. Przeglądnij filmy");
            System.out.println("2. Dodaj użytkownika");
            System.out.println("3. Wypożycz film");
            System.out.println("4. Zwróć film");
            System.out.println("5. Panel administratora");
            System.out.println("6. Wyjście");
            System.out.print("Wybierz opcję: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    rentalService.listMovies();
                    break;

                case 2:
                    System.out.println("\n=== REJESTRACJA UŻYTKOWNIKA ===");
                    validateAndAddCustomer(scanner, rentalService);
                    break;

                case 3:
                    System.out.println("\n=== WYPOŻYCZANIE FILMU ===");
                    System.out.print("Email: ");
                    String rentEmail = scanner.nextLine();
                    System.out.print("Hasło: ");
                    String rentPassword = scanner.nextLine();

                    Customer customer = rentalService.findCustomerByEmail(rentEmail);
                    if (customer != null && customer.getPassword().equals(rentPassword)) {
                        rentalService.listMovies();
                        System.out.print("Podaj tytuł filmu do wypożyczenia: ");
                        String movieTitle = scanner.nextLine();
                        Movie movieToRent = rentalService.findMovieByTitle(movieTitle);

                        if (movieToRent != null && !movieToRent.isRented()) {
                            System.out.print("Na ile dni chcesz wypożyczyć film? ");
                            int days = scanner.nextInt();
                            rentalService.rentMovie(customer, movieToRent, days);
                        } else if (movieToRent == null) {
                            System.out.println("Film nie znaleziony.");
                        } else {
                            System.out.println("Film jest już wypożyczony.");
                        }
                    } else {
                        System.out.println("Nieprawidłowe dane logowania.");
                    }
                    break;

                case 4:
                    System.out.println("\n=== ZWROT FILMU ===");
                    System.out.print("Email: ");
                    String returnEmail = scanner.nextLine();
                    System.out.print("Hasło: ");
                    String returnPassword = scanner.nextLine();

                    Customer returningCustomer = rentalService.findCustomerByEmail(returnEmail);
                    if (returningCustomer != null && returningCustomer.getPassword().equals(returnPassword)) {
                        rentalService.listRentals();
                        System.out.print("Podaj tytuł filmu do zwrotu: ");
                        String returnTitle = scanner.nextLine();
                        Movie movieToReturn = rentalService.findMovieByTitle(returnTitle);

                        if (movieToReturn != null && movieToReturn.isRented()) {
                            rentalService.returnMovie(movieToReturn);
                        } else if (movieToReturn == null) {
                            System.out.println("Film nie znaleziony.");
                        } else {
                            System.out.println("Ten film nie jest wypożyczony.");
                        }
                    } else {
                        System.out.println("Nieprawidłowe dane logowania.");
                    }
                    break;

                case 5:
                    System.out.println("\n=== LOGOWANIE ADMINISTRATORA ===");
                    System.out.print("Email: ");
                    String adminEmail = scanner.nextLine();
                    System.out.print("Hasło: ");
                    String adminPassword = scanner.nextLine();

                    if (admin.verifyCredentials(adminEmail, adminPassword)) {
                        boolean adminSession = true;
                        while (adminSession) {
                            System.out.println("\n=== PANEL ADMINISTRATORA ===");
                            System.out.println("A. Dodaj film");
                            System.out.println("B. Usuń film");
                            System.out.println("C. Wypisz filmy");
                            System.out.println("D. Wyloguj");
                            System.out.print("Wybierz opcję: ");
                            String adminChoice = scanner.nextLine().toUpperCase();

                            switch (adminChoice) {
                                case "A":
                                    System.out.println("\n=== DODAWANIE FILMU ===");
                                    System.out.print("Tytuł: ");
                                    String title = scanner.nextLine();
                                    System.out.print("Reżyser: ");
                                    String director = scanner.nextLine();
                                    System.out.print("Rok wydania: ");
                                    int year = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Gatunek: ");
                                    String genre = scanner.nextLine();
                                    System.out.print("Typ (DVD/VHS): ");
                                    String type = scanner.nextLine().toUpperCase();

                                    Movie newMovie;
                                    if (type.equals("DVD")) {
                                        newMovie = new DVD(title, director, year, genre);
                                    } else {
                                        newMovie = new VHS(title, director, year, genre);
                                    }
                                    rentalService.addMovie(newMovie);
                                    System.out.println("Film został dodany!");
                                    break;

                                case "B":
                                    System.out.println("\n=== USUWANIE FILMU ===");
                                    System.out.print("Podaj tytuł filmu do usunięcia: ");
                                    String titleToRemove = scanner.nextLine();
                                    if (rentalService.removeMovieByTitle(titleToRemove)) {
                                        System.out.println("Film został usunięty!");
                                    } else {
                                        System.out.println("Film nie znaleziony.");
                                    }
                                    break;

                                case "C":
                                    rentalService.listMovies();
                                    break;

                                case "D":
                                    adminSession = false;
                                    break;

                                default:
                                    System.out.println("Nieprawidłowa opcja.");
                            }
                        }
                    } else {
                        System.out.println("Nieprawidłowe dane logowania administratora.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Do widzenia!");
                    break;

                default:
                    System.out.println("Nieprawidłowa opcja.");
            }
        }
        scanner.close();
    }
}