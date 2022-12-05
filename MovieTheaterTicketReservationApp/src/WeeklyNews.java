import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WeeklyNews extends SQLController implements Subject{
    private ArrayList<Observer> observers;
    private ArrayList<Movie> movies;

    public WeeklyNews(ArrayList<Observer> observers, ArrayList<Movie> movies) {
        super("jdbc:mysql://localhost/movie_theatres", "ensf480", "ensf480");
        movies = new ArrayList<>();
        observers = new ArrayList<>();
    }

    private void startAnnualFee() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            // load all RU, check user != Admin
            @Override
            public void run() {
                Date todaysDate = new Date();
                String sql = "SELECT * FROM Movie WHERE openinfDate > ?";
                PreparedStatement p = this.dbConnection.prepareStatement(sql);
                p.setDate(1, todaysDate);
                ResultSet result = p.executeQuery();
                
                while(result.next()) {
                    Movie movie = new Movie(
                        result.getInt("movieID"), 
                        result.getString("movieName"),
                        result.getDate("openingDate"),
                        result.getDouble("moviePrice"),
                        result.getInt("theatreID")
                    );
                    movies.add(movie);
                }
                notifyAllObservers();
            }
        };
        timer.scheduleAtFixedRate(task, new Date(), TimeUnit.DAYS.toMillis(7) ); 
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        
    }

    @Override
    public void notifyAllObservers() {
        for(Observer observer : observers) {
            observer.update(movies);
        }
    }
}
