package it.unimi.di.prog2.esame.observer;

import it.unimi.di.prog2.esame.model.Call;
import it.unimi.di.prog2.esame.model.Ticket;

import java.util.List;

public interface Subject<T> {
    void addObserver(Observer<T> observer);
    void notifyObserver();
    Ticket getState();
}
