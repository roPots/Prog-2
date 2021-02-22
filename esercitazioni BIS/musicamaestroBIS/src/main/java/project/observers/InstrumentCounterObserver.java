package project.observers;

import project.instruments.classical.MusicalInstrument;
import project.observerPatternInterfaces.Observer;
import project.observerPatternInterfaces.Subject;

import java.util.HashMap;
import java.util.Map;

public class InstrumentCounterObserver implements Observer<MusicalInstrument> {
    private Map<String,Integer> map = new HashMap<>();

    @Override
    public void update(Subject<MusicalInstrument> model, Object state) {
        map.put((String) state,map.getOrDefault(state,0)+1);
    }

    public int getCount(String name) {
        return map.getOrDefault(name,0);
    }

    public void resetCount() {
        map.clear();
    }
}
