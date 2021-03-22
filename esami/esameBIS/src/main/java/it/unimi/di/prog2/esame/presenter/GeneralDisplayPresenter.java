package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Question;
import it.unimi.di.prog2.esame.model.QuestionModel;
import it.unimi.di.prog2.esame.observer.Subject;
import it.unimi.di.prog2.esame.view.GeneralDisplayView;
import it.unimi.di.prog2.esame.view.View;

import java.util.Collections;
import java.util.List;

public class GeneralDisplayPresenter extends AbstractPresenter {

    public GeneralDisplayPresenter(QuestionModel model, GeneralDisplayView view) {
        super(model, view);
    }

    @Override
    public void update(Subject<List<Question>> model, List<Question> state) {
        List<String> questions = this.model.questionsByScore();
        Collections.reverse(questions);
        for (int i = 0; i < questions.size(); i++) {
            view.set(i,questions.get(i));
        }
    }
}
