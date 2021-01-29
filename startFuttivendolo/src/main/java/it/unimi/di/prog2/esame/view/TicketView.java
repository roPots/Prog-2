package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.controller.Controller;

public interface TicketView {
  void addHandler(Controller handler);

  void set(String s);
}
