package it.unimi.di.prog2.esame.model;

import java.util.ArrayList;
import java.util.List;

public class Model implements Subject<Ticket> {
    private List<Observer<Ticket>> observers = new ArrayList<>();
    private int last = 1;
    private int next = 1;

    private String lastServed = "S-- XX";

    @Override
    public void addObserver(Observer<Ticket> observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Ticket> observer : observers) {
            observer.update(this, getState());
        }
    }

    @Override
    public Ticket getState() {
        return new Ticket(last, next);
    }

    public void getTicket() {
        last++; notifyObservers();
    }

    public void serveClient(String sportelloID) {
        lastServed = "S"+sportelloID+" "+next;
        next++; notifyObservers();
    }

    public String lastServing() {
        return lastServed;
    }

    public int getLastInCue() {
        return getState().getLast();
    }

    public int getNextInCue() {
        return getState().getNext();
    }

    public boolean hasNext() {
        return next<last;
    }
}
