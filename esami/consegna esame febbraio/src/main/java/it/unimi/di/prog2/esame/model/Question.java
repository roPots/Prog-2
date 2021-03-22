package it.unimi.di.prog2.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Question {
    private final String domanda;
    private int voto = 1;

    public Question(String domanda) {
        this.domanda = domanda;
    }

    public void vote() { voto++; }

    @Override
    public String toString() {
        return domanda + ": " + voto;
    }

    public int compareTo(@NotNull Question q) {
        return this.voto - q.voto;
    }
}
