package es8.musicamaestro.pt2;

import es7.musicamaestro.*;

import java.util.ArrayList;
import java.util.List;

public class MusicalInstrumentFactory implements AbstractInstrumentFactory {

    @Override
    public MusicalInstrument createInstrument(String instrument) {
        return switch (instrument) {
            case "Horn" -> new Horn();
            case "IronRod" -> new GermanMusicalInstrument(new IronRod());
            case "WaterGlass" -> new WaterGlassInstrument();
            default -> new Trumpet();
        };
    }
}

