package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.presenter.Presenter;

public interface TicketView {
  void addHandler(Presenter handler);

  void set(String s);
}
