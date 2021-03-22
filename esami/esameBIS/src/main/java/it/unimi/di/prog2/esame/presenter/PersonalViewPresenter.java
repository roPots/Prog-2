package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Question;
import it.unimi.di.prog2.esame.model.QuestionModel;
import it.unimi.di.prog2.esame.observer.Subject;
import it.unimi.di.prog2.esame.view.PersonalView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PersonalViewPresenter extends AbstractPresenter {

    public PersonalViewPresenter(QuestionModel model, PersonalView view) {
        super(model, view);
    }

    public void addQuestion(String s) {
        model.addQuestion(new Question(s,1));
    }

    public void voteQuestion(int i) {
        model.voteQuestion(i);
    }

    @Override
    public void update(Subject<List<Question>> model, List<Question> state) {

        List<String> questions = this.model.questionsByEntry();
        for (int i = 0; i < questions.size(); i++) {
            String q = questions.get(i);
            q = q.substring(0,q.indexOf((":")));
            view.set(i,q);
        }
    }
}
