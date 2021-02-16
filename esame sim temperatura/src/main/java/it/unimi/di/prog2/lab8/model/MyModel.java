package it.unimi.di.prog2.lab8.model;

import it.unimi.di.prog2.lab8.observer.Observer;
import it.unimi.di.prog2.lab8.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class MyModel implements Model,Subject {
    private double temperature = 0;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public double getTemp() {
        return temperature;
    }


    @Override
    public void setTemp(double temp) {
        if (temp != temperature) {
            temperature = temp;
            notifyObservers();
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this,temperature);
        }
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public Object getState() {
        return getTemp();
    }
}
