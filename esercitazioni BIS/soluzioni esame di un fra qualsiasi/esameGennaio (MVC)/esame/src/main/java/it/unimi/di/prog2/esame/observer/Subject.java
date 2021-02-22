package it.unimi.di.prog2.esame.observer;

public interface Subject<T> {
    void addObserver(Observer<T> observer);
    void notifyObserver();
    T getState();
}
