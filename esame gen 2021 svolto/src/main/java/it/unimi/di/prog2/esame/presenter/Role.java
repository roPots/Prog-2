package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Model;

public interface Role {
    void doSomething(Model model);
    String getInfo(Model model);
}
