package it.unimi.di.prog2.esame.model;

import java.util.*;

public class QuestionModel extends AbstractModel<List<Question>> {
    public final static int MAX_QUESTION = 6;

    private List<Question> state = new ArrayList<>(); // non ha molto senso chiamarlo state, se non per esplicitare il suo utilizzo
                                                      // dovrei aver ereditato l'attributo state da classe padre, ma posso sovrascriverlo, perché?
                                                      // forse perché non inizializzato da un costruttore, dunque possibile sovrascriverlo con istanze di oggetti figli
                                                      // in ogni caso era preferibile inizializzarlo all'interno di un costruttore, piuttosto che ridichiararlo.
                                                      // vedi esameBIS

    public void newQuestion(String s) {
        if (state.size() < MAX_QUESTION) {
            state.add(new Question(s));

            notifyObserver();
        }
        else System.err.println("non è possibile aggiungere domande");
    }

    public void vote(int i) {
        if (i < state.size()) {
            state.get(i).vote();
            notifyObserver();
        } else System.err.println("domanda inesistente");
    }

    public List<String> questionsByVotes() {
        List<String> ret = new ArrayList<>();

        for (Question question : sortedQuestions()) {
            ret.add(question.toString());
        }

        return ret;
    }

    public List<String> questionsByEntry() {
        List<String> ret = new ArrayList<>();

        for (Question question : getState()) {
            ret.add(question.toString());
        }

        return ret;
    }

    @Override
    public List<Question> getState() { // non una deep copy, serve copy constructor per quello
        List<Question> copy = new ArrayList<>();
        copy.addAll(state);

        return copy;
    }

    private List<Question> sortedQuestions() {
        List<Question> sorted = getState();

        Collections.sort(sorted,(d1,d2)-> d1.compareTo(d2)); // si poteva sostituire con il semplice sort(sorted) se card implementava comparable

        return sorted;

    }
}
