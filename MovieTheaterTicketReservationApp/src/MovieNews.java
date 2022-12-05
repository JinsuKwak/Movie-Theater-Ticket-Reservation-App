import java.util.ArrayList;

public class MovieNews implements Observer{
    WeeklyNews weeklyNews;


    public MovieNews(WeeklyNews weeklyNews) {
        this.weeklyNews = weeklyNews;
    }


    @Override
    public void update(ArrayList<Movie> movies) {
        ArrayList<User> recipients = new ArrayList<User>(); //sql statement to get the registered users
        for(Movie movie : movies) {
            Email.sendMovieNews(movie.getMovieName(), movie.getMoviePrice(), movie.getOpeningDate().toString(), recipients);
        }
    }
}
