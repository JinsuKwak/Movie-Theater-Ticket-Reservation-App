public abstract class User {
    private String userEmail; //changed this to static
    private String userPassword;
    private String userFname;
    private String userLname;
    private boolean isAdmin;
    private String cardNumber;

    public User(String uEmail, String uPW, String uFN, String uLN, boolean isAdmin, String cardNumber){
        this.userEmail = uEmail;
        this.userPassword = uPW;
        this.userFname = uFN;
        this.userLname = uLN;
        this.isAdmin = isAdmin;
        this.cardNumber = cardNumber;
    }

    public String getUserEmail(){ //also changed this static to work
        return this.userEmail;
    }
    public String getUserPassword(){
        return this.userPassword;
    }
    public String getUserFname(){
        return this.userFname;
    }
    public String getUserLname(){
        return this.userLname;
    }
    public boolean getIsAdmin(){
        return this.isAdmin;
    }
    public String getcardNumber(){
        return this.cardNumber;
    }
}
