package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class TicketModel implements Subject<Ticket> {
  private int last = 0;
  private int next = 0;
  private final List<Observer<Ticket>> observers = new ArrayList<>();

  // presenter comunica a model che view (utente) a servito un cliente e dunque a consumato un ticket
  public void serveNext() {
    if (next < last) { // se coda cliente è esaurita non incremento il numero del prossimo cliente da servire
      next++;
      notifyObservers(); // una volta modificato il modello devo avvisare (il presenter) del cambio di stato affinché la vista si aggiorni
    }
  }

  // presenter comunica a model che view (utente) ha preso un nuovo ticket (c'è un nuovo cliente da servire)
  public void getTicket() {
    last ++;
    notifyObservers();
  }

  @Override
  public void registerObserver(Observer<Ticket> o) {
    observers.add(o);
  }


  //TODO parlando del pattern Observer dire se stiamo usando modalità push o pull
  // la modalità usata è pull, in quanto il subject restituisce il suo intero modello affinché l'observer possa estrarre le informazioni che desidera
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
