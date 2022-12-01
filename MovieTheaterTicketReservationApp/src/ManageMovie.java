//control class
//maarya
public class ManageMovie {
    LoginInstance loginInstance;
    int deleteMovieID;

    public ManageMovie(){
        this.loginInstance = LoginInstance.getInstance();
    }

    public void addMovie(int mvID, String mvName, String openDate, int thrID, int ShowromID, int showTimeID, String shownAt){
        // SQL 
        // add movie to 
        // theater
        // showroom
        // generate showTime with assigned time and
        // generate seats and reset to all avaliable based on showroom.totalSeatNum
    }

    public void removeMovie(int movieID){
        this.deleteMovieID = movieID;
        if(loginInstance.getIsAdmin()){  // only executable when already logged as admin
            //SQL
            // delete if Movie.movieID == deletedMovieID 
        }
    }
}
