import java.util.ArrayList;

public class ShowRoom {
    private int showRoomID;
    private ArrayList<ShowTime> ShowTimes;
    private ArrayList<Seat> seats;

    public ShowRoom(int srID, ArrayList<ShowTime> ShowTimes, ArrayList<Seat> seats){
        this.showRoomID = srID;
        this.ShowTimes = ShowTimes;
        this.seats = seats;
    }

	public int getShowtRoomID() {
		return this.showRoomID;
	}

	public ArrayList<ShowTime> getShowTimes() {
		return this.ShowTimes;
	}

	public ArrayList<Seat> getSeats() {
		return this.seats;
	}

}
