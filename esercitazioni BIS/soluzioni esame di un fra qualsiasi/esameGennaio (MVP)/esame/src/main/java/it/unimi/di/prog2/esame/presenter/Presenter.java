package it.unimi.di.prog2.esame.presenter;



import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;
import it.unimi.di.prog2.esame.view.RoleStrategy;
import it.unimi.di.prog2.esame.view.TicketView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// Ho dovuto dare un nome... se volete implementare il pattern MVC invece di MVP
// per favore modificate il nome della classe e del package in Controller

public class Presenter implements EventHandler<ActionEvent>, Observer<Ticket> {

    private final TicketModel model;
    private final TicketView view;
    private final RoleStrategy strategy;

    public Presenter(TicketModel model, TicketView view, RoleStrategy strategy) {
        this.model = model;
        this.view = view;
        this.strategy = strategy;

        model.addObserver(this);
        view.addHandler(this);
    }

    /*
    VIEW --> MODEL
     */
    @Override
    public void handle(ActionEvent event) {
        strategy.incNumber(model, view.getIdView());
    }

    /*
    MODEL --> VIEW5
     */
    @Override
    public void update(Subject<Ticket> model) {
        strategy.getUpdate(model, view);
    }
}
