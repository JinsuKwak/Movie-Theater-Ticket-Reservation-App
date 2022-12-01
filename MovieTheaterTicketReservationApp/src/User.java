public abstract class User {
    private String userEmail;
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

    public String getUserEmail(){
        return userEmail;
    }
    public String getUserPassword(){
        return userPassword;
    }
    public String getUserFname(){
        return userFname;
    }
    public String getUserLname(){
        return userLname;
    }
    public boolean getIsAdmin(){
        return isAdmin;
    }
}
