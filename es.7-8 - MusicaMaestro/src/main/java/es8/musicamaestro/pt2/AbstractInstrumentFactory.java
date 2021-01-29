package es8.musicamaestro.pt2;

import es7.musicamaestro.MusicalInstrument;

public interface AbstractInstrumentFactory {
    MusicalInstrument createInstrument(String instrument);
}
