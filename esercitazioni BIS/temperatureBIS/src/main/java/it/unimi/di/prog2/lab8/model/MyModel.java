package it.unimi.di.prog2.lab8.model;

import it.unimi.di.prog2.lab8.observer.Observer;
import it.unimi.di.prog2.lab8.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class MyModel implements Subject<Double> {
    private List<Observer<Double>> observers = new ArrayList<>();
    private Double temperature = Double.valueOf(0);

    @Override
    public void notifyObservers() {
        for (Observer<Double> observer : observers) {
            observer.update(this,temperature);
        }
    }

    @Override
    public void addObserver(Observer<Double> obs) {
        observers.add(obs);
    }

    @Override
    public Double getState() {
        return temperature;
    }

    public void setTemp(double v) {
        if (!temperature.equals(v)) {
            temperature = v;
            notifyObservers();
        }
    }
}
