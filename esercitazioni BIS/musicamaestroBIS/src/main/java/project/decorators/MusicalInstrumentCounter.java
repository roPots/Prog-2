package project.decorators;

import project.instruments.classical.MusicalInstrument;

public class MusicalInstrumentCounter implements MusicalInstrument {
    private final MusicalInstrument decoree;
    private static int counter = 0;

    public MusicalInstrumentCounter(MusicalInstrument decore) {
        this.decoree = decore;
    }

    @Override
    public String play() {
        counter++;
        return decoree.play();
    }

    @Override
    public String name() {
        return name();
    }

    public static int getCount() {
        return counter;
    }

    public static int resetCount() {
        counter = 0;
        return counter;
    }
}
