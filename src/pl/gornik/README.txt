
RentingApp to aplikacja służąca do zarządzania wypożyczalnią filmów. Umożliwia użytkownikom wypożyczanie i zwracanie filmów, zarządzanie kolekcją filmów przez administratora oraz obliczanie opłat za wypożyczenia.

 Spis Treści
- Wprowadzenie
- Struktura projektu
- Opis klas
  - Admin
  - Customer
  - Movie
  - DVD
  - VHS
  - Rental
  - RentalService
  - Validator
  - RentingApp

---

-Wprowadzenie

Aplikacja RentingApp pozwala użytkownikom rejestrować się, przeglądać dostępne filmy, wypożyczać je na określony czas oraz zwracać. Administrator ma możliwość dodawania i usuwania filmów z kolekcji oraz przeglądania listy aktywnych wypożyczeń.

---

-Struktura projektu

Pakiety:
- `pl.gornik.model` - zawiera klasy modelujące dane (filmy, użytkownicy, wypożyczenia itp.).
- `pl.gornik.renting` - zawiera główną klasę aplikacji.

---

- Opis klas

 1. `Admin`
Klasa reprezentująca administratora systemu.

 Pola:
- `email` - adres e-mail administratora.
- `password` - hasło administratora.

Metody:
- `Admin(String email, String password)` - Konstruktor inicjalizujący obiekt administratora.
- `verifyCredentials(String inputEmail, String inputPassword)` - Weryfikuje dane logowania administratora.

---

2. `Customer`
Klasa reprezentująca klienta wypożyczalni.

Pola:
- `firstName` - Imię klienta.
- `lastName` - Nazwisko klienta.
- `phoneNumber` - Numer telefonu klienta.
- `email` - Adres e-mail klienta.
- `password` - Hasło klienta.

Metody:
- `Customer(String email, String firstName, String password, String lastName, String phoneNumber)` - Konstruktor inicjalizujący obiekt klienta.
- `getEmail()` - Zwraca adres e-mail klienta.
- `getPassword()` - Zwraca hasło klienta.
- `toString()` - Zwraca szczegóły klienta w czytelnej formie.

---

3. `Movie`
Klasa bazowa dla filmów.

Pola:
- `title` - Tytuł filmu.
- `director` - Reżyser filmu.
- `year` - Rok wydania filmu.
- `genre` - Gatunek filmu.
- `isRented` - Informacja, czy film został wypożyczony.

Metody:
- `Movie(String title, String director, int year, String genre)` - Konstruktor inicjalizujący film.
- `getTitle()` - Zwraca tytuł filmu.
- `isRented()` - Sprawdza, czy film został wypożyczony.
- `rent()` - Oznacza film jako wypożyczony.
- `returnMovie()` - Oznacza film jako zwrócony.
- `toString()` - Zwraca szczegóły filmu.

---

4. `DVD`
Klasa rozszerzająca `Movie`, reprezentująca filmy w formacie DVD.

Metody:
- `DVD(String title, String director, int year, String genre)` - Konstruktor tworzący film DVD.
- `toString()` - Zwraca szczegóły filmu w formacie DVD.

---

5. `VHS`
Klasa rozszerzająca `Movie`, reprezentująca filmy w formacie VHS.

Metody:
- `VHS(String title, String director, int year, String genre)` - Konstruktor tworzący film VHS.
- `toString()` - Zwraca szczegóły filmu w formacie VHS.

---

6. `Rental`
Klasa reprezentująca wypożyczenie filmu przez klienta.

Pola:
- `customer` - Klient wypożyczający film.
- `movie` - Wypożyczony film.
- `rentalDate` - Data wypożyczenia.
- `returnDate` - Data zwrotu.

Metody:
- `Rental(Customer customer, Movie movie, LocalDate rentalDate, LocalDate returnDate)` - Konstruktor tworzący wypożyczenie.
- `getMovie()` - Zwraca wypożyczony film.
- `getRentalDate()` - Zwraca datę wypożyczenia.
- `getReturnDate()` - Zwraca datę zwrotu.
- `toString()` - Zwraca szczegóły wypożyczenia.

---

7. `RentalService`
Klasa zarządzająca logiką wypożyczalni.

Pola:
- `movies` - Lista dostępnych filmów.
- `customers` - Lista zarejestrowanych klientów.
- `rentals` - Lista aktywnych wypożyczeń.

Metody:
- `addMovie(Movie movie)` - Dodaje film do kolekcji.
- `removeMovieByTitle(String title)` - Usuwa film na podstawie tytułu.
- `listMovies()` - Wyświetla listę dostępnych filmów.
- `addCustomer(Customer customer)` - Dodaje klienta do systemu.
- `findCustomerByEmail(String email)` - Wyszukuje klienta po adresie e-mail.
- `findMovieByTitle(String title)` - Wyszukuje film po tytule.
- `rentMovie(Customer customer, Movie movie, int rentalDays)` - Wypożycza film klientowi.
- `returnMovie(Movie movie)` - Obsługuje zwrot filmu.
- `listRentals()` - Wyświetla listę aktywnych wypożyczeń.

---

8. `Validator`
Klasa odpowiedzialna za walidację danych.

Metody:
- `isValidEmail(String email)` - Sprawdza poprawność adresu e-mail.
- `isValidPassword(String password)` - Sprawdza poprawność hasła (min. 8 znaków).
- `isValidPhone(String phone)` - Sprawdza poprawność numeru telefonu (9 cyfr).

---

9. `RentingApp`

Główna klasa aplikacji zarządzająca interakcją z użytkownikiem.