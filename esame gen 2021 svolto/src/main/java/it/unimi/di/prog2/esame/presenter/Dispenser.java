package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Model;

public enum Dispenser implements Role {
    INSTANCE;

    @Override
    public void doSomething(Model model) {
        model.getTicket();
    }

    @Override
    public String getInfo(Model model) {
        return String.valueOf(model.getLastInCue());
    }
}
