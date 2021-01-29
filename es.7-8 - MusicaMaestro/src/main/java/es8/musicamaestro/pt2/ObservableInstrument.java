package es8.musicamaestro.pt2;

import es7.musicamaestro.MusicalInstrument;

public class ObservableInstrument extends AbstractObservable<MusicalInstrument> implements MusicalInstrument {
    private MusicalInstrument decoree;

    public ObservableInstrument (MusicalInstrument observee) {
        decoree = observee;
    }

    @Override
    public String play() {
        setState(decoree);
        notifyObservers();
        return decoree.play();
    }
}
