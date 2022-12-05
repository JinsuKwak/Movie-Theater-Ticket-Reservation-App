import java.util.Date;

public class SelectSeatFCF {
    LoginInstance loginInstance;
    Ticket ticket;

    public SelectSeatFCF(Ticket ticket){
        this.ticket = ticket;
        this.loginInstance = LoginInstance.getInstance();
    }

    public int possibleNumFCF(){
        int tenPercentRU = ticket.getShowRoom().getTotalSeatNum()*10/100;
        if(loginInstance.getIsLoggedIn()){
            Date today = new Date();
            if(ticket.getMovie().getOpeningDate().getTime() >= today.getTime()){
                if(ticket.getShowTime().getReservedByRU() >= tenPercentRU){
                    return 0;
                } else {
                    return tenPercentRU - ticket.getShowTime().getReservedByRU();
                }
            } else {
                return tenPercentRU - ticket.getShowTime().getReservedByRU();
            }
        } else {
            return tenPercentRU - ticket.getShowTime().getReservedByRU();
        }
    }
}
