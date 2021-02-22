package project;

import project.instruments.classical.MusicalInstrument;

import java.util.ArrayList;
import java.util.List;

public class Orchestra implements MusicalInstrument {
    private List<MusicalInstrument> orchestra = new ArrayList<>();

    public void addInstrument(MusicalInstrument instrument) {
        orchestra.add(instrument);
    }

    @Override
    public String play() {
        StringBuffer sb = new StringBuffer();
        for (MusicalInstrument instrument : orchestra) {
            sb.append(instrument.play()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String name() {
        StringBuffer sb = new StringBuffer();
        for (MusicalInstrument instrument : orchestra) {
            sb.append(instrument.name()).append("\n");
        }
        return sb.toString();
    }

    public MusicalInstrument getInstrument(int i) {
        return orchestra.get(i);
    }
}
