package es7.musicamaestro;

public class MusicalInstrumentCounter implements MusicalInstrument {
    private MusicalInstrument decoree;
    private static int counter = 0;

    public MusicalInstrumentCounter(MusicalInstrument decoree) {
        this.decoree = decoree;
    }

    public static int getCounter() {
        int ret = counter;
        return ret;
    }

    public static int resetCounter() {
        counter = 0;
        return getCounter();
    }


    @Override
    public String play() {
        counter++;
        return decoree.play();
    }
}
