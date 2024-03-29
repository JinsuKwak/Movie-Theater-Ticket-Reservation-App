import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class WeeklyNews implements Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer> ();
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private final String DBURL = "jdbc:mysql://localhost/movie_theatres";
    private final String USERNAME = "ensf480";
    private final String PASSWORD = "ensf480";
    private Connection dbConnect;

    public WeeklyNews() {
        initializeDriver();
    }

    /**
     * initializing the connection and throwing exception if failed
     */
    public void initializeDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * initializing the connection and throwing exception if failed
     */
    public void initializeConnection() {
        try {
            dbConnect = DriverManager.getConnection (DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println ("Connection Failed! Check output console");
            e.printStackTrace ();
        }
    }

    /**
     * disconnecting the connection
     */
    public void disconnectConnection() {
        try {
            dbConnect.close();
        } catch (SQLException e) {
            System.out.println("Disconnection Failed! Check output console");
            e.printStackTrace();
        }
    }

    /**
     * gets all registered users from the database that are not admins and adds
     * them to a recipients array, to distribute the weekly news to the recipients
     * in the array
     */
    public void distributeNews() {
        initializeConnection();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    initializeConnection();
                    String sql = "SELECT * FROM User WHERE isAdmin=false";
                    PreparedStatement p = dbConnect.prepareStatement(sql);
                    ResultSet result = p.executeQuery();
                    while(result.next()) {
                        RegisteredUser user = new RegisteredUser(
                            result.getString("email"),
                            result.getString("password"),
                            result.getString("userFname"),
                            result.getString("userLname"),
                            Boolean.parseBoolean(result.getString("isAdmin")),
                            result.getString("cardNumber")
                        );
                        Recipient recipient = new Recipient(user);
                        registerObserver(recipient);
                    }
                    populateMoviesarray();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(task, new Date(), TimeUnit.DAYS.toMillis(7));
    }

    /**
     * add observers to the observer array
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * remove an observer from the observer array
     */
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);

    }

    /**
     * update all observers registered in the observer array
     */
    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(movies);
        }
    }

    /**
     * add all the movies that have not been released to the movies array
     * @throws SQLException
     */
    private void populateMoviesarray() throws SQLException {
        Date todaysDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(todaysDate.getTime());
        String sql = "SELECT * FROM Movie WHERE openingDate > ?";
        PreparedStatement p = dbConnect.prepareStatement(sql);
        p.setDate(1, sqlDate);
        ResultSet result = p.executeQuery();

        while (result.next()) {
            Movie movie = new Movie(
                    result.getInt("movieID"),
                    result.getString("movieName"),
                    result.getDate("openingDate"),
                    result.getDouble("moviePrice"),
                    result.getInt("theatreID"));
            movies.add(movie);
        }
        notifyAllObservers();
        disconnectConnection();
    }
}
