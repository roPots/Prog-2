package it.unimi.di.prog2.esame.controller;

import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.model.TicketModel;

import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;

import it.unimi.di.prog2.esame.view.RoleStrategy;
import it.unimi.di.prog2.esame.view.TicketView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// controller generico che gestisce flusso di informazioni sia per Customer-Model che per Clerk-model
public class Controller implements EventHandler<ActionEvent>, Observer<Ticket> {
  private final TicketModel model; // il modello su cui si registrerà in ascolto il presenter
  private final TicketView view; // la vista alla quale passerà e riceverà aggiornamenti a seconda dell'user input
  private final RoleStrategy role; // la strategia con cui comunico queste informazione (se customer oppure clerk)

  public Controller(TicketModel m, TicketView v, RoleStrategy r) {
    model = m;
    view = v;
    role = r;
    model.registerObserver(this); // registro presenter per osservare il modello e reagire alle sue eventuali modifiche
    view.addHandler(this); // assegno presenter come gestore degli eventi scaturiti dagli elementi della vista con cui l'utente interagirà
  }

  //TODO realizzare i metodi mancanti per soddisfare le interfacce implementate

  @Override // MODEL --> VIEW : passo le informazioni su modifiche del model alla vista affinché questa si aggiorni
  public void update(Subject<Ticket> model) {
    view.set(String.valueOf(role.getNumber(model)));
  }

  @Override // VIEW --> MODEL : reagisco a evento della vista per aggiornare il modello di conseguenza
  public void handle(ActionEvent event) {
    role.incNumber(model);
  }
}