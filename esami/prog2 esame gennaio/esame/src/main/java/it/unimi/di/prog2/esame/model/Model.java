package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.Observer.Observer;
import it.unimi.di.prog2.esame.Observer.Subject;

import java.util.*;

public class Model implements Subject<Ticket> {
    private int last = 0;
    private int next = 0;

    private List<String> last4 = new ArrayList<>();

    private final List<Observer<Ticket>> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer<Ticket> observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer<Ticket> observer : observers) {
            observer.update(this.getState());
        }
    }

    @Override
    public Ticket getState() {
        return new Ticket(last,next);
    }

    public void serveNext() {
        if (next < last) next++;
        notifyObserver();
    }

    public void getTicket() {
        last++;
        notifyObserver();
    }

    public void newServing(String id, int serving) {
        if (last4.size() >= 4) last4.remove(0);
        last4.add("S" + id + " " + serving);
        notifyObserver();
    }

    public List<String> getLastFour() {
        return last4; // escaping :/
    }
}
