package es8.musicamaestro.pt2;

import es7.musicamaestro.MusicalInstrument;

public class InstrumentLoggerObserver implements Observer<MusicalInstrument> {
    @Override
    public void update(Observable<MusicalInstrument> model, MusicalInstrument state) {
        String instrument = model.getState().getClass().getSimpleName();
        System.err.println(instrument + " has been played");
    }
}
