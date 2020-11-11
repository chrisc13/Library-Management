import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class LibraryManagement {
	static Scanner sc = new Scanner(System.in);
	static Connection dbConnection = null;
	
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
					running = false;
					break;
				default:
					System.out.println("Invalid input.");
					break;
				}
			} while (running);

		}else {
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
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return false;
        }
        return true;
	}
	
	
    static int welcomeScreen(){
        System.out.println("\tWelcome to The Library.");
        System.out.println("(Please enter 1, 2 or 3 to select an option)");
        System.out.println("\n1. Sign in to your account");
        System.out.println("2. Register a new account");
        System.out.println("3. Quit program");
        
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }
    
    static void menu(String name){
    	System.out.println("\nWelcome back " +name +", would you like to: ");
    	boolean running = true;
    	do {
    		 System.out.println("1. Search for a book");
    	     System.out.println("2. Search for a movie");
    	     System.out.println("3. View your checked out items");
    	     System.out.println("4. Return an item");
    	     System.out.println("5. Logout");	
    		
    		int input = sc.nextInt();
    		
    		switch (input) {
    		case 1:
    			bookSearch();
    			break;
    		case 2:
    			movieSearch();
    			break;
    		case 3:
    			checkedOut();
    			break;
    		case 4:
    			returnItem();
    			break;
    		case 5: 
    			logout();
    			running = false;
    			break;
    		default:
    			System.out.println("Invalid input.");
    			break;
    		}
    		
    	}while(running);
    	
 
    }
    
    private static void logout() {
		// TODO Auto-generated method stub
    	
    	try {
    		dbConnection.close();
			System.out.println("Logged out");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	static void signInScreen(){
    	System.out.println("\tSign In Screen.");
        System.out.println("\nEnter your card number: ");
        String cardNumber = sc.nextLine();
        System.out.print("Enter your pin: ");
        int pin = sc.nextInt();
        
        
        //make db call and handle response
        Cardholder cardHolder = dbSignIn(cardNumber, pin);
        if (cardHolder != null) {
            String name = cardHolder.getName();
            
            //show the main menu
            menu(name);
        }else {
        	System.out.println("Invalid credentials.");
        }
        

    }

    static void registerScreen(){
    	System.out.println("\tRegister Screen.");
        System.out.print("\nEnter your full name: ");
        String name = sc.nextLine();
       
        if (!name.isEmpty()) {
        	 System.out.print("Enter your age: ");
             int age = sc.nextInt();
             if (age != 0) {
                 System.out.print("Enter a 4-digit numeric pin: ");
                 String pinString = sc.nextLine();
                if (pinString.length() > 3) {
                	System.out.println("Re-enter your pin: ");
                	String confirmPin = sc.nextLine();
                	if (pinString.equals(confirmPin)) {
                		//make the db call to register here 
                		String cardNumber = generateID();
                		String cardHolderID = generateID();
                		LocalDate date = LocalDate.now();
                		int pinInt = Integer.parseInt(pinString);
                		Card card = new Card(cardNumber, pinInt, date);
                		Cardholder cardHolder = new Cardholder(cardHolderID, name, age, cardNumber);
                		
                		if (dbRegister(card, cardHolder)) {
                			System.out.println("Register SUCCESS. Returning to Welcome Screen.");
                		}else {
                			System.out.println("Register FAIL. Returning to Welcome Screen.");
                		}
                		
                		
                	}else {
                		System.out.println("Pin does not match.");
                	}
                }else {
                	System.out.println("Pin length invlaid.");
                }
             }
            
       
        }else {
        	System.out.println("Empty name kid. Returning to Welcome Screen.");
        }
        

    }
    
 
	static String generateID() {
    	UUID uuid = UUID.randomUUID();
		return uuid.toString();
    }

    
    static boolean dbRegister(Card card, Cardholder cardHolder) {
    	
        Statement stmt = null;
        try {
            //create query
            stmt = dbConnection.createStatement();
            //query to insert card
            String sql = "INSERT INTO Card (cardNumber, pin, issueDate)\n"
            		+ "VALUES ("+card.getCardNumber() +", " +card.getPin() +", "+card.getDate()+");";
            stmt.executeUpdate(sql);
            //query to insert cardholder
            sql = "INSERT INTO Cardholder (name, age, cardNumber)\n"
            		+ "VALUES (" +cardHolder.getName() +", " +cardHolder.getAge() +", " +cardHolder.getCardNumber()+");"; 
            stmt.executeUpdate(sql);
            stmt.close();
           
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return false;
        }
        
        return true;
    	
    }

    static Cardholder dbSignIn(String cardNumber, int pin) {
    	Cardholder cardHolder = null;
        Statement stmt = null;
        try {
            //create query
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Cardholder\n"
            		+ "NATURAL JOIN Card\n"
            		+ "WHERE Card.cardNumber = "+cardNumber
            		+ "AND pin = " +pin +";" );
            
            
            if ( rs.first() ) {
            	//String cardHolderID = rs.getString("");
            	String name = rs.getString("name");
            	int age = rs.getInt("age");
            	cardNumber = rs.getString("cardNumber");
            	
            	cardHolder = new Cardholder(null, name, age, cardNumber);  
            	
            }
            rs.close();
            stmt.close();
            
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return null;
        }
        
        return cardHolder;
    }
    
  
	static void returnItem(){
//        System.out.println("You currently have checked out the following: ");
//        System.out.println("\tChecked out on 9/1/20\tDue on 9/15/10");
//        System.out.println("\tChecked out on 9/7/20\tDue on 9/21/10");
//        System.out.println("Enter the number of the item you want to return or enter 0 to go back");
//        sc.nextLine();
//        System.out.println("You are trying to return Inception. Type Y to confirm or N to cancel");
//        sc.nextLine();
//        System.out.println("You have successfully returned Inception\n");
//        sc.nextLine();
//        System.out.println("You currently have checked out the following: ");
//        System.out.println("\tChecked out on 9/1/20\tDue on 9/15/10");
//        System.out.println("\tChecked out on 9/7/20\tDue on 9/21/10");
//        System.out.println("Enter the number of the item you want to return or enter 0 to go back");
        sc.nextLine();
    }

    static void checkedOut(){
//        System.out.println("You currently have checked out the following: ");
//        System.out.println("\tChecked out on 9/1/20\tDue on 9/15/10");
//        System.out.println("\tChecked out on 9/7/20\tDue on 9/21/10");
//        System.out.println("Press any key to go back");
        sc.nextLine();
    }


    static void movieSearch(){
        System.out.println("Please select an option");
        System.out.println("\t1) Search by title");
        System.out.println("\t2) Search by genre");
        System.out.println("\t3) Go back");
        int choice = sc.nextInt();
        switch (choice) {
    	case 1: 
    		movieSearchByTitle();
    		break;
    	case 2: 
    		movieSearchByGenre();
    		break;
    	case 3:
    		return;
    	
        }
    }


    static void bookSearch(){
        System.out.println("Please select an option");
        System.out.println("\t1) Search by title");
        System.out.println("\t2) Search by author");
        System.out.println("\t3) Search by genre");
        System.out.println("\t4) Search by ISBN");
        System.out.println("\t5) Go back");
        int choice  = sc.nextInt();
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
        	
        }
        
    }

    static void bookSearchByTitle()
    {
    	System.out.print("\tPlease enter book title: ");
    	String searchTitle = sc.nextLine();
    	
    	//db call to find book by title
    	List<Book> books = dbBookSearchByTitle(searchTitle);
    	for (Book book : books) {
    		book.printBook();
    	}
    }
    
	static List<Book> dbBookSearchByTitle(String searchTitle) {
		List<Book> books = new ArrayList<>();
		Statement stmt = null;
		try {
			// create query
			stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Book \n"
					+ "WHERE title = "+searchTitle + " "
					+ "OR title ILIKE %" + searchTitle + "%;");

			// Fetch each row from the result set
			while (rs.next()) {
				String bookID = rs.getString("bookID");
				String title = rs.getString("title");
				Date checkOutDate = rs.getDate("checkOutDate");
				Date dueDate = rs.getDate("dueDate");
				LocalDate checkOutDate2 = checkOutDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate dueDate2 = dueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				String format = rs.getString("format");
				boolean isAdult = rs.getBoolean("isAdult");
				String readLevel = rs.getString("readLevel");
				String author = rs.getString("author");
				String ISBN = rs.getString("ISBN");
				String checkedOutBy = rs.getString("checkedOutBy");
				String genreCode = rs.getString("genreCode");
				// Assuming you have a user object
				Book book = new Book(bookID, title, checkOutDate2, dueDate2, format, isAdult, readLevel, author,
						ISBN, checkedOutBy, genreCode);

				books.add(book);
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}

		return books;
	}
    
    static void bookSearchByAuthor()
    {
    	System.out.print("\tPlease enter book author: ");
    	String author = sc.nextLine();
    	
    	//db call to find book by author
    }
    
    static void bookSearchByGenre()
    {
    	System.out.print("\tPlease enter book genre: ");
    	String genre = sc.nextLine();
    	
    	//db call to find book by genre
    }
    
    static void bookSearchByISBN()
    {
    	System.out.print("\tPlease enter book ISBN: ");
    	String isbn = sc.nextLine();
    	
    	//db call to find book by isbn
    }
    
    static void movieSearchByTitle()
    {
    	System.out.print("\tPlease enter movie title: ");
    	String title = sc.nextLine();
    	
    	//db call to find movie by title
    }
    
    static void movieSearchByGenre()
    {
    	System.out.print("\tPlease enter movie genre: ");
    	String genre = sc.nextLine();
    	
    	//db call to find book by genre
    }


