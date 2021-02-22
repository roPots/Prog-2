package it.unimi.di.prog2.esame.controller;

import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.model.TicketModel;

import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;

import it.unimi.di.prog2.esame.view.RoleStrategy;
import it.unimi.di.prog2.esame.view.TicketView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller implements EventHandler<ActionEvent>, Observer<Ticket> {
  private final TicketModel model;
  private final TicketView view;
  private final RoleStrategy role;

  public Controller(TicketModel m, TicketView v, RoleStrategy r) {
    model = m;
    view = v;
    role = r;
    model.registerObserver(this);
    v.addHandler(this);
  }

  @Override
  public void handle(ActionEvent event) {
    role.incNumber(model);
  }

  @Override
  public void update(Subject<Ticket> model) {
    view.set(String.valueOf(role.getNumber(model)));
  }

}