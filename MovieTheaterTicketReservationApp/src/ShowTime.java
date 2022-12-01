import java.util.ArrayList;

public class ShowTime {
    private int showTimeID;
    private String shownAt;
    private int reservedByRU;
    private ArrayList<Seat> seats;

    public ShowTime(int stID, String stAT, int rsvdRU, ArrayList<Seat> seats){
        this.showTimeID = stID;
        this.shownAt = stAT;
        this.reservedByRU = rsvdRU;
        this.seats = seats;
    }

	public int getShowTimeID() {
		return this.showTimeID;
	}

	public String getShownAt() {
		return this.shownAt;
	}

	public int getReservedByRU() {
		return this.reservedByRU;
	}

	public ArrayList<Seat> getAllSeats() {
		return this.seats;
	}

}
