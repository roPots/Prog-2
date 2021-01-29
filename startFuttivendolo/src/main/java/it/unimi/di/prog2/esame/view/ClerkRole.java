package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.observer.Subject;

public enum ClerkRole implements RoleStrategy {
  INSTANCE;

  //TODO realizzare i metodi mancanti per soddisfare le interfacce implementate

  @Override
  public void incNumber(TicketModel m) {
    m.serveNext(); // clerk serve un cliente dunque consuma un ticket e si prepara a servire il prossimo
  }

  @Override
  public int getNumber(Subject<Ticket> m) {
    return m.getState().getNextToServe(); // clerk vuole sapere qual'è il prossimo cliente da servire
  }
}
