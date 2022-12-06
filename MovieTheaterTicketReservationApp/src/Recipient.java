import java.util.ArrayList;

public class Recipient implements Observer {
    User user;

    /**
     * Recipient constructor
     * @param user
     */
    public Recipient(User user) {
        this.user = user;
    }

    /**
     * update function of the observer object. This methods sends emails to update
     * the user about new movies
     * @param movies
     */
    @Override
    public void update(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            String recipient = user.getUserEmail();
            String subject = movie.getMovieName();
            String message = "New Movie Update! " + movie.getMovieName() + "will be premiered for the first time on "
                    + movie.getOpeningDate() +
                    ". Tickts will be on sale for " + movie.getMoviePrice();
            Email.sendMovieNews(recipient, subject, message);
        }
    }
}