//  static void harryPotter(){
//  System.out.println("Search results for title \"Harry Potter\"");
//  System.out.println("Enter the number before the title to checkout a book");
//  System.out.println("\tAuthor: JK Rowling\t ISBN: 123482901-5782");
//  System.out.println("\tGenre: Fantasy");
//  System.out.println("\tReading Level: Children's Book");
//  System.out.println("\tFormat: Paperback");
//  System.out.println("\tAvailable: 1 of 12");
//  System.out.println("\n\t2: Harry Potter and the Chamber of Secrets");
//  System.out.println("\tAuthor: JK Rowling\t ISBN: 123482901-1293");
//  System.out.println("\tGenre: Fantasy");
//  System.out.println("\tReading Level: Children's Book");
//  System.out.println("\tFormat: Paperback");
//  System.out.println("\tAvailable: 3 of 12");
//  System.out.println("\n\t3: Harry Potter and the Prisoner of Azkaban");
//  System.out.println("\tAuthor: JK Rowling\t ISBN: 123482901-8912");
//  System.out.println("\tGenre: Fantasy");
//  System.out.println("\tReading Level: Children's Book");
//  System.out.println("\tFormat: Paperback");
//  System.out.println("\tAvailable: 0 of 12");
//  sc.nextLine();
//  System.out.println("\n\nYou are trying to checkout Harry Potter and the Chamber of Secrets. Type Y to confirm or N to cancel");
//  sc.nextLine();
//  System.out.println("You have successfully checked out Harry Potter and the Chamber of Secrets!");
//}

    
//  static void inception(){
//  System.out.println("Search results for title \"Inception\"");
//  System.out.println("Enter the number before the title to checkout a book");
//  System.out.println("\t1: Inception");
//  System.out.println("\tGenre: Action\tReleased: 2010");
//  System.out.println("\tRating: PG-13");
//  System.out.println("\tFormat: DVD");
//  System.out.println("\tAvailable: 1 of 3");
//  sc.nextLine();
//  System.out.println("\n\nYou are trying to checkout Inception. Type Y to confirm or N to cancel");
//  sc.nextLine();
//  System.out.println("You have successfully checked out Inception!");
//}


}
