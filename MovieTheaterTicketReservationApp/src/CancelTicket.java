import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class CancelTicket extends SQLController {
    private Ticket ticket;
    private String ticketID;
    private String ticketUserEmail;
    private boolean canceledByRU;

    public CancelTicket(String ticketID, String ticketUserEmail){
        super("jdbc:mysql://localhost/movie_theatres", "ensf480", "ensf480");
        this.ticketID = ticketID;
        this.ticketUserEmail = ticketUserEmail;
    }

    public boolean verifyTicket(){
        initializeConnection();
        boolean isValid = false;
            try  {  
                String query = "Select * FROM Ticket WHERE ticketID = ? AND userEmail = ?";
                PreparedStatement pStatement = dbConnection.prepareStatement(query);
                pStatement.setString(1, ticketID);
                pStatement.setString(2, ticketUserEmail);

                ResultSet result = pStatement.executeQuery();

                if(!result.isBeforeFirst()){
                    return false;
                } 

                while (result.next()){
                    isValid = true;
                    canceledByRU = result.getString("isRU").equals("true") ? true : false;
                    ticket = new Ticket(
                        result.getString("ticketID"),
                        result.getString("userEmail"),
                        canceledByRU,
                        result.getInt("movieID"),
                        result.getInt("theatreID"),
                        result.getInt("showRoomID"),
                        result.getInt("showTimeID"),
                        result.getInt("seatNum")
                    );

                    java.sql.Date sqlDate = result.getDate("purchasedDate");
                    java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
                    ticket.setPurchasedDate(utilDate);
                }
                result.close();
                pStatement.close();
                disconnectConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return isValid;
    }

    public void deleteTicket() {
        initializeConnection();
        try{
            String query = "DELETE FROM Ticket WHERE ticketID = ?";
            PreparedStatement pStatement = dbConnection.prepareStatement(query);
            pStatement.setString(1, ticketID);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void updateSeat(){
        initializeConnection();
        ShowTime showTime = ticket.getShowTime();
        int showTimeID = ticket.getShowTimeID();
        int seatNum = ticket.getSeatNum();

        try  {  
                String query = "UPDATE Seat SET availability = ? WHERE seatNum = ? AND showTimeID = ?";
                PreparedStatement pStatement = dbConnection.prepareStatement(query);
                pStatement.setString(1, "true");
                pStatement.setInt(2, seatNum);
                pStatement.setInt(3, showTimeID);
                pStatement.executeUpdate();
                pStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(ticket.getIsRU()){
            try {
                String query = "UPDATE ShowTime SET reservedByRU = ? WHERE showTimeID = ?";
                PreparedStatement pStatement = dbConnection.prepareStatement(query);
                pStatement.setInt(1, showTime.getReservedByRU()-1);
                pStatement.setInt(2, showTimeID);
                pStatement.executeUpdate();
                pStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        disconnectConnection();
    }

    public void sendEmail(){
        initializeConnection();
        String movieName = "";  
        double moviePrice = 0;
        try  {  
            String query = "Select * FROM Movie WHERE movieID = ? AND theatreID = ?";
            PreparedStatement pStatement = dbConnection.prepareStatement(query);
            pStatement.setInt(1, ticket.getMovieID());
            pStatement.setInt(2, ticket.getTheaterID());
            ResultSet result = pStatement.executeQuery();
            while (result.next()){
                movieName = result.getString("movieName");
                moviePrice = result.getDouble("moviePrice");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnectConnection();
        Email.sendEmailTicketCancelled(ticket , movieName, moviePrice);
    }

}
