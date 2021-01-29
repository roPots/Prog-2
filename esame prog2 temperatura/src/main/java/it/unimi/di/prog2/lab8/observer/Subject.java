package it.unimi.di.prog2.lab8.observer;

public interface Subject<T> {
  void notifyObservers();

  void addObserver(Observer<T> obs);

  T getState();
}
