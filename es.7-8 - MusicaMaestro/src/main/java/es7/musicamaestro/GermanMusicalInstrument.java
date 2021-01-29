package es7.musicamaestro;

public class GermanMusicalInstrument implements MusicalInstrument {
    private final GermanPercussiveInstrument instrument;

    public GermanMusicalInstrument(GermanPercussiveInstrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public String play() {
        return instrument.spiel();
    }
}
