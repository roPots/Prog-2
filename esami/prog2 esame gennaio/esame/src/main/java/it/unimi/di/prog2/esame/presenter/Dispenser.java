package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.model.Ticket;

public enum Dispenser implements Role {
    INSTANCE;

    @Override
    public int getInfo(Ticket t) {
        return t.getLast(); // dispenser vuole mostrare a cliente qual'è il prossimo numero disponibile
    }

    @Override
    public void doSomething(Model m) {
        m.getTicket(); // un cliente ha preso il biglietto
    }
}
