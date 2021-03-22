package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Question;
import it.unimi.di.prog2.esame.model.QuestionModel;
import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;
import it.unimi.di.prog2.esame.view.GeneralDisplayView;

import java.util.Collections;
import java.util.List;

public class GeneralDisplayPresenter implements Observer<List<Question>> {
    private final QuestionModel model;
    private final GeneralDisplayView view;

    public GeneralDisplayPresenter(GeneralDisplayView view, QuestionModel model) {
        this.model = model;
        model.addObserver(this);

        this.view = view;
    }

    @Override
    public void update(Subject<List<Question>> model, List<Question> state) {
        List<String> questions = ((QuestionModel)model).questionsByVotes();

        Collections.reverse(questions);

        for (int i = 0; i < questions.size(); i++) {
            view.set(i, questions.get(i));
        }
    }
}
