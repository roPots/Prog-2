package project.factories;

import project.decorators.MusicalInstrumentCounter;
import project.instruments.adapted.WaterGlassInstrument;
import project.instruments.adapted.german.GermanMusicalInstrument;
import project.instruments.adapted.german.IronRod;
import project.instruments.classical.Horn;
import project.instruments.classical.MusicalInstrument;
import project.instruments.classical.Trumpet;

public class CountedMusicaInstrumentFactory implements AbstractInstrumentFactory {
    @Override
    public MusicalInstrument createTrumpet() {
        return new MusicalInstrumentCounter(new Trumpet());
    }

    @Override
    public MusicalInstrument createHorn() {
        return new MusicalInstrumentCounter(new Horn());
    }

    @Override
    public MusicalInstrument createWaterGlass() {
        return new MusicalInstrumentCounter(new WaterGlassInstrument());
    }

    @Override
    public MusicalInstrument createIronRod() { return new MusicalInstrumentCounter( new GermanMusicalInstrument(new IronRod())); }
}
