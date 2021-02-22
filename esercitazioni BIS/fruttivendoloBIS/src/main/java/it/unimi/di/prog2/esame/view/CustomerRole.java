package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.observer.Subject;

public enum CustomerRole implements RoleStrategy {
  INSTANCE;

  @Override
  public void incNumber(TicketModel m) {
    m.getTicket();
  }

  @Override
  public int getNumber(Subject<Ticket> m) {
    return m.getState().getLastInQueue();
  }
}
