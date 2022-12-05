<<<<<<< HEAD
public class App 
{
=======
import java.util.ArrayList;
import java.util.Iterator;

public class App {
>>>>>>> 8f1a9aa3c98b0a703a58b828783d2ec23920ba34
    public static void main(String[] args) throws Exception 
    {
       LoginInstance loginInstance = LoginInstance.getInstance();
       System.out.println(loginInstance.getIsLoggedIn());
       Login login = new Login("user1@ensf.com", "1111");
       boolean isLogin = login.validate();
       login.updateInstance();
       System.out.println(loginInstance.getUser().getUserFname());
       LoadMovie loadMovie = new LoadMovie();

       ArrayList<MovieSummary> movieSummary = loadMovie.loadMovieSummaries();
       for(MovieSummary ms : movieSummary){
            System.out.println(ms.getMovieName());
       }

       Theater theater = loadMovie.selectMovie(2);
       System.out.println("plz");
    }
}
