import java.util.ArrayList;
import java.util.Date;
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
    public static void main(String[] args) {
        Email.sendEmailTicketPurchased(null);
        Email.sendEmailTicketCancelled(null);

    }

    public static void sendEmailTicketPurchased(Ticket purchasedTicket){
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
                    InternetAddress.parse(purchasedTicket.getUserEmail())
            );
            message.setSubject("Your Movie Ticket");
            message.setText("Thanks for Purchased Movie Ticket\n"+
            "Movie Name: "+purchasedTicket.getMovie().getMovieName()+"\n"+
            "Movie Price: $"+purchasedTicket.getMovie().getMoviePrice()+"\n"+
            "Theater: "+purchasedTicket.getTheater().getTheaterName()+"\n"+
            "Address: "+purchasedTicket.getTheater().getTheaterLocation()+"\n"+
            "Show Room: "+purchasedTicket.getShowRoomID()+"\n"+
            "At: "+purchasedTicket.getShowTime().getShownAt()+"\n"+
            "Seat Number: "+purchasedTicket.getSeatNum());
            Transport.send(message);

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

    public static void sendMovieNews(String movieName, double moviePrice, String movieDate, ArrayList<User> recipients) {
        System.out.println("USER MOVIE NEWS");
    }

}
