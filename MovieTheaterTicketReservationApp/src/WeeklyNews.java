import java.util.ArrayList;

public class WeeklyNews implements Subject {
    private ArrayList<Observer> observers;
    private ArrayList<Movie> movies;

    public WeeklyNews(ArrayList<Observer> observers, ArrayList<Movie> movies) {
        this.observers = observers;
        this.movies = movies;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        
    }

    @Override
    public void notifyAllObservers(Observer o) {
        for(Observer observer : observers) {
            observer.update(movies);
        }
    }

}
