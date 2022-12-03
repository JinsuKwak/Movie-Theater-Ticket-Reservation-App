import java.util.Date;

public class Ticket {
    private String ticketID;
    private String userEmail;
    private boolean isRU;
    private int movieID;
    private int theaterID;
    private int showRoomID;
    private int showTimeID;
    private int seatNum;
    private Date purchasedDate;

    public Ticket(String tkID, String uEmail, boolean isRU, int mvID, int thrID, int srID, int stID, int seatNo){
        this.ticketID = tkID;
        this.userEmail = uEmail;
        this.isRU = isRU;
        this.movieID = mvID;
        this.theaterID = thrID;
        this.showRoomID = srID;
        this.showTimeID = stID;
        this.seatNum = seatNo;
        this.purchasedDate = new Date();  //miliseconds
    }


	public String getTicketID() {
		return this.ticketID;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public boolean getIsRU() {
		return this.isRU;
	}

	public int getMovieID() {
		return this.movieID;
	}

	public int getTheaterID() {
		return this.theaterID;
	}

	public int getShowRoomID() {
		return this.showRoomID;
	}

	public int getShowTimeID() {
		return this.showTimeID;
	}

	public int getSeatNum() {
		return this.seatNum;
	}

    public Date getPurchasedDate(){
        return this.purchasedDate;
    }
}
