package project.observers;

import project.instruments.classical.MusicalInstrument;
import project.observerPatternInterfaces.Observer;
import project.observerPatternInterfaces.Subject;

public class InstrumentLoggerObserver implements Observer<MusicalInstrument> {
    @Override
    public void update(Subject<MusicalInstrument> model, Object state) {
        System.err.println(model.getState());
    }
}
