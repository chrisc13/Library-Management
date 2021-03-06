import java.time.LocalDate;

public class Book {
	
	//bookID
	private String bookID;
	private String title;
	private LocalDate checkOutDate;
	private LocalDate dueDate;
	private String format;
	private Boolean isAdult;
	private String readLevel;
	private String author;
	private String ISBN;
	private long checkedOutBy;
	private String genreCode;
	
	public Book(String bookID, String title, LocalDate checkOutDate, LocalDate dueDate){
	    this.bookID = bookID;
	    this.title = title;
	    this.checkOutDate = checkOutDate;
	    this.dueDate = dueDate;
    }

	public Book(String bookID, String title, LocalDate checkOutDate, LocalDate dueDate, String format, Boolean isAdult, String readLevel, String author, String ISBN, long checkedOutBy, String genreCode)
	{
		this.bookID = bookID;
		this.title = title;
		this.checkOutDate = checkOutDate;
		this.dueDate = dueDate;
		this.format = format;
		this.isAdult = isAdult;
		this.readLevel = readLevel;
		this.author = author;
		this.ISBN = ISBN;
		this.checkedOutBy = checkedOutBy;
		this.genreCode = genreCode;
	}

	public String getBookID() {
		return this.bookID;
	}
	
	public String getTitle() {
        return title;
    }
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public String getFormat() {
        return format;
    }
    public Boolean getIsAdult() {
        return isAdult;
    }
    public String getReadLevel() {
        return readLevel;
    }
    public String getAuthor(){
        return author;
    }
    public String getISBN() {
        return ISBN;
    }
    public long getCheckedOutBy() {
        return checkedOutBy;
    }
    public String getGenreCode() {
        return genreCode;
    }
    public void setDueDate(LocalDate newDueDate) {
        dueDate = newDueDate;
    }
    public void setCheckOutDate(LocalDate newCheckOutDate) {
        checkOutDate = newCheckOutDate;
    }
    public void setCheckedOutBy(long newCheckedOutBy) {
        checkedOutBy = newCheckedOutBy;
    }
    
    public void printBook() {
    	System.out.println("Title: "+this.title);
    	System.out.println("Author: "+this.author);
    	System.out.println("Format: "+this.format);
    	System.out.println("Adult: "+this.isAdult);
    	System.out.println("Reading Level: "+this.readLevel);
    	System.out.println("ISBN: "+this.ISBN);
    }

}

/*
 bookID UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
 title text,
 checkOutDate date,
 dueDate date,
 format varchar(50),
 isAdult boolean,
 readLevel varchar(2),
 author text,
 ISBN varchar(17),
 checkedOutBy varchar(12),
 genreCode varchar(3),
 FOREIGN KEY(checkedOutBy) REFERENCES Card(cardNumber) ON DELETE CASCADE,
 FOREIGN KEY(genreCode) REFERENCES Genre
 */
