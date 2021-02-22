package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.observer.Subject;

public enum PatientStrategy implements RoleStrategy {

    INSTANCE;

    @Override
    public void incNumber(TicketModel model, String id) {
        model.setLast();
    }

    @Override
    public void getUpdate(Subject<Ticket> model, TicketView view) {
        view.set(String.valueOf(model.getState().getLast()));
    }
}
