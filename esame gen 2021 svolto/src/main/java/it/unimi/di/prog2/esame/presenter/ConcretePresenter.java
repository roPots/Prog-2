package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.model.Observer;
import it.unimi.di.prog2.esame.model.Subject;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.view.TicketView;
import javafx.event.ActionEvent;

public class ConcretePresenter extends Presenter implements Observer<Ticket> {
    private final TicketView view;
    private final Model model;
    private final Role role;

    public ConcretePresenter(TicketView view, Model model, Role role) {
        this.view = view;
        this.model = model;
        this.role = role;

        view.addHandler(this);
        model.addObserver(this);

        update(model, model.getState());
    }

    @Override
    public void handle(ActionEvent event) {
        role.doSomething(model);
    }

    @Override
    public void update(Subject<Ticket> subject, Object subj_state) {
        view.set(role.getInfo((Model)subject));
    }
}
