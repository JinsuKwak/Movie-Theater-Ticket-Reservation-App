public abstract class User {
<<<<<<< HEAD
    private static String userEmail; 
=======
    private String userEmail; //changed this to static
>>>>>>> f120c218babd3a3ca4039dc9839606bb95776af2
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

<<<<<<< HEAD
    public static String getUserEmail(){ 
        return userEmail;
=======
    public String getUserEmail(){ //also changed this static to work
        return this.userEmail;
>>>>>>> f120c218babd3a3ca4039dc9839606bb95776af2
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
