public class Login {
    private String eneteredUserID;
    private String eneteredUserPW;
    private LoginInstance loginInstance;
    private User user;
    private boolean isAdmin;
    private boolean isLoggedIn = false;

    public Login(String uID, String uPW){
        this.eneteredUserID = uID;
        this.eneteredUserPW = uPW;
        this.loginInstance = LoginInstance.getInstance();
    }

    public boolean validate(String eneteredUserID, String eneteredUserPW){
        // pseudocode

        // result = JDBC.getResult();
        // if(result is notvalid){
        //     return isLoggedIn;
        // }
        
        // isLoggedIn = true;
        // if(result.isAdmin == true){
        //     this.isAdmin = true;
        //     this.user = new AdminUser(eneteredUserPW, eneteredUserPW, result.fName, result.Lname, isAdmin);
        // } else {
        //     this.user = new RegisteredUser(eneteredUserPW, eneteredUserPW, result.fName, result.Lname, isAdmin, eneteredUserPW)
        // }
    
        return isLoggedIn;
    }

    public void updateInstance(){
        this.loginInstance.changeStatus(user, isAdmin, isLoggedIn);
    }

}
