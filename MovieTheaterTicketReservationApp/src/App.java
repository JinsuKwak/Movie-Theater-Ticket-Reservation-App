import java.util.ArrayList;
import java.sql.Date;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        AnnualFee annualFee = new AnnualFee();
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        annualFee.startAnnualFee(20, sqlDate);

        GUIframe.start();
    }
}
