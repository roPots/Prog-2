package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.model.Ticket;

public class Sportello implements Role {
    private String id;
    private int serving;

    public Sportello(String id) {
        this.id=id;
    }

    @Override
    public int getInfo(Ticket t) {
        return serving;  // sportello vuole sapere qual'è il cliente che sta servendo
    }

    @Override
    public void doSomething(Model m) {
        serving = m.getState().getNext();
        m.newServing(id,serving);
        m.serveNext();  // sportello incrementa serve cliente


    }
}
