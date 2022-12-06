import java.text.Format;
import java.text.SimpleDateFormat;
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
            String recipient = user.getUserEmail();
            String subject = movie.getMovieName();
            Format formatter = new SimpleDateFormat("dd-mm-yyyy");
            String s = formatter.format(movie.getOpeningDate());
            String message = "New Movie Update! " + movie.getMovieName() + "will be premiered for the first time on " + movie.getOpeningDate() + 
            ". Tickts will be on sale for " + movie.getMoviePrice();
            Email.sendMovieNews(recipient, subject, message);
        }
    }
}
