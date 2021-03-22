package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.Observer.Observer;
import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.view.TicketView;
import javafx.event.ActionEvent;

public class ConcretePresenter extends Presenter implements Observer<Ticket> {
    private Model model;
    private TicketView view;
    private Role role;

    public ConcretePresenter(Model model, TicketView view, Role role) {
        this.model = model;
        this.view = view;
        this.role = role;

        view.addHandler(this);
        model.addObserver(this);
    }


    @Override
    public void handle(ActionEvent event) { // utente ha fatto qualcosa, model aggiornati di conseguenza al ruolo
        role.doSomething(model);
    }

    @Override
    public void update(Ticket state) { // model cambiato, view aggiornati
        view.set(String.valueOf(role.getInfo(state)));
    }
}
