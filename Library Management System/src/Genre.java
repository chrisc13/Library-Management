public class Genre {

    private String genreCode;
    private String type;

    public Genre(String genreCode, String type)
    {
        this.genreCode = genreCode;
        this.type = type;
    }

    public String getGenreCode()
    {
        return genreCode;
    }

    public String getType()
    {
        return type;
    }

}