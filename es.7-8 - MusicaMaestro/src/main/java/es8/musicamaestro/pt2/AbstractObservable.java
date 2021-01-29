package es8.musicamaestro.pt2;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObservable<T> implements Observable<T> {
    protected T state; // stato, oggetto osservato
    private List<Observer<T>> observers = new ArrayList<>(); // lista osservatori "registrati"

    @Override
    public void registerObserver(Observer<T> o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer<T> o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer<T> observer : observers) {
            observer.update(this, state); // notifico gli osservatori sia con l'intero modello di questo observable, sia con uno stato preciso. ogni osservatore estrarrà il dato a lui più utile a seconda se opera in modalità pull o push.
        }
    }

    @Override
    public T getState() {
        return state;
    }

    @Override
    public void setState(T value) {
        if (state != value) {  // unica strategia di controllo per il settaggio di un nuovo stato e la notifica degli osservatori è che questo valore sia diverso da quello precedente
            state = value;
            notifyObservers();
        }
    }
}
