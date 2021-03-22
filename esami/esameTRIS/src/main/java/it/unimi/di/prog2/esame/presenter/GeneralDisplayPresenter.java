package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Question;
import it.unimi.di.prog2.esame.model.QuestionModel;
import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;
import it.unimi.di.prog2.esame.view.GeneralDisplayView;

import java.util.Collections;
import java.util.List;

// !! si sarebbe potuto fare una classe astratta per generalizzare i presenter
// vedi esameBIS

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
        // in realtà si sarebbe potuto usare l'attributo model della classe, per fortificare la dipendenza (ed evitare il downcasting)

        Collections.reverse(questions);

        for (int i = 0; i < questions.size(); i++) {
            view.set(i, questions.get(i));
        }
    }
}
