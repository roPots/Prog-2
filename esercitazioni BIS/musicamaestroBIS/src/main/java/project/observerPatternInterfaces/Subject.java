package project.observerPatternInterfaces;

public interface Subject<T> {
    void addObserver(Observer<T> observer);
    void notifyObservers();

    Object getState();
    void removeObserver(Observer<T> observer);
}
