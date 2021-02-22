package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class TicketModel implements Subject<Ticket> {
  private int last = 0;
  private int next = 0;
  private final List<Observer<Ticket>> observers = new ArrayList<>();


  public void serveNext() {
    if (next < last ) next++;
    notifyObservers();
  }

  public void getTicket() {
    last++;
    notifyObservers();
  }

  @Override
  public void registerObserver(Observer<Ticket> o) {
    observers.add(o);
  }


  @Override
  public void notifyObservers() {
    for (Observer<Ticket> observer : observers) {
      observer.update(this);
    }
  }

  @Override
  public Ticket getState() {
    return new Ticket(last, next);
  }
}
