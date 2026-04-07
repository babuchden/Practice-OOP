package task7;

public interface Observable {
    void addObserver(Observer o);
    void notifyObservers();
}