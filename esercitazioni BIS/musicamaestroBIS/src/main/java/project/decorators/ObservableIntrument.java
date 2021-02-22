package project.decorators;

import project.instruments.classical.MusicalInstrument;
import project.observerPatternInterfaces.Observer;
import project.observerPatternInterfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class ObservableIntrument implements MusicalInstrument, Subject<MusicalInstrument> {
    private final MusicalInstrument observable;
    private List<Observer<MusicalInstrument>> observers = new ArrayList<>();
    private String state;

    public ObservableIntrument(MusicalInstrument observable) {
        this.observable = observable;
        state = observable.name();
    }

    @Override
    public String play() {
        String temp = observable.play();
        notifyObservers();
        return temp;
    }

    @Override
    public String name() {
        return observable.name();
    }

    @Override
    public void addObserver(Observer<MusicalInstrument> observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<MusicalInstrument> observer : observers) {
            observer.update(this,state);
        }
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void removeObserver(Observer<MusicalInstrument> observer) {
        observers.remove(observer);
    }
}
