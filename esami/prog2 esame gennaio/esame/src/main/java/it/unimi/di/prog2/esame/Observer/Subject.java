package it.unimi.di.prog2.esame.Observer;

public interface Subject<T> {
    void addObserver(Observer<T> observer);
    void notifyObserver();
    Object getState(); // observer chiede stato in modalità pull
}
