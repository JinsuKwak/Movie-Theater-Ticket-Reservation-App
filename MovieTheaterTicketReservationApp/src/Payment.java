
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class Payment extends SQLController {
    private LoginInstance loginInstance;
    private Ticket mainTicket;
    private ArrayList<Seat> ticketSeats;
    private ArrayList<Ticket> totalTickets;

    public Payment(Ticket mainTicket, ArrayList<Seat> ticketSeats)
    {
        super("jdbc:mysql://localhost/movie_theatres", "ensf480", "ensf480");
        this.mainTicket = mainTicket;
        this.ticketSeats = ticketSeats;
        this.loginInstance = LoginInstance.getInstance();
        totalTickets = new  ArrayList<Ticket>();
    }

    public void createTickets(){
        initializeConnection();
        for(Seat seat: ticketSeats){
            String ticketID = UUID.randomUUID().toString();
            Date purchasedDate = new Date(System.currentTimeMillis());
            String isRU = loginInstance.getIsLoggedIn() ? "true" : "false";
            String userEmail = mainTicket.getUserEmail();
            int movieID =  mainTicket.getMovie().getMovieID();
            int theaterID = mainTicket.getTheater().getTheaterID();
            int showRoomID = mainTicket.getShowRoom().getShowtRoomID();
            int showTimeID = mainTicket.getShowTime().getShowTimeID();
            int seatNum = seat.getSeatNum();

            try{
                String query = "INSERT INTO Ticket "+
                "(ticketID, purchasedDate, isRU, userEmail, movieID, theatreID, showRoomID, showTimeID, seatNum) "+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pStatement = dbConnection.prepareStatement(query);
                pStatement.setString(1, ticketID);
                pStatement.setDate(2, purchasedDate);
                pStatement.setString(3, isRU);
                pStatement.setString(4, userEmail);
                pStatement.setInt(5, movieID);
                pStatement.setInt(6, theaterID);
                pStatement.setInt(7, showRoomID);
                pStatement.setInt(8, showTimeID);
                pStatement.setInt(9, seatNum);
                pStatement.executeUpdate();
                pStatement.close();
            } catch ( SQLException e){
                e.printStackTrace();
            }
            totalTickets.add(new Ticket(ticketID, userEmail,loginInstance.getIsLoggedIn(), movieID, theaterID, showRoomID, showTimeID, seatNum));
        }
        disconnectConnection();
    }

    public void makePayment(){
        // assume this method does interction with fiancial company
    }

    public void updateSeat(){
        initializeConnection();
            ShowTime showTime = mainTicket.getShowTime();
            int showTimeID = showTime.getShowTimeID();
            for(Seat seat: ticketSeats){
                int seatNum = seat.getSeatNum();

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
            }   
            if(loginInstance.getIsLoggedIn()){
                try {
                    String query = "UPDATE ShowTime SET reservedByRU = ? WHERE showTimeID = ?";
                    PreparedStatement pStatement = dbConnection.prepareStatement(query);
                    pStatement.setInt(1, showTime.getReservedByRU()+totalTickets.size());
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
        Email.sendEmailTicketPurchased(mainTicket, totalTickets);
    }
}
