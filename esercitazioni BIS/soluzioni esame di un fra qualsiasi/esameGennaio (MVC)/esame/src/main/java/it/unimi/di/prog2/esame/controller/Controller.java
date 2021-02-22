package it.unimi.di.prog2.esame.controller;



import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.view.RoleStrategy;
import it.unimi.di.prog2.esame.view.TicketView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// Ho dovuto dare un nome... se volete implementare il pattern MVC invece di MVP
// per favore modificate il nome della classe e del package in Controller

public class Controller implements EventHandler<ActionEvent> {

    private final TicketModel model;
    private final TicketView view;
    private final RoleStrategy strategy;

    public Controller(TicketModel model, TicketView view, RoleStrategy strategy) {
        this.model = model;
        this.view = view;
        this.strategy = strategy;

        view.addHandler(this);
    }

    public void updateModel() {
        strategy.incNumber(model, view.getIdView());
    }

    @Override
    public void handle(ActionEvent event) {
        updateModel();
    }
}
