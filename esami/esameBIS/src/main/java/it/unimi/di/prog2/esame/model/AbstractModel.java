package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.observer.Observer;
import it.unimi.di.prog2.esame.observer.Subject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModel<T> implements Subject<T> {
    private List<Observer<T>> observers = new ArrayList<>();
    protected T state;

    @Override
    public void addObserver(Observer<T> obs) {
        observers.add(obs);
    }

    @Override
    public void setState(@NotNull T new_state) {
        if (!state.equals(new_state)) {
            state = new_state;
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer<T> observer : observers) {
            observer.update(this, state);
        }
    }

    @Override
    public void removeObserver(Observer<T> obs) {
        observers.remove(obs);
    }

    @Override
    public T getState() {
        return state;
    }
}
