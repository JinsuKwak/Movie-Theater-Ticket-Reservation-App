public class ManageUser {
    LoginInstance loginInstance;
    Register register;
    String deleteUserEmail;

    public ManageUser(){
        this.loginInstance = LoginInstance.getInstance();
    }

    public void addUser(String uEmail, String uPW, String uFN, String uLN, boolean isStaff, String uCardNum){
        if(loginInstance.getIsAdmin()){  // only executable when already logged as admin
            if(isStaff == true){
                uCardNum = new String("");
                register.setToStaff();
            }
            this.register = new Register(uEmail, uPW, uFN, uLN, uCardNum);
            register.registerUser();
        }
    }

    public void deleteUser(String uEmail) {
        this.deleteUserEmail = uEmail;
        if(loginInstance.getIsAdmin()){  // only executable when already logged as admin
            //SQL
            // delete if User.userEmail == uEmail 
            // (includes AdminUsers if want to)
        }
    }
}
