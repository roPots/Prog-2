package es7.musicamaestro;

import es8.musicamaestro.pt2.*;

import java.util.ArrayList;
import java.util.List;

public class Orchestra implements MusicalInstrument {
    private final ArrayList<MusicalInstrument> orchestra = new ArrayList<>();

    public void add(MusicalInstrument new_instrument) {
        orchestra.add(new_instrument);
    }

    @Override
    public String play() {
        StringBuilder sb = new StringBuilder();
        for (MusicalInstrument instrument : orchestra) {
            sb.append(instrument.play()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MusicalInstrumentFactory factory = new MusicalInstrumentFactory();
        Orchestra myOrchestra = new Orchestra();

        //        myOrchestra.add(new Trumpet());
        //        myOrchestra.add(new MusicalInstrumentCounter(new Horn()));
        //        myOrchestra.add(new WaterGlassInstrument());
        //        myOrchestra.add(new MusicalInstrumentCounter(new GermanMusicalInstrument(new IronRod())));
        //
        //        ObservableInstrument ob = new ObservableInstrument(new Trumpet());
        //        InstrumentCounterObserver counter = new InstrumentCounterObserver();
        //        ob.registerObserver(counter);
        //        ob.registerObserver(new InstrumentLoggerObserver());
        //        myOrchestra.add(ob);
        //
        //        ObservableInstrument ob2 = new ObservableInstrument(new GermanMusicalInstrument(new IronRod()));
        //        ob2.registerObserver(counter);
        //        myOrchestra.add(ob2);
        //
        //        while (MusicalInstrumentCounter.getCounter()<5) {
        //            System.out.println(myOrchestra.play());
        //        }
        //
        //        System.out.println(counter.getCount("Trumpet"));
        //        System.out.println(counter.getCount("GermanMusicalInstrument"));

        myOrchestra.add(factory.createInstrument("WaterGlass"));

        CountedInstrumentFactory counted_factory = new CountedInstrumentFactory();
        myOrchestra.add(counted_factory.createInstrument("Horn"));

        System.out.println(myOrchestra.play());
        System.out.println(MusicalInstrumentCounter.getCounter());

        List<Observer<MusicalInstrument>> observers = new ArrayList<>() {};
        observers.add(new InstrumentCounterObserver());
        observers.add(new InstrumentLoggerObserver());
        ObservedInstrumentFactory observed_factory = new ObservedInstrumentFactory(observers);
        myOrchestra.add(observed_factory.createInstrument("Trumpet"));
        myOrchestra.add(observed_factory.createInstrument("IronRod"));

        System.out.println(myOrchestra.play());
        System.out.println(MusicalInstrumentCounter.getCounter());

        System.out.println("Trumpet has played times: "+((InstrumentCounterObserver) observers.get(0)).getCount("Trumpet"));
        System.out.println("which is absolutely false");
    }
}
