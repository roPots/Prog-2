package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.model.Ticket;

public interface Role {
    int getInfo(Ticket t);
    void doSomething(Model model);
}
