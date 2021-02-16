package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Model;

public class Sportello implements Role {
    private final String id;
    private int serving = 0;

    public Sportello(String id) {
        this.id = id;
    }

    @Override
    public void doSomething(Model model) {
        if (model.hasNext()) {
            serving = model.getNextInCue();
            model.serveClient(id);
        }
    }

    @Override
    public String getInfo(Model model) {
        return "S" + id + " " + serving;
    }
}
