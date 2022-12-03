public abstract class User {
    private static String userEmail; 
    private String userPassword;
    private String userFname;
    private String userLname;
    private boolean isAdmin;

    public User(String uEmail, String uPW, String uFN, String uLN, boolean isAdmin){
        this.userEmail = uEmail;
        this.userPassword = uPW;
        this.userFname = uFN;
        this.userLname = uLN;
        this.isAdmin = isAdmin;
    }

    public static String getUserEmail(){ 
        return userEmail;
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
}
