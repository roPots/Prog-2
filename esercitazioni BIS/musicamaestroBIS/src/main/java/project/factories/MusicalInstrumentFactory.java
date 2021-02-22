package project.factories;

import project.instruments.adapted.WaterGlassInstrument;
import project.instruments.adapted.german.GermanMusicalInstrument;
import project.instruments.adapted.german.IronRod;
import project.instruments.classical.Horn;
import project.instruments.classical.MusicalInstrument;
import project.instruments.classical.Trumpet;

public class MusicalInstrumentFactory implements AbstractInstrumentFactory {
    @Override
    public MusicalInstrument createTrumpet() {
        return new Trumpet();
    }

    @Override
    public MusicalInstrument createHorn() {
        return new Horn();
    }

    @Override
    public MusicalInstrument createWaterGlass() {
        return new WaterGlassInstrument();
    }

    @Override
    public MusicalInstrument createIronRod() {
        return new GermanMusicalInstrument(new IronRod());
    }
}
