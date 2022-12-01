import java.util.Date;

import javax.print.attribute.standard.Sides;

public class LoginInstance {
    private static LoginInstance loginInstance;
    private User user;
    private boolean isAdmin;
    private boolean isLoggedIn;
    private Date logInTime;

    private LoginInstance(){
       this.isAdmin = false;
       this.isLoggedIn = false;
       this.logInTime = new Date();         // at miliseconds
    }
    
    public void setInstance(LoginInstance loginInstance){
        LoginInstance.loginInstance = loginInstance;
    }

    public static LoginInstance getInstance(){
        if(loginInstance == null){
            loginInstance = new LoginInstance();
        }
        return loginInstance;
    }

    public void changeStatus(User user, boolean isAdmin, boolean isLoggedIn){
        this.user = user;
        this.isAdmin = isAdmin;
        this.isLoggedIn = isLoggedIn;
    }

    public User getUser(){
        return this.user;
    }

    public boolean getIsAdmin(){
        return this.isAdmin;
    }

    public boolean getIsLoggedIn(){
        return this.isLoggedIn;
    }

    public Date getLogInTime(){
        return this.logInTime;
    }

}
