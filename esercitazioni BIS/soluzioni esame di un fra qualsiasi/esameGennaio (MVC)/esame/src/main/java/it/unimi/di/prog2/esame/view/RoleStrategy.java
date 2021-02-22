package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.model.TicketModel;

public interface RoleStrategy {
    void incNumber(TicketModel model, String id);
}
