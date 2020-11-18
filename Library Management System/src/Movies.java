public class Movies {
    private Movie movie;
    private int numMovies;
    private int numCheckedOut;

    public Movies(Movie movie){
        this.movie = movie;
        numMovies = 1;
        this.numCheckedOut = 0;
    }

    public Movie getMovie(){
        return movie;
    }

    public int getNumMovies(){
        return numMovies;
    }

    public int getNumCheckedOut(){
        return numCheckedOut;
    }

    public void addMovie(){
        numMovies++;
    }

    public void addCheckedOut(){
        numCheckedOut++;
    }
}
