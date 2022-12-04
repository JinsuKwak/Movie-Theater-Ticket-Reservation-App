import java.util.ArrayList;

public class ShowRoom {
    private int showRoomID;
    private ArrayList<ShowTime> ShowTimes;
    private int totalSeatNum;
    private int movieID;
    private int theatreID;

    public ShowRoom(int srID, ArrayList<ShowTime> ShowTimes, int totalSeatNum, int movieID, int theatreID){
        this.theatreID = theatreID;
        this.showRoomID = srID;
        this.ShowTimes = ShowTimes;
        this.totalSeatNum = totalSeatNum;
        this.movieID = movieID;
    }

	public int getShowtRoomID() {
		return this.showRoomID;
	}

    public int getTheatreID(){
        return this.theatreID;
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
