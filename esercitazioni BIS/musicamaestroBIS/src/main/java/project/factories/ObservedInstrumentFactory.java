package project.factories;

import project.decorators.ObservableIntrument;
import project.instruments.adapted.WaterGlassInstrument;
import project.instruments.adapted.german.GermanMusicalInstrument;
import project.instruments.adapted.german.IronRod;
import project.instruments.classical.Horn;
import project.instruments.classical.MusicalInstrument;
import project.instruments.classical.Trumpet;
import project.observerPatternInterfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObservedInstrumentFactory implements AbstractInstrumentFactory {
    private final List<Observer<MusicalInstrument>> observers;

    public ObservedInstrumentFactory(List<Observer<MusicalInstrument>> observers) {
        this.observers = observers;
    }

    @Override
    public MusicalInstrument createTrumpet() {
        ObservableIntrument temp = new ObservableIntrument(new Trumpet());
        observe(temp);
        return temp;
    }

    @Override
    public MusicalInstrument createHorn() {
        ObservableIntrument temp = new ObservableIntrument(new Horn());
        observe(temp);
        return temp;
    }

    @Override
    public MusicalInstrument createWaterGlass() {
        ObservableIntrument temp = new ObservableIntrument(new WaterGlassInstrument());
        observe(temp);
        return temp;
    }

    @Override
    public MusicalInstrument createIronRod() {
        ObservableIntrument temp = new ObservableIntrument(new GermanMusicalInstrument(new IronRod()));
        observe(temp);
        return temp;
    }

    private void observe(ObservableIntrument instrument) {
        for (Observer<MusicalInstrument> observer : observers) {
            instrument.addObserver(observer);
        }
    }
}
