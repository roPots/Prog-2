package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.observer.Subject;

public enum OfficeStrategy implements RoleStrategy {

    INSTANCE;

    @Override
    public void incNumber(TicketModel model, String id) {
        model.setNext(id);
    }

    @Override
    public void getUpdate(Subject<Ticket> model, TicketView view) {
        String idOffice = model.getState().getIdOffice();

        if (idOffice != null && idOffice.equals(view.getIdView())) view.set(String.valueOf(model.getState().getNext()));
    }
}
