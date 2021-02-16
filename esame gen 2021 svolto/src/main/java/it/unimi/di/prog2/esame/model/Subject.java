package it.unimi.di.prog2.esame.model;

public interface Subject<T> {
    void addObserver(Observer<T> observer);
    void notifyObservers();
    T getState();

}
