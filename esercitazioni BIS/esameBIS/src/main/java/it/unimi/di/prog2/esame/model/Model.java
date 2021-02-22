package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Model implements Subject<Ticket> {
    private int last = 0;
    private int next = 0;

    private List<Observer<Ticket>> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer<Ticket> obs) {
        observers.add(obs);
    }

    @Override
    public Ticket getState() {
        return new Ticket(last,next);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Ticket> observer : observers) {
            observer.update(this,getState());
        }
    }

    public void getTicket() {
        last++;
        notifyObservers();
    }

    public void serveNext() {
        if (next < last) {
            next++;
            notifyObservers();
        }
    }
}
