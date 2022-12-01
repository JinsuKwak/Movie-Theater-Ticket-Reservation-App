public class Ticket {
    private int ticketID;
    private String userEmail;
    private boolean byRU;
    private int movieID;
    private int theaterID;
    private int showRoomID;
    private int showTimeID;
    private int seatNum;

    public Ticket(int tkID, String uEmail, boolean byRU, int mvID, int thrID, int srID, int stID, int seatNo){
        this.ticketID = tkID;
        this.userEmail = uEmail;
        this.byRU = byRU;
        this.movieID = mvID;
        this.theaterID = thrID;
        this.showRoomID = srID;
        this.showTimeID = stID;
        this.seatNum = seatNo;
    }


	public int getTicketID() {
		return this.ticketID;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public boolean isByRU() {
		return this.byRU;
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

}
