package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.model.TicketModel;

public enum OfficeStrategy implements RoleStrategy {

    INSTANCE;

    @Override
    public void incNumber(TicketModel model, String id) {
        model.setNext(id);
    }
}
