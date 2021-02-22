package project.instruments.adapted.german;

import project.instruments.classical.MusicalInstrument;

public class GermanMusicalInstrument implements MusicalInstrument {
    private final GermanPercussiveInstrument adaptee;

    public GermanMusicalInstrument(GermanPercussiveInstrument adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String play() {
        return adaptee.spiel();
    }

    @Override
    public String name() {
        return adaptee.getClass().getSimpleName();
    }
}
