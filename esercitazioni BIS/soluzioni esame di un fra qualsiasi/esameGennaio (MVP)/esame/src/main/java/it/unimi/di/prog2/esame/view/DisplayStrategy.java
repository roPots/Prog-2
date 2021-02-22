package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.observer.Subject;

public enum DisplayStrategy implements RoleStrategy {

    INSTANCE;

    @Override
    public void incNumber(TicketModel model, String id) {
    }

    @Override
    public void getUpdate(Subject<Ticket> model, TicketView view) {
        String idOffice = model.getState().getIdOffice();
        String ticketCalled = String.valueOf(model.getState().getNext());
        String s = "S"+ idOffice+ " "+ticketCalled;

        if (idOffice != null) view.set(s);
    }
}
