package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.model.TicketModel;

public enum PatientStrategy implements RoleStrategy {

    INSTANCE;

    @Override
    public void incNumber(TicketModel model, String id) {
        model.setLast();
    }
}
