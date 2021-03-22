package it.unimi.di.prog2.esame.model;

import java.util.*;

public class QuestionModel extends AbstractModel<List<Question>> {
    public final static int MAX_QUESTION = 6;

    private List<Question> state = new ArrayList<>();

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
    public List<Question> getState() {
        List<Question> copy = new ArrayList<>();
        copy.addAll(state);

        return copy;
    }

    private List<Question> sortedQuestions() {
        List<Question> sorted = getState();

        sorted.sort(null);

        return sorted;

    }
}
