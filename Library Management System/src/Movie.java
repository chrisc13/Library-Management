import java.time.LocalDate;

public class Movie {
	private String movieID;
	private String title;
	private LocalDate checkOutDate;
	private LocalDate dueDate;
	private String format;
	private boolean isAdult;
	private int year;
	private String rating;
	//fk to Card.cardNumber
	private long checkedOutBy;
	//fk to Genre
	private String genreCode;

	public Movie(String movieID, String title, LocalDate checkOutDate, LocalDate dueDate){
		this.movieID = movieID;
		this.title = title;
		this.checkOutDate = checkOutDate;
		this.dueDate = dueDate;
	}
	
	public Movie(String movieID, String title, LocalDate checkOutDate, LocalDate dueDate, String format, boolean isAdult,
			int year, String rating, long checkedOutBy, String genreCode) {
		this.movieID = movieID;
		this.title = title;
		this.checkOutDate = checkOutDate;
		this.dueDate = dueDate;
		this.format = format;
		this.isAdult = isAdult;
		this.year = year;
		this.rating = rating;
		this.checkedOutBy = checkedOutBy;
		this.genreCode = genreCode;
	}
	
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public boolean isAdult() {
		return isAdult;
	}
	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public long getCheckedOutBy() {
		return checkedOutBy;
	}
	public void setCheckedOutBy(long checkedOutBy) {
		this.checkedOutBy = checkedOutBy;
	}
	public String getGenreCode() {
		return genreCode;
	}
	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}
	
	public void printMovie(){
		System.out.println("Title: " + this.title);
		System.out.println("Released: " + this.year );
		System.out.println("Rating: " + this.rating);
		System.out.println("Format: " + this.format);
	}
}
