import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.text.StyledEditorKit.StyledTextAction;

public class Email {
    private static final String user = "testemail010203040506@gmail.com";
    private static final String pw = "jkjxrcrmotvgylqx";


    public static void sendEmailTicketPurchased(Ticket mainTicket,ArrayList<Ticket> purchasedTickets){
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pw);
                    }
                });
    
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("testemail010203040506@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mainTicket.getUserEmail())
            );
            String ticketIDandSeatNum = new String();
            for(Ticket ticket: purchasedTickets){
                ticketIDandSeatNum+="Ticket ID: "+ticket.getTicketID()+"\n"+
                "Seat Number: "+ticket.getSeatNum()+"\n";
            }
            Formatter fmt1 = new Formatter();
            Formatter fmt2 = new Formatter();
            double moviePrice = mainTicket.getMovie().getMoviePrice();
            fmt1.format("%.2f",moviePrice);
            Double totalPrice = moviePrice*purchasedTickets.size();
            fmt2.format("%.2f",totalPrice);
           
            message.setSubject("Your Movie Ticket");
            message.setText("Thanks for Purchased Movie Ticket\n"+
            "Movie Name: "+mainTicket.getMovie().getMovieName()+"\n"+
            "Movie Price: $"+fmt1+"\n"+
            "Total Price: $"+fmt2+"\n"+
            "Theater: "+mainTicket.getTheater().getTheaterName()+"\n"+
            "Address: "+mainTicket.getTheater().getTheaterLocation()+"\n"+
            "Show Room: "+mainTicket.getShowRoomID()+"\n"+
            "At: "+mainTicket.getShowTime().getShownAt()+"\n"+
            ticketIDandSeatNum);
            Transport.send(message);

            fmt1.close();
            fmt2.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void  sendEmailTicketCancelled(Ticket cancelledTicekt) {
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pw);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("testemail010203040506@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(cancelledTicekt.getUserEmail())
            );
            //TODO REQURE SQL
            // double refundRatio = cancelledTicekt.getIsRU() ? 1.0 : 0.85;
            // String isRU = cancelledTicekt.getIsRU() ? "our memeber" : "non-member";
            // message.setSubject("Your Movie Ticket Cancelled Successfully");
            // message.setText("The Cancelled Ticket is\n"+
            // "Movie Name: "+cancelledTicekt.getMovie().getMovieName()+"\n"+
            // "Movie Price: $"+cancelledTicekt.getMovie().getMoviePrice()+"\n"+
            // "Theater: "+cancelledTicekt.getTheater().getTheaterName()+"\n"+
            // "Address: "+cancelledTicekt.getTheater().getTheaterLocation()+"\n"+
            // "Show Room: "+cancelledTicekt.getShowRoomID()+"\n"+
            // "At: "+cancelledTicekt.getShowTime().getShownAt()+"\n"+
            // "Seat Number: "+cancelledTicekt.getSeatNum()+"\n\n"+
            // "Since you are "+isRU+"total refund credit is: "+cancelledTicekt.getMovie().getMoviePrice()*refundRatio+"\n"+
            // "And it will valid untill: "+cancelledTicekt.getPurchasedDate().toString());
            // Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    
    }

    public static void sendSubscription(String userFname, String userLname, int amount){
        System.out.println("USER SUBSCRIPTION");
    }

    public static void sendMovieNews(String recipientEmail, String subject, String message) {
        System.out.println("USER MOVIE NEWS");
    }

}
