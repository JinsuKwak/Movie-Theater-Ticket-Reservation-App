import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadMovie extends SQLController {
    private LoginInstance loginInstance;
    private Theater selectedTheater;
    private ArrayList<Movie> movies;

    public LoadMovie(){
        super("jdbc:mysql://localhost/movie_theatres", "ensf480", "ensf480");
        this.loginInstance = LoginInstance.getInstance();
        movies = new ArrayList<Movie>();
    }
    
    public ArrayList<Movie> loadMovieSummaries(){
        try{

            initializeConnection();
            String query;
            if(loginInstance.getIsLoggedIn()){
                query = "SELECT * FROM Movie";
            } else {
                query = "SELECT * FROM Movie";  //TODO for OU
            }
            PreparedStatement pStatement = dbConnection.prepareStatement(query);
            ResultSet result = pStatement.executeQuery();

            if(!result.isBeforeFirst()){
                return null;
            } 

            while (result.next()){
                java.sql.Date sqlDate = result.getDate("openingDate");
                java.util.Date openingDate = new java.util.Date(sqlDate.getTime());
                Movie summary = new Movie(
                    result.getInt("movieID"),
                    result.getString("movieName"),
                    openingDate,
                    result.getFloat("moviePrice"),
                    result.getInt("theatreID")
                );
                movies.add(summary);
            }
            disconnectConnection();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return movies;
    }


    public Theater selectMovie(int movieID){
        ArrayList<Movie> movies = new ArrayList<Movie>();
        int theaterID = 1;
        try {
            initializeConnection();
            String query = "SELECT * FROM Movie WHERE movieID = ?";
            PreparedStatement pStatement = dbConnection.prepareStatement(query);
            pStatement.setInt(1, movieID);
            ResultSet result = pStatement.executeQuery();
            while (result.next()){
                java.sql.Date sqlDate = result.getDate("openingDate");
                java.util.Date openingDate = new java.util.Date(sqlDate.getTime());
                Movie movie = new Movie(
                    result.getInt("movieID"),
                    result.getString("movieName"),
                    openingDate,
                    result.getDouble("moviePrice"),
                    result.getInt("theatreID")
                );
                theaterID = result.getInt("theatreID");
                movies.add(movie);
            }
            String queryThr = "SELECT * FROM Theatre WHERE theatreID = ?";
            PreparedStatement pStatementThr = dbConnection.prepareStatement(queryThr);
            pStatementThr.setInt(1, theaterID);
            ResultSet resultThr = pStatementThr.executeQuery();


            while (resultThr.next()){
                String querySR = "SELECT * FROM ShowRoom WHERE theatreID = ? AND movieID = ?";
                PreparedStatement pStatementSR = dbConnection.prepareStatement(querySR);
                pStatementSR.setInt(1, resultThr.getInt("theatreID"));
                pStatementSR.setInt(2,movieID);
                ResultSet resultSR = pStatementSR.executeQuery();

                ArrayList<ShowRoom> showRooms = new ArrayList<ShowRoom>();
                while(resultSR.next()){
                    String queryST = "SELECT * FROM ShowTime WHERE ShowRoomID = ?";
                    PreparedStatement pStatementST = dbConnection.prepareStatement(queryST);
                    pStatementST.setInt(1, resultSR.getInt("showRoomID"));
                    ResultSet resultST = pStatementST.executeQuery();

                    ArrayList<ShowTime> showTimes = new ArrayList<ShowTime>();
                    while(resultST.next()){
                        String querySeat = "SELECT * FROM Seat WHERE ShowTimeID = ?";
                        PreparedStatement pStatementSeat = dbConnection.prepareStatement(querySeat);
                        pStatementSeat.setInt(1, resultST.getInt("showTimeID"));
                        ResultSet resultSeat = pStatementSeat.executeQuery();

                        ArrayList<Seat> seats = new ArrayList<Seat>();
                        while(resultSeat.next()){
                            boolean available = resultSeat.getString("availability").equals("true") ? true : false;
                            Seat seat = new Seat(
                                resultSeat.getInt("seatNum"),
                                available
                            );
                            seats.add(seat);
                        }
                        resultSeat.close();
                        pStatementSeat.close();

                        ShowTime showTime = new ShowTime(
                            resultST.getInt("showTimeID"),
                            resultST.getString("shownAt"),
                            resultST.getInt("reservedByRU"),
                            seats
                        );
                        showTimes.add(showTime);
                    }
                    resultST.close();
                    pStatementST.close();

                    ShowRoom showRoom = new ShowRoom(
                        resultSR.getInt("showRoomID"),
                        showTimes,
                        resultSR.getInt("totalSeats"),
                        resultSR.getInt("movieID"),
                        resultSR.getInt("showRoomID")
                    );
                    showRooms.add(showRoom);
                }
                resultSR.close();
                pStatementSR.close();

                    Theater theater = new Theater(
                    resultThr.getInt("theatreID"),
                    resultThr.getString("theatreName"),
                    resultThr.getString("theatreLocation"),
                    movies,
                    showRooms
                );
                selectedTheater = theater;
            }
            resultThr.close();
            pStatementThr.close();
            result.close();
            pStatement.close();
            disconnectConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return selectedTheater;
    }
}


