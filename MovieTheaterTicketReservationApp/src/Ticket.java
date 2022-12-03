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

	private Movie movie;
	private Theater theater;
	private ShowRoom showRoom;
	private ShowTime showTime;
	private Seat seat;


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

	public Ticket(){

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

	public void setTicketID(String ticketID){
		this.ticketID = ticketID;
	}

	public void setUserEmail(String uEmail){
		this.userEmail = uEmail;
	}

	public void setIsRU(boolean isRU){
		this.isRU = isRU;
	}
	
	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theater getTheater() {
		return this.theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public ShowRoom getShowRoom() {
		return this.showRoom;
	}

	public void setShowRoom(ShowRoom showRoom) {
		this.showRoom = showRoom;
	}

	public ShowTime getShowTime() {
		return this.showTime;
	}

	public void setShowTime(ShowTime showTime) {
		this.showTime = showTime;
	}

	public Seat getSeat() {
		return this.seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
}
