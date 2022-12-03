public class Seat {
    private int seatNum;
    private boolean availablity;

    public Seat(int seatNum, boolean availablity){
        this.seatNum = seatNum;
        this.availablity = availablity;
    }

    public int getSeatNum(){
        return this.seatNum;
    }

    public boolean getAvailablity(){
        return this.availablity;
    }
}
