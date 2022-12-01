import java.util.ArrayList;

public class ShowRoom {
    private int showRoomID;
    private ArrayList<ShowTime> ShowTimes;
    private int totalSeatNum;

    public ShowRoom(int srID, ArrayList<ShowTime> ShowTimes, int totalSeatNum){
        this.showRoomID = srID;
        this.ShowTimes = ShowTimes;
        this.totalSeatNum = totalSeatNum;
    }

	public int getShowtRoomID() {
		return this.showRoomID;
	}

	public ArrayList<ShowTime> getShowTimes() {
		return this.ShowTimes;
	}

	public int getTotalSeatNum() {
		return this.totalSeatNum;
	}

}
