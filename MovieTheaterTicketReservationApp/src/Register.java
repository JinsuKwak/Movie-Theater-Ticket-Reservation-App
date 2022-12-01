public class Register {
    String userEmail;
    String userPassword;
    String userFname;
    String userLname;
    String userCardNum = new String("");
    boolean isStaff = false;

    public Register(String uEmail, String uPW, String uFN, String uLN, String uCardNum){
        this.userEmail = uEmail;
        this.userPassword = uPW;
        this.userFname = uFN;
        this.userLname = uLN;
        this.userCardNum = uCardNum;
    }

    public boolean isUniqueEmail(){
        boolean isUnique = false;
        // SQL
        // result = JDBC.getResult();
        // if(result == null) {
        //  isUnique == true;
        // }
        return isUnique;
    }

    public void setToStaff(){
        this.isStaff = true;
    }  

    public void registerUser(){
        // SQL
        // SQL.insert(uEmail, uPW, uFN, uLN, isStaff, uCardNum)
    }
}
