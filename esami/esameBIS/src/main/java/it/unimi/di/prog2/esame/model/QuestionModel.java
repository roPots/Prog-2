package it.unimi.di.prog2.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionModel extends AbstractModel<List<Question>> {
    private List<Question> questions = new ArrayList<>();
    private final int MAX_QUESTIONS = 6;

    public QuestionModel() {
        state = questions;
    }

    public void addQuestion(@NotNull Question question) {
        if (questions.size() < MAX_QUESTIONS) {
            questions.add(question);
            System.err.println("question n°" + questions.size() + " added");
            notifyObserver();
        } else System.err.println("can't add more than " + MAX_QUESTIONS + " questions");
    }

    public void voteQuestion(int i) {
        if (i < questions.size()) {
            questions.get(i).vote();
            System.err.println("voted question n°"+(i+1));
            notifyObserver();
        } else System.err.println("invalid question");
    }

    public List<String> questionsByScore() {
        List<Question> temp = getState();
        Collections.sort(temp); // can do because Question implements Comparable<Question>

        return questionToStringList(temp);
    }

    public List<String> questionsByEntry() {
        return questionToStringList(questions);
    }

    private static List<String> questionToStringList(List<Question> list) {
        List<String> ret = new ArrayList<>();

        for (Question question : list) {
            ret.add(question.toString());
        }

        return ret;
    }

    @Override
    public List<Question> getState() { // deep copy returned!
        List<Question> ret = new ArrayList<>();

        for (Question question : questions) {
            ret.add(new Question(question));
        }

        return ret;
    }
}
