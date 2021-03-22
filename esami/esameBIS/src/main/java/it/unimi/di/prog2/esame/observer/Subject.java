package it.unimi.di.prog2.esame.observer;

public interface Subject<T> {
    void addObserver(Observer<T> obs);
    void setState(T new_state);
    void notifyObserver();
    T getState();
    void removeObserver(Observer<T> obs);
}
