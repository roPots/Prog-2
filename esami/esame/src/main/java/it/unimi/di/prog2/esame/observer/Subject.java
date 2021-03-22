package it.unimi.di.prog2.esame.observer;

public interface Subject<T> {
    void addObserver(Observer<T> obs);
    void setState(T newstate);
    void notifyObserver();
    T getState();
}
