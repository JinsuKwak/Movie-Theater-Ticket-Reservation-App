/**
 * maarya, jinsu, nour, neil
 * ENSF 480 Project
 * LoginInstance.java
 * 
 */
import java.util.Date;

public class LoginInstance {
    //class variables
    private static LoginInstance loginInstance;
    private User user;
    private boolean isAdmin;
    private boolean isLoggedIn;
    private Date logInTime;
    /**
     * private constructor
     */
    private LoginInstance(){
       this.isAdmin = false;
       this.isLoggedIn = false;
       this.logInTime = new Date();      
    }
/**
 * 
 * @param loginInstance
 */
    public void setInstance(LoginInstance loginInstance){
        LoginInstance.loginInstance = loginInstance;
    }
/**
 * 
 * @return
 */
    public static LoginInstance getInstance(){
        if(loginInstance == null){
            loginInstance = new LoginInstance();
        }
        return loginInstance;
    }
/**
 * 
 * @param user
 * @param isAdmin
 * @param isLoggedIn
 */
    public void changeStatus(User user, boolean isAdmin, boolean isLoggedIn){
        this.user = user;
        this.isAdmin = isAdmin;
        this.isLoggedIn = isLoggedIn;
    }
/**
 * 
 * @return
 */
    public User getUser(){
        return this.user;
    }
/**
 * 
 * @return
 */
    public boolean getIsAdmin(){
        return this.isAdmin;
    }
/**
 * 
 * @return
 */
    public boolean getIsLoggedIn(){
        return this.isLoggedIn;
    }
/**
 * 
 * @return
 */
    public Date getLogInTime(){
        return this.logInTime;
    }
/**
 * resetLoginStatus
 */
    public void resetLoginStatus(){
        this.isLoggedIn = false;
        this.isAdmin = false;
        this.user = null;
    }

}
