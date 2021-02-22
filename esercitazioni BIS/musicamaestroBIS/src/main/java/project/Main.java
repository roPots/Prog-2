package project;

import project.decorators.MusicalInstrumentCounter;
import project.factories.CountedMusicaInstrumentFactory;
import project.factories.MusicalInstrumentFactory;
import project.factories.ObservedInstrumentFactory;
import project.instruments.classical.MusicalInstrument;
import project.observerPatternInterfaces.Observer;
import project.observers.InstrumentCounterObserver;
import project.observers.InstrumentLoggerObserver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Orchestra myOrchestra = new Orchestra();

        MusicalInstrumentFactory myFactory = new MusicalInstrumentFactory();

        CountedMusicaInstrumentFactory myCountedFactory = new CountedMusicaInstrumentFactory();

        List<Observer<MusicalInstrument>> observers = new ArrayList<>();
        InstrumentCounterObserver myCounterObserver = new InstrumentCounterObserver();
        observers.add(myCounterObserver);
        observers.add(new InstrumentLoggerObserver());
        ObservedInstrumentFactory myObservedFactory = new ObservedInstrumentFactory(observers);

        myOrchestra.addInstrument(myFactory.createTrumpet());
        myOrchestra.addInstrument(myFactory.createHorn());
        myOrchestra.addInstrument(myFactory.createWaterGlass());
        myOrchestra.addInstrument((myFactory.createIronRod()));

        myOrchestra.addInstrument(myCountedFactory.createTrumpet());
        myOrchestra.addInstrument(myCountedFactory.createHorn());
        myOrchestra.addInstrument(myCountedFactory.createWaterGlass());
        myOrchestra.addInstrument(myCountedFactory.createIronRod());

        myOrchestra.addInstrument(myObservedFactory.createTrumpet());
        myOrchestra.addInstrument(myObservedFactory.createHorn());
        myOrchestra.addInstrument(myObservedFactory.createWaterGlass());
        myOrchestra.addInstrument(myObservedFactory.createIronRod());

        myOrchestra.play();
        System.out.println(myOrchestra.play());
        System.out.println("instrument counted: " + MusicalInstrumentCounter.getCount());
        System.out.println("observed trumpet played times: " + myCounterObserver.getCount("Trumpet"));
        System.out.println("observed horn played times: " + myCounterObserver.getCount("Horn"));
        System.out.println("observed water glass played times: " + myCounterObserver.getCount("WaterGlass"));
        System.out.println("observed iron rod played times: " + myCounterObserver.getCount("IronRod"));
    }
}
