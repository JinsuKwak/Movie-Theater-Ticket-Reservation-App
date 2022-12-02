import java.util.ArrayList;

public class ShowRoom {
    private int showRoomID;
    private ArrayList<ShowTime> ShowTimes;
    private int totalSeatNum;
    private int movieID;

    public ShowRoom(int srID, ArrayList<ShowTime> ShowTimes, int totalSeatNum, int movieID){
        this.showRoomID = srID;
        this.ShowTimes = ShowTimes;
        this.totalSeatNum = totalSeatNum;
        this.movieID = movieID;
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

    public int getMovieID() {
        return this.movieID;
    }

}
