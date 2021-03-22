package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Question;
import it.unimi.di.prog2.esame.model.QuestionModel;
import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;
import it.unimi.di.prog2.esame.view.PersonalView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PersonalViewPresenter implements Observer<List<Question>> {
  private final QuestionModel model;
  private final PersonalView view;

  public PersonalViewPresenter(@NotNull PersonalView view, @NotNull QuestionModel model) {
    this.view = view;
    view.addHandlers(this);

    this.model = model;
    model.addObserver(this);
  }

  public void addQuestion(@NotNull String s) {
    // System.err.println("nuova domanda: " + s);
    model.newQuestion(s);
  }

  public void voteQuestion(int i) {
    // System.err.println("voto per " + i);
    model.vote(i);
  }

  @Override
  public void update(Subject<List<Question>> model, List<Question> state) {
    List<String> questions = ((QuestionModel)model).questionsByEntry();

    for (int i = 0; i < questions.size(); i++) {
      // (con voto)
      //view.set(i, questions.get(i));

      // (senza voto)
      String s = questions.get(i);
      view.set(i, s.substring(0,s.indexOf(":")));
    }
  }
}
