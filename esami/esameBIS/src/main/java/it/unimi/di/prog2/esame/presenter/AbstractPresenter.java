package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Question;
import it.unimi.di.prog2.esame.model.QuestionModel;
import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.view.View;

import java.util.List;

public abstract class AbstractPresenter implements Observer<List<Question>> {
    protected final QuestionModel model;
    protected final View view;

    public AbstractPresenter(QuestionModel model, View view) {
        this.model = model;
        model.addObserver(this);

        this.view = view;
        view.addHandlers(this);
    }
}
