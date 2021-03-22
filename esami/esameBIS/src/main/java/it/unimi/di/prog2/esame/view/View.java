package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.presenter.AbstractPresenter;

public interface View {
    void set(int i, String question);
    void addHandlers(AbstractPresenter presenter);
}
