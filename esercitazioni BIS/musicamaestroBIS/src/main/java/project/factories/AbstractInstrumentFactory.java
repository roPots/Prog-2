package project.factories;

import project.instruments.classical.MusicalInstrument;

public interface AbstractInstrumentFactory {
    MusicalInstrument createTrumpet();
    MusicalInstrument createHorn();
    MusicalInstrument createWaterGlass();
    MusicalInstrument createIronRod();
}
