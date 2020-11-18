public class Books {
    private Book book;
    private int numBooks;
    private int numCheckedOut;

    public Books(Book book){
        this.book = book;
        numBooks = 1;
        this.numCheckedOut = 0;
    }

    public Book getBook(){
        return book;
    }

    public int getNumBooks(){
        return numBooks;
    }

    public int getNumCheckedOut(){
        return numCheckedOut;
    }

    public void addBook(){
        numBooks++;
    }

    public void addCheckedOut(){
        numCheckedOut++;
    }
}
