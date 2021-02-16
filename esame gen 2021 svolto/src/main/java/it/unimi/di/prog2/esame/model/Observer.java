package it.unimi.di.prog2.esame.model;

public interface Observer<T> {
    void update(Subject<T> subject, Object subj_state);
}
