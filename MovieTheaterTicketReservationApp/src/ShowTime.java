import java.util.ArrayList;

public class ShowTime {
    private int showTimeID;
    private String shownAt;
    private int reservedByRU;
    private ArrayList<Boolean> seatAvilabilities;
    
    public ShowTime(int stID, String stAT, int rsvdRU, ArrayList<Boolean> seatAvilabilities){
        this.showTimeID = stID;
        this.shownAt = stAT;
        this.reservedByRU = rsvdRU;
        this.seatAvilabilities = seatAvilabilities;
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

	public ArrayList<Boolean> getSeatAvilabilities() {
		return this.seatAvilabilities;
	}

}
