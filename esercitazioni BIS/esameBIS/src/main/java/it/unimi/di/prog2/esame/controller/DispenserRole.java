package it.unimi.di.prog2.esame.controller;

import it.unimi.di.prog2.esame.model.Model;

public enum DispenserRole implements Role {
    INSTANCE;

    @Override
    public void doSomething(Model model) {
        model.getTicket();
    }
}
