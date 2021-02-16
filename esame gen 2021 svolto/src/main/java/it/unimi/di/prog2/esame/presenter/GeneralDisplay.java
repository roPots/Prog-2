package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Model;

public enum GeneralDisplay implements Role {
    INSTANCE;

    @Override
    public void doSomething(Model model) {
        // do nothing (can't happen)
    }

    @Override
    public String getInfo(Model model) {
        return model.lastServing();
    }
}
