package project.instruments.adapted;

import project.instruments.classical.MusicalInstrument;

public class WaterGlassInstrument extends WaterGlass implements MusicalInstrument {

    @Override
    public String play() {
        return tap();
    }

    @Override
    public String name() {
        return "WaterGlass";
    }
}
