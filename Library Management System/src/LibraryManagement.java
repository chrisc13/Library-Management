import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class LibraryManagement {
    static Scanner sc = new Scanner(System.in);
    static Connection dbConnection = null;

    public static Cardholder signedInUser = null; //the card number of the user that is signed in
    public static boolean outOfStock = false;


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if (isConnectedToDb()) {
            boolean running = true;
            do {
                int input = welcomeScreen();

                switch (input) {
                    case 1:
                        signInScreen();
                        break;
                    case 2:
                        registerScreen();
                        break;
                    case 3:
                        System.out.println("Program ended.");
                        closeConnection();
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input.");
                        break;
                }
            } while (running);

        } else {
            System.exit(0);
        }

    }

    static boolean isConnectedToDb() {
        try {
            dbConnection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:8888/alex",
                            "alex", "");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        return true;
    }

    static void closeConnection() {
        try {
            dbConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int welcomeScreen() {
        System.out.println("\tWelcome to The Library.");
        System.out.println("(Please enter 1, 2 or 3 to select an option)");
        System.out.println("\n1. Sign in to your account");
        System.out.println("2. Register a new account");
        System.out.println("3. Quit program");

        String input = sc.nextLine();
        return Integer.parseInt(input);
    }

    static void menu() {
        System.out.println("\nWelcome back, " + signedInUser.getName() + " (Card no. " + signedInUser.getCardNumber() + ")\nWould you like to: ");
        boolean running = true;
        do {
            System.out.println("1. Search for a book");
            System.out.println("2. Search for a movie");
            System.out.println("3. Return a book");
            System.out.println("4. Return a movie");
            System.out.println("5. Delete your account");
            System.out.println("6. Logout");

            String inputstring = sc.nextLine();
            // sc.nextLine();
            try {
                int input = Integer.parseInt(inputstring);


                switch (input) {
                    case 1:
                        bookSearch();
                        break;
                    case 2:
                        movieSearch();
                        break;
                    case 3:
                        returnBook();
                        break;
                    case 4:
                        returnMovie();
                        break;
                    case 5:
                        if (deleteAccount())
                            running = false;
                        break;
                    case 6:
                        logout();
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }


        } while (running);


    }

    private static void logout() {
        signedInUser = null;
        System.out.println("Logged out");
    }

    static void signInScreen() {
        System.out.println("\n\tLog In");
        System.out.print("Enter your card number: ");
        long cardNumber = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter your pin: ");
        int pin = sc.nextInt();
        sc.nextLine();


        //make db call and handle response
        Cardholder cardHolder = dbSignIn(cardNumber, pin);
        if (cardHolder != null) {
            signedInUser = cardHolder;

            //show the main menu
            menu();
        } else {
            System.out.println("Invalid credentials.");
        }


    }

    static void registerScreen() {
        System.out.println("\n\n\tAccount Registration");
        System.out.print("Enter your full name: ");
        String name = sc.nextLine();

        if (!name.isEmpty()) {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            sc.nextLine();
            if (age != 0) {
                System.out.print("Enter a 4-digit numeric pin: ");
                int pin1 = sc.nextInt();
                sc.nextLine();
                if (String.valueOf(pin1).length() == 4) {
                    System.out.print("Re-enter your pin: ");
                    int pin2 = sc.nextInt();
                    sc.nextLine();
                    if (pin1 == pin2) {
                        //make the db call to register here
                        LocalDate date = LocalDate.now();
                        Card card = new Card(pin1, date);
                        Cardholder cardHolder = new Cardholder(name, age, card.getCardNumber());

                        if (dbRegister(card, cardHolder)) {
                            System.out.println("Registration successful! Your new library card number is " + card.getCardNumber() + ". Write this down for your records.");
                            menu();
                        } else {
                            System.out.println("Register FAIL. Returning to Welcome Screen.");
                        }


                    } else {
                        System.out.println("Pin does not match.");
                    }
                } else {
                    System.out.println("Pin length invlaid.");
                }
            }


        } else {
            System.out.println("You did not enter a name. Returning to Welcome Screen.");
        }
    }

    static boolean dbRegister(Card card, Cardholder cardHolder) {

        Statement stmt = null;
        try {
            //create query
            stmt = dbConnection.createStatement();
            //query to insert card
            String sql = "INSERT INTO Card (cardNumber, pin, issueDate)\n"
                    + "VALUES ('" + card.getCardNumber() + "', " + card.getPin() + ", '" + card.getDate() + "');";
            stmt.executeUpdate(sql);
            //query to insert cardholder
            sql = "INSERT INTO Cardholder (name, age, cardNumber)\n"
                    + "VALUES ('" + cardHolder.getName() + "', " + cardHolder.getAge() + ", '" + cardHolder.getCardNumber() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            signedInUser = cardHolder;
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }

        return true;
    }

    static Cardholder dbSignIn(long cardNumber, int pin) {
        Cardholder cardHolder = null;
        Statement stmt = null;
        try {
            //create query
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cardHolderID, name, age FROM Cardholder "
                    + "NATURAL JOIN Card "
                    + "WHERE cardNumber = '" + cardNumber
                    + "' AND pin = '" + pin + "';");


            while (rs.next()) {
                String cardHolderID = rs.getString("cardHolderID");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                cardHolder = new Cardholder(cardHolderID, name, age, cardNumber);
                break;  //there should only be one result from the select query
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {

            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }

        return cardHolder;
    }

    static void returnBook() {
        List<Book> checkedOutBooks = checkedOutBooksDB();
        if (checkedOutBooks.size() == 0) {
            System.out.println("You do not currently have any books checked out.");
            return;
        }
        System.out.println("You currently have checked out the following books: ");

        for (int i = 0; i < checkedOutBooks.size(); i++) {
            Book book = checkedOutBooks.get(i);
            String title = book.getTitle();
            LocalDate checkOutDate = book.getCheckOutDate();
            LocalDate dueDate = book.getDueDate();
            System.out.println((i + 1) + ") " + title);
            System.out.print("\tChecked out on " + checkOutDate + "\tDue on " + dueDate + "\n");
        }

        System.out.println("Enter the number of the book you want to return, or 'q' if you want to go back.");
        String input = sc.nextLine();
        try {
            int toReturn = Integer.parseInt(input) - 1;
            //Added if statement, invalid input output message, returnBook() call, and removed returned book output as it repeats
            if (toReturn >= checkedOutBooks.size() || toReturn < 0) {
                System.out.println("Invalid input. You have only checked out " + checkedOutBooks.size() + " books.");
                returnBook();
            } else {
                Book book = checkedOutBooks.get(toReturn);
                dbReturnBook(book);

                // System.out.println("You have successfully returned " + book.getTitle() + ".");
            }

        } catch (NumberFormatException e) {
            //user did not enter a number and wants to go back, do nothing
        }
    }

    static void dbReturnBook(Book book) {
        Statement stmt = null;

        try {
            // create query
            stmt = dbConnection.createStatement();

            String sql = "UPDATE Book SET checkedOutBy = NULL, " +
                    "checkOutDate = NULL, dueDate = NULL WHERE " +
                    "bookID = '" + book.getBookID() + "';";
            stmt.executeUpdate(sql);
            stmt.close();

            System.out.println("You have successfully returned '" + book.getTitle() + "'.");
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    static void returnMovie() {
        List<Movie> checkedOutMovies = checkedOutMoviesDB();
        if (checkedOutMovies.size() == 0) {
            System.out.println("You do not currently have any movies checked out.");
            return;
        }
        System.out.println("You currently have checked out the following movies: ");

        for (int i = 0; i < checkedOutMovies.size(); i++) {
            Movie movie = checkedOutMovies.get(i);
            String title = movie.getTitle();
            LocalDate checkOutDate = movie.getCheckOutDate();
            LocalDate dueDate = movie.getDueDate();
            System.out.println((i + 1) + ") " + title);
            System.out.print("\tChecked out on " + checkOutDate + "\tDue on " + dueDate + "\n");
        }

        System.out.println("Enter the number of the movie you want to return, or 'q' if you want to go back.");
        String input = sc.nextLine();
        try {
            int toReturn = Integer.parseInt(input) - 1;
            //Added check if number is valid for a return. commented out message as it repeats
            if (toReturn >= checkedOutMovies.size() || toReturn < 0) {
                System.out.println("Invalid input. You have only checked out " + checkedOutMovies.size() + " movies.");
                returnMovie();
            } else {
                Movie movie = checkedOutMovies.get(toReturn);
                dbReturnMovie(movie);
            }


            // System.out.println("You have successfully returned " + movie.getTitle() + ".");
        } catch (NumberFormatException e) {
            //user did not enter a number and wants to go back, do nothing
        }
    }

    static void dbReturnMovie(Movie movie) {
        Statement stmt = null;

        try {
            // create query
            stmt = dbConnection.createStatement();

            String sql = "UPDATE Movie SET checkedOutBy = NULL, " +
                    "checkOutDate = NULL, dueDate = NULL WHERE " +
                    "movieID = '" + movie.getMovieID() + "';";
            stmt.executeUpdate(sql);
            stmt.close();

            System.out.println("You have successfully returned '" + movie.getTitle() + "'.");
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    static List<Book> checkedOutBooksDB() {
        Statement stmt = null;

        List<Book> books = new ArrayList<>();
        try {
            // create query
            stmt = dbConnection.createStatement();

            String sql = "SELECT bookID," +
                    "    title," +
                    "    checkOutDate," +
                    "    dueDate" +
                    " FROM Book" +
                    " WHERE checkedOutBy = '" + signedInUser.getCardNumber() + "';";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String bookID = rs.getString("bookID");
                String title = rs.getString("title");
                LocalDate checkOutDate = rs.getDate("checkOutDate").toLocalDate();
                LocalDate dueDate = rs.getDate("dueDate").toLocalDate();

                books.add(new Book(bookID, title, checkOutDate, dueDate));
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return books;
    }

    static List<Movie> checkedOutMoviesDB() {
        Statement stmt = null;

        List<Movie> movies = new ArrayList<>();
        try {
            // create query
            stmt = dbConnection.createStatement();

            String sql = "SELECT movieID," +
                    "    title," +
                    "    checkOutDate," +
                    "    dueDate" +
                    " FROM Movie" +
                    " WHERE checkedOutBy = '" + signedInUser.getCardNumber() + "';";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String movieID = rs.getString("movieID");
                String title = rs.getString("title");
                LocalDate checkOutDate = rs.getDate("checkOutDate").toLocalDate();
                LocalDate dueDate = rs.getDate("dueDate").toLocalDate();

                movies.add(new Movie(movieID, title, checkOutDate, dueDate));
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return movies;
    }

    static void movieSearch() {
        System.out.println("\nPlease select an option");
        System.out.println("\t1) Search by title");
        System.out.println("\t2) Search by genre");
        System.out.println("\t3) Go back");

        String choiceString = sc.nextLine();
        try {
            int choice = Integer.parseInt(choiceString);
            switch (choice) {
                case 1:
                    movieSearchByTitle();
                    break;
                case 2:
                    movieSearchByGenre();
                    break;
                case 3:
                    return;


                default:
                    System.out.println("Invalid input.");
                    movieSearch();
                    break;

            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            movieSearch();
        }
        // int choice = sc.nextInt();

        // sc.nextLine();

    }

    static void bookSearch() {
        System.out.println("\nPlease select an option");
        System.out.println("\t1) Search by title");
        System.out.println("\t2) Search by author");
        System.out.println("\t3) Search by genre");
        System.out.println("\t4) Search by ISBN-13");
        System.out.println("\t5) Go back");

        String choiceString = sc.nextLine();
        try {
            int choice = Integer.parseInt(choiceString);
            switch (choice) {
                case 1:
                    bookSearchByTitle();
                    break;
                case 2:
                    bookSearchByAuthor();
                    break;
                case 3:
                    bookSearchByGenre();
                    break;
                case 4:
                    bookSearchByISBN();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid input.");
                    bookSearch();
                    break;
            }


        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            bookSearch();
        }
        //int choice = sc.nextInt();
        //sc.nextLine();

    }

    static void bookSearchByTitle() {
        System.out.print("\nPlease enter a title to search: ");
        String searchTitle = sc.nextLine();

        //db call to find book by title
        HashMap<String, Books> books = dbBookSearch(1, searchTitle);

        if (books.isEmpty()) {
            System.out.println("No results found.");
            return;
        }

        HashMap<Integer, Book> displayOrder = generateBookDisplayOrder(books);

        checkoutBook(displayOrder);
    }

    static void bookSearchByAuthor() {
        System.out.print("\nPlease enter an author to search: ");
        String searchAuthor = sc.nextLine();

        //db call to find book by author
        HashMap<String, Books> books = dbBookSearch(2, searchAuthor);

        if (books.isEmpty()) {
            System.out.println("No results found.");
            return;
        }

        HashMap<Integer, Book> displayOrder = generateBookDisplayOrder(books);

        checkoutBook(displayOrder);
    }

    static void bookSearchByGenre() {
        System.out.print("\nPlease enter a genre to search: ");
        String searchGenre = sc.nextLine();

        //db call to find book by genre
        HashMap<String, Books> books = dbBookSearch(3, searchGenre);

        if (books.isEmpty()) {
            System.out.println("No results found.");
            return;
        }

        HashMap<Integer, Book> displayOrder = generateBookDisplayOrder(books);

        checkoutBook(displayOrder);
    }

    static void bookSearchByISBN() {
        System.out.print("\nPlease enter the ISBN to search: ");
        String searchISBN = sc.nextLine();

        //db call to find book by isbn
        HashMap<String, Books> books = dbBookSearch(4, searchISBN);

        if (books.isEmpty()) {
            System.out.println("No results found.");
            return;
        }

        HashMap<Integer, Book> displayOrder = generateBookDisplayOrder(books);

        checkoutBook(displayOrder);
    }

    static HashMap<String, Books> dbBookSearch(int searchType, String searchItem) {
        HashMap<String, Books> bookMap = new HashMap<>(); //string will be isbn###format
        Statement stmt = null;

        try {
            // create query
            stmt = dbConnection.createStatement();
            String sql = "";
            switch (searchType) {
                case 1:
                    sql = "SELECT * FROM Book "
                            + "WHERE title = '" + searchItem + "' "
                            + "OR title ILIKE '%" + searchItem + "%';";
                    break;
                case 2:
                    sql = "SELECT * FROM Book "
                            + "WHERE author = '" + searchItem + "' "
                            + "OR author ILIKE '%" + searchItem + "%';";
                    break;
                case 3:
                    sql = "SELECT * FROM Book " +
                            "NATURAL JOIN Genre " +
                            "WHERE type ILIKE '" + searchItem + "';";
                    break;
                case 4:
                    sql = "SELECT * FROM Book "
                            + "WHERE ISBN = '" + searchItem + "';";
                    break;
            }
            ResultSet rs = stmt.executeQuery(sql);

            // Fetch each row from the result set
            while (rs.next()) {
                String bookID = rs.getString("bookID");
                String title = rs.getString("title");
                java.sql.Date checkOutDate = rs.getDate("checkOutDate");
                java.sql.Date dueDate = rs.getDate("dueDate");
                LocalDate checkOutDate2 = (checkOutDate == null) ? null : checkOutDate.toLocalDate();
                LocalDate dueDate2 = (dueDate == null) ? null : dueDate.toLocalDate();
                String format = rs.getString("format");
                boolean isAdult = rs.getBoolean("isAdult");
                String readLevel = rs.getString("readLevel");
                String author = rs.getString("author");
                String ISBN = rs.getString("ISBN");
                long checkedOutBy = rs.getLong("checkedOutBy");
                String genreCode = rs.getString("genreCode");
                // Assuming you have a user object
                Book book = new Book(bookID, title, checkOutDate2, dueDate2, format, isAdult, readLevel, author,
                        ISBN, checkedOutBy, genreCode);

                String keyStr = ISBN + "###" + format;
                if (bookMap.containsKey(keyStr)) {
                    bookMap.get(keyStr).addBook();
                    if (checkOutDate != null)
                        bookMap.get(keyStr).addCheckedOut();
                } else {
                    bookMap.put(keyStr, new Books(book));
                    if (checkOutDate != null)
                        bookMap.get(keyStr).addCheckedOut();
                }
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }

        return bookMap;
    }

    static HashMap<Integer, Book> generateBookDisplayOrder(HashMap<String, Books> books) {
        HashMap<Integer, Book> displayOrder = new HashMap<>();

        int index = 1;
        for (Map.Entry<String, Books> entry : books.entrySet()) {
            Books copies = entry.getValue();
            Book book = copies.getBook();
            System.out.println("\nBook " + index + ":");
            book.printBook();
            int total = copies.getNumBooks();
            int checkedOut = copies.getNumCheckedOut();
            int available = total - checkedOut;
            System.out.println(available + " of " + total + " copies available.");

            displayOrder.put(index++, book);
        }

        return displayOrder;
    }

    static void checkoutBook(HashMap<Integer, Book> books) {
        if (!canCheckOut())
            return;

        System.out.println("Enter the number of the book you want to check out, or 'q' if you want to go back.");
        String input = sc.nextLine();
        try {

            int toCheckout = Integer.parseInt(input);
            //Added to check for invalid number of book to check out not sure how to loop this part of the list?
            if (toCheckout > books.size() || toCheckout <= 0) {
                System.out.println("Invalid input. You must select a book from the list.");

            } else {
                Book book = books.get(toCheckout);
                int userAge = signedInUser.getAge();
                boolean isAdult = book.getIsAdult();
                if (isAdult && userAge < 18) {
                    System.out.println("You must be at least 18 to check out " + book.getTitle());
                    return;
                }

                dbCheckoutBook(book);

                if (outOfStock == false) {
                    System.out.println("You have successfully checked out '" + book.getTitle() + "'.");
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DAY_OF_YEAR, 14); //add 14 days to the current day
                    java.util.Date date = calendar.getTime();
                    DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
                    System.out.println("It is due on " + dFormat.format(date) + "\n");
                } else {
                    outOfStock = false;
                }

            }

        } catch (NumberFormatException e) {
            //user did not enter a number and wants to go back, do nothing
        }
    }

    static void dbCheckoutBook(Book book) {
        Statement stmt = null;

        try {
            // create query
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book " +
                    "WHERE ISBN = '" + book.getISBN() +
                    "' AND FORMAT = '" + book.getFormat() +
                    "' AND checkedOutBy IS NULL;");

            String bookID = null;
            while (rs.next()) {
                bookID = rs.getString("bookID");
                break; //check out first available book
            }
            rs.close();

            if (bookID == null) {
                System.out.println("That book is not available to be checked out. Please search for another book.\n");
                outOfStock = true;
            } else {
                String sql = "UPDATE Book SET checkedOutBy = '" + signedInUser.getCardNumber() +
                        "', checkOutDate = NOW(), dueDate = NOW() + INTERVAL '2 week'" +
                        " WHERE bookID = '" + bookID + "';";
                stmt.executeUpdate(sql);
                stmt.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    static void movieSearchByTitle() {
        System.out.print("\nPlease enter a title to search: ");
        String searchTitle = sc.nextLine();

        //db call to find book by title
        HashMap<String, Movies> movies = dbMovieSearch(1, searchTitle);

        if (movies.isEmpty()) {
            System.out.println("No results found.");
            return;
        }

        HashMap<Integer, Movie> displayOrder = generateMovieDisplayOrder(movies);

        checkoutMovie(displayOrder);
    }

    static void movieSearchByGenre() {
        System.out.print("\nPlease enter a genre to search: ");
        String searchGenre = sc.nextLine();

        //db call to find book by title
        HashMap<String, Movies> movies = dbMovieSearch(2, searchGenre);

        if (movies.isEmpty()) {
            System.out.println("No results found.");
            return;
        }

        HashMap<Integer, Movie> displayOrder = generateMovieDisplayOrder(movies);

        checkoutMovie(displayOrder);
    }

    static HashMap<String, Movies> dbMovieSearch(int searchType, String searchItem) {
        HashMap<String, Movies> movieMap = new HashMap<>(); //string will be title###format
        Statement stmt = null;

        try {
            // create query
            stmt = dbConnection.createStatement();
            String sql = "";
            switch (searchType) {
                case 1:
                    sql = "SELECT * FROM Movie "
                            + "WHERE title = '" + searchItem + "' "
                            + "OR title ILIKE '%" + searchItem + "%';";
                    break;
                case 2:
                    sql = "SELECT * FROM Movie " +
                            "NATURAL JOIN Genre " +
                            "WHERE type ILIKE '" + searchItem + "';";
                    break;
            }
            ResultSet rs = stmt.executeQuery(sql);

            // Fetch each row from the result set
            while (rs.next()) {
                String movieID = rs.getString("movieID");
                String title = rs.getString("title");
                java.sql.Date checkOutDate = rs.getDate("checkOutDate");
                java.sql.Date dueDate = rs.getDate("dueDate");
                LocalDate checkOutDate2 = (checkOutDate == null) ? null : checkOutDate.toLocalDate();
                LocalDate dueDate2 = (dueDate == null) ? null : dueDate.toLocalDate();
                String format = rs.getString("format");
                boolean isAdult = rs.getBoolean("isAdult");
                int year = rs.getInt("year");
                String rating = rs.getString("rating");
                long checkedOutBy = rs.getLong("checkedOutBy");
                String genreCode = rs.getString("genreCode");
                // Assuming you have a user object
                Movie movie = new Movie(movieID, title, checkOutDate2, dueDate2, format, isAdult, year, rating, checkedOutBy, genreCode);

                String keyStr = title + "###" + format;
                if (movieMap.containsKey(keyStr)) {
                    movieMap.get(keyStr).addMovie();
                    if (checkOutDate != null)
                        movieMap.get(keyStr).addCheckedOut();
                } else {
                    movieMap.put(keyStr, new Movies(movie));
                    if (checkOutDate != null)
                        movieMap.get(keyStr).addCheckedOut();
                }
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }

        return movieMap;
    }

    static HashMap<Integer, Movie> generateMovieDisplayOrder(HashMap<String, Movies> movies) {
        HashMap<Integer, Movie> displayOrder = new HashMap<>();

        int index = 1;
        for (Map.Entry<String, Movies> entry : movies.entrySet()) {
            Movies copies = entry.getValue();
            Movie movie = copies.getMovie();
            System.out.println("\nMovie " + index + ":");
            movie.printMovie();
            int total = copies.getNumMovies();
            int checkedOut = copies.getNumCheckedOut();
            int available = total - checkedOut;
            System.out.println(available + " of " + total + " copies available.");

            displayOrder.put(index++, movie);
        }

        return displayOrder;
    }

    static void checkoutMovie(HashMap<Integer, Movie> movies) {
        if (!canCheckOut())
            return;

        System.out.println("Enter the number of the movie you want to check out, or 'q' if you want to go back.");
        String input = sc.nextLine();
        try {

            int toCheckout = Integer.parseInt(input);
            if (toCheckout > movies.size() || toCheckout <= 0) {
                System.out.println("Invalid input. You must select one of the movies from the list.");
            } else {
                Movie movie = movies.get(toCheckout);
                int userAge = signedInUser.getAge();
                String rating = movie.getRating();
                if ((rating.equals("R") || rating.equals("NC-17")) && userAge < 17) {
                    System.out.println("You must be at least 17 to check out " + movie.getTitle());
                    return;
                }

                dbCheckoutMovie(movie);
                if (outOfStock == false) {
                    System.out.println("You have successfully checked out '" + movie.getTitle() + "'.");
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DAY_OF_YEAR, 14); //add 14 days to the current day
                    java.util.Date date = calendar.getTime();
                    DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
                    System.out.println("It is due on " + dFormat.format(date) + "\n");
                } else {
                    outOfStock = false;
                }

            }

        } catch (NumberFormatException e) {
            //user did not enter a number and wants to go back, do nothing
        }
    }

    static void dbCheckoutMovie(Movie movie) {
        Statement stmt = null;

        try {
            // create query
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Movie " +
                    "WHERE title = '" + movie.getTitle() +
                    "' AND format = '" + movie.getFormat() +
                    "' AND checkedOutBy IS NULL;");

            String movieID = null;
            while (rs.next()) {
                movieID = rs.getString("movieID");
                break; //check out first available movie
            }
            rs.close();

            if (movieID == null) {
                System.out.println("That movie is not available to be checked out. Please search for another movie.\n");
                outOfStock = true;
            } else {
                String sql = "UPDATE Movie SET checkedOutBy = '" + signedInUser.getCardNumber() +
                        "', checkOutDate = NOW(), dueDate = NOW() + INTERVAL '2 week'" +
                        " WHERE movieID = '" + movieID + "';";
                stmt.executeUpdate(sql);
                stmt.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    static boolean canCheckOut() {
        boolean canCheckOut = true;

        System.out.println();
        if (exceededMaxCheckedOutItems()) {
            System.out.println("\nYou have currently checked out 15 total items. You must return at least one before you check out another.\n");
            canCheckOut = false;
        }
        List<Item> overdueTitles = getOverdueTitles();
        if (!overdueTitles.isEmpty()) {
            System.out.println("The following item(s) are overdue and must be returned before you can check out anymore.");
            for (Item item : overdueTitles) {
                System.out.println(item.getType() + ": " + item.getTitle());
            }
            canCheckOut = false;
        }
        System.out.println();

        return canCheckOut;
    }

    static boolean exceededMaxCheckedOutItems() {
        Statement stmt = null;
        int count = 0;

        try {
            long cardNum = signedInUser.getCardNumber();
            String sql = "SELECT " +
                    "(SELECT COUNT(*) " +
                    "FROM Book " +
                    "WHERE checkedOutBy = '" + cardNum + "') + " +
                    "(SELECT COUNT(*) " +
                    "FROM Movie " +
                    "WHERE checkedOutBy = '" + cardNum + "') AS totalCheckedOut;";

            // create query
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                count = rs.getInt("totalCheckedOut");
                break; //there should only be one row
            }
            rs.close();

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return (count >= 15);
    }

    static List<Item> getOverdueTitles() {
        Statement stmt = null;
        int count = 0;

        List<Item> overdueItems = new ArrayList<>();
        try {
            long cardNum = signedInUser.getCardNumber();
            String sql = "SELECT title," +
                    "    'Book' AS itemType " +
                    "FROM Book " +
                    "WHERE checkedOutBy = '" + cardNum + "' " +
                    "AND dueDate <= CURRENT_DATE - 1 " +
                    "UNION " +
                    "SELECT title, " +
                    "    'Movie' AS itemType " +
                    "FROM Movie " +
                    "WHERE checkedOutBy = '" + cardNum + "' " +
                    "AND dueDate <= CURRENT_DATE - 1 " +
                    "ORDER BY itemType ASC, title ASC;";

            // create query
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String title = rs.getString("title");
                String type = rs.getString("itemType");
                Item item = new Item(title, type);
                overdueItems.add(item);
            }
            rs.close();

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return overdueItems;
    }

    static boolean deleteAccount() {
        boolean deleted = false;

        System.out.println("Are you sure you want to delete your account? This cannot be undone.");
        System.out.println("\t1. Yes");
        System.out.println("\t2. No");
        String input = sc.nextLine();
        try {
            int choice = Integer.parseInt(input);
            if (choice == 1) {
                if (deleteAccountDB()) {
                    System.out.println("Your account has been deleted and all items have been returned.");
                    signedInUser = null;
                    deleted = true;
                } else {
                    System.out.println("Something went wrong. Your account has not been deleted. Try again later.");
                }
            }
        } catch (Exception e) {
            //return to menu
        }

        return deleted;
    }

    static boolean deleteAccountDB() {
        Statement stmt = null;
        boolean deleted = false;
        try {
            stmt = dbConnection.createStatement();

            long cardNum = signedInUser.getCardNumber();
            String sql = "UPDATE Book SET checkedOutBy = NULL, " +
                    "checkOutDate = NULL, dueDate = NULL WHERE " +
                    "checkedOutBy = '" + cardNum + "';";
            stmt.executeUpdate(sql);

            sql = "UPDATE Movie SET checkedOutBy = NULL, " +
                    "checkOutDate = NULL, dueDate = NULL WHERE " +
                    "checkedOutBy = '" + cardNum + "';";
            stmt.executeUpdate(sql);

            sql = "DELETE FROM Card WHERE cardNumber= '" + cardNum + "';";
            stmt.executeUpdate(sql);

            stmt.close();

            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return deleted;
    }
}