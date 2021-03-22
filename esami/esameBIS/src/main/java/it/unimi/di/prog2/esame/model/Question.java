package it.unimi.di.prog2.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Question implements Comparable<Question> {
    private final String question;
    private int score;

    public Question(String question, int score) {
        this.question = question;
        this.score = score;
    }

    public Question(Question original) { // copy constructor
        this.question = original.question;
        this.score = original.score;
    }

    public void vote() {
        score++;
    }

    @Override
    public int compareTo(@NotNull Question q) {
        return this.score - q.score;
    }

    @Override
    public String toString() {
        return question + ": " + score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question2 = (Question) o;
        return score == question2.score && this.question.equals(question2.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, score);
    }
}
