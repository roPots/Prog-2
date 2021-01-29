package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.observer.Subject;

public enum CustomerRole implements RoleStrategy {
  //TODO a quale pattern vi fa pensare la riga successiva? Spiegarlo.
  // singleton. in java la sua migliore implementazione è ottenuta tramite un enum con una singola istanza.
  // il signleton è utile in questo caso in quanto vogliamo che esista una sola istanza di strategia, averne molteplici non ha senso.
  INSTANCE;

  @Override
  public void incNumber(TicketModel m) {
    m.getTicket();
  } // customer prende un nuovo biglietto, si aggiunge alla coda

  @Override
  public int getNumber(Subject<Ticket> m) {
    return m.getState().getLastInQueue(); // customer vuole sapere qual'è la sua posizione nella coda
  }
}
