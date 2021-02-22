package it.unimi.di.prog2.esame.controller;

import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.view.TicketView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Controller implements EventHandler<MouseEvent> {
    private final TicketView view;
    private final Model model;
    private final Role role;

    public Controller(TicketView view, Model model, Role role) {
        this.view = view;
        this.model = model;
        this.role = role;

        view.addHandler(this);
    }

    @Override
    public void handle(MouseEvent event) {
        role.doSomething(model);
    }
}
