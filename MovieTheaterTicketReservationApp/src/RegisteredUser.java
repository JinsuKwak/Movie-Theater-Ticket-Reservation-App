public class RegisteredUser extends User {
    private String cardNumber;

    public RegisteredUser(String uEmail, String uPW, String uFN, String uLN, boolean isAdmin, String cardNumber){
        super(uEmail, uPW, uFN, uLN, isAdmin);
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
