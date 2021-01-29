package es7.musicamaestro;

public class WaterGlassInstrument extends WaterGlass implements MusicalInstrument {

    @Override
    public String play() {
        return this.tap();
    }
}
