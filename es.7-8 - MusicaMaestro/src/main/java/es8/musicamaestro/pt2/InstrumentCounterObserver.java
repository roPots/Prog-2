package es8.musicamaestro.pt2;

import es7.musicamaestro.MusicalInstrument;

import java.util.HashMap;

public class InstrumentCounterObserver implements Observer<MusicalInstrument> {
    private HashMap<String,Integer> instruments = new HashMap();

    public int getCount (final String name) {
        return instruments.get(name);
    }

    public void resetCount() {
        instruments.clear();
    }

    @Override
    public void update(Observable<MusicalInstrument> model, MusicalInstrument state) {
        String instrument = state.getClass().getSimpleName();
        int val = 1;
        if (instruments.containsKey(instrument)) {
            val = getCount(instrument)+1;
        }
        instruments.put(instrument,val);
    }
}
