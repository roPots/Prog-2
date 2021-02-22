package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class TicketModel implements Subject<Ticket> {

    private int last = 0;
    private int next = 0;
    final private List<Observer<Ticket>> observers = new ArrayList<>();
    private String idOffice;

    public void setLast() {
        last++;
        notifyObserver();
    }

    public void setNext(String id) {
        if (next < last) {
            next++;
            idOffice = id;
            notifyObserver();
        }
    }

    @Override
    public void addObserver(Observer<Ticket> observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer<Ticket> observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public Ticket getState() {
        return new Ticket(last, next, idOffice);
    }

}
