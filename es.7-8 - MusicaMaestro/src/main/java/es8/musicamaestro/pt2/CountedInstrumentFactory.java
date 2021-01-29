package es8.musicamaestro.pt2;

import es7.musicamaestro.MusicalInstrument;
import es7.musicamaestro.MusicalInstrumentCounter;

public class CountedInstrumentFactory implements AbstractInstrumentFactory {
    private MusicalInstrumentFactory factory = new MusicalInstrumentFactory();

    @Override
    public MusicalInstrument createInstrument(String instrument) {
        return new MusicalInstrumentCounter(factory.createInstrument(instrument));
    }
}
