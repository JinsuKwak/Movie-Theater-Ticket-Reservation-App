import java.util.ArrayList;
//change name from movienews to recipient
public class Recipient implements Observer{
    User user;

    public Recipient(User user) {
        this.user = user;
    }


    @Override
    public void update(ArrayList<Movie> movies) {
        ArrayList<User> recipients = new ArrayList<User>(); //sql statement to get the registered users
        for(Movie movie : movies) {
            Email.sendMovieNews(movie.getMovieName(), movie.getMoviePrice(), movie.getOpeningDate().toString(), recipients);
        }
    }
}
