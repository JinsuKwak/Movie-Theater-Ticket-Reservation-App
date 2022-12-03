import java.util.Date;

public class SelectSeat {
    LoginInstance loginInstance;
    Ticket ticket;

    public SelectSeat(Ticket ticket){
        this.ticket = ticket;
        this.loginInstance = LoginInstance.getInstance();
    }

    public boolean manageRU(){
        if(loginInstance.getIsLoggedIn()){
            Date today = new Date();
            if(ticket.getMovie().getOpeningDate().getTime() >= today.getTime()){
                int tenPercentRU = ticket.getShowRoom().getTotalSeatNum()*10/100;
                if(ticket.getShowTime().getReservedByRU() >= tenPercentRU){
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}
