package es8.musicamaestro.pt2;

import es7.musicamaestro.MusicalInstrument;

import java.util.List;

public class ObservedInstrumentFactory implements AbstractInstrumentFactory {
    private MusicalInstrumentFactory factory = new MusicalInstrumentFactory();
    private List<Observer<MusicalInstrument>> observers;

    public ObservedInstrumentFactory(List<Observer<MusicalInstrument>> observers) {
        this.observers = observers;
    }

    @Override
    public MusicalInstrument createInstrument(String instrument) {
        ObservableInstrument observed = new ObservableInstrument(factory.createInstrument(instrument));
        for (Observer<MusicalInstrument> observer : observers) {
            observed.registerObserver(observer);
        }
        return observed;
    }
}
