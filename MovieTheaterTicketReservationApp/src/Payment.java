
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class Payment extends SQLController {
    LoginInstance loginInstance;
    Ticket ticket;

    public Payment(Ticket ticket)
    {
        super("jdbc:mysql://localhost/movie_theatres", "ensf480", "ensf480");
        this.ticket = ticket;
        this.loginInstance = LoginInstance.getInstance();
    }

    public void createTicket(){
        String ticketID = UUID.randomUUID().toString();
        Date purchasedDate = new Date(System.currentTimeMillis());
        String isRU = loginInstance.getIsLoggedIn() ? "true" : "false";
        int movieID =  ticket.getMovie().getMovieID();
        int theaterID = ticket.getTheater().getTheaterID();
        int showRoomID = ticket.getShowRoom().getShowtRoomID();
        int showTimeID = ticket.getShowTime().getShowTimeID();
        int seatNum = ticket.getSeat().getSeatNum();

        try{
            initializeConnection();
            String query = "INSERT INTO Ticket (TKID, PCHDATE, RU, MVID, THRID, SRID, STID, STNO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pStatement = dbConnection.prepareStatement(query);
            pStatement.setString(1, ticketID);
            pStatement.setDate(2, purchasedDate);
            pStatement.setString(3, isRU);
            pStatement.setInt(4, movieID);
            pStatement.setInt(5, theaterID);
            pStatement.setInt(6, showRoomID);
            pStatement.setInt(7, showTimeID);
            pStatement.setInt(8, seatNum);

            pStatement.close();
            dbConnection.close();
        } catch ( SQLException e){
            e.printStackTrace();
        }
        disconnectConnection();
    }

    public void makePayment(){
        // assume this method does interction with fiancial company
    }

    public void updateSeat(){
        initializeConnection();
        ShowTime showTime = ticket.getShowTime();
        int showTimeID = showTime.getShowTimeID();
        int seatNum = ticket.getSeat().getSeatNum();

        try  {  
                String query = "UPDATE Seat SET availability = ? WHERE seatNum = ? AND showTimeID = ?";
                PreparedStatement pStatement = dbConnection.prepareStatement(query);
                pStatement.setString(1, "false");
                pStatement.setInt(2, seatNum);
                pStatement.setInt(3, showTimeID);
                pStatement.executeUpdate();
                pStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(loginInstance.getIsLoggedIn()){
            try {
                String query = "UPDATE ShowTime SET reservedByRU = ? WHERE showTimeID = ?";
                PreparedStatement pStatement = dbConnection.prepareStatement(query);
                pStatement.setInt(1, showTime.getReservedByRU());
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
        Email email = new Email(ticket);
        email.sendEmailTicketPurchased();
    }
}
