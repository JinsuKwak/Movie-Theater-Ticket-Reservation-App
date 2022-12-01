public class Login {
    private String enteredUserEmail;
    private String enteredUserPW;
    private LoginInstance loginInstance;
    private User user;
    private boolean isAdmin;
    private boolean isLoggedIn = false;

    public Login(String uEmail, String uPW)
    {
        this.enteredUserEmail = uEmail;
        this.enteredUserPW = uPW;
        this.loginInstance = LoginInstance.getInstance();
    }

    public boolean validate(String enteredUseEmail, String enteredUserPW)
    {
        // pseudocode

        // result = JDBC.getResult();
        // if(result is notvalid){
        //     return isLoggedIn;
        // }
        
        // isLoggedIn = true;
        // if(result.isAdmin == true){
        //     this.isAdmin = true;
        //     this.user = new AdminUser(eneteredUserEmail, eneteredUserPW, result.fName, result.Lname, isAdmin);
        // } else {
        //     this.user = new RegisteredUser(eneteredUserEmail, eneteredUserPW, result.fName, result.Lname, isAdmin, eneteredUserPW)
        // }
    
        return isLoggedIn;
    }

    public void updateInstance(){
        this.loginInstance.changeStatus(user, isAdmin, isLoggedIn);
    }

}
