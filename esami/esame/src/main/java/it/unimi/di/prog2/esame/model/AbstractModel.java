package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/*
ho ritenuto opportuno aggiungere la classe AbstractModel in quanto racchiude tutte le operazioni
da implementare richieste dall'interfaccia subject. questo snellisce di molto la classe concreta QuestionModel
e permettere di riutilizzare la classe astratta in diversi contesti.
 */

public abstract class AbstractModel<T> implements Subject<T> {
    private List<Observer<T>> observers = new ArrayList<>();
    T state;

    @Override
    public void addObserver(Observer<T> obs) {
        observers.add(obs);
    }

    @Override
    public void setState(T newstate) {
        if (!state.equals(newstate)) {
            state = newstate;
            notifyObserver();
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer<T> observer : observers) {
            observer.update(this, state);
        }
    }

    @Override
    public T getState() {
        return state;
    }
}
