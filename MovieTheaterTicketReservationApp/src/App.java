import java.util.ArrayList;

public class App 
{
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
