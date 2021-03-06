package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.observer.Subject;

public interface RoleStrategy {
  void incNumber(TicketModel m);

  int getNumber(Subject<Ticket> m);
}
