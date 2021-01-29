package es7.musicamaestro;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MusicaMaestroTests {

    @Test
    public void step1Test() {
        MusicalInstrument instrument = new Trumpet();
        assertEquals("water glass doesn't 'pepepe' properly","pepepe", instrument.play());
        instrument = new Horn();
        assertEquals("water glass doesn't 'papapa' properly","papapa", instrument.play());
    }

    @Test
    public void step2Test() {
        WaterGlass glass = new WaterGlass();
        assertEquals("water glass doesn't 'diding' properly","diding", glass.tap());
        GermanPercussiveInstrument rod = new IronRod();
        assertEquals("iron rod doesn't 'tatang' properly","tatang", rod.spiel());
    }

    @Test
    public void step3Test() {
        MusicalInstrument basic = new Horn();
        assertEquals("papapa",basic.play());
        MusicalInstrument glass = new WaterGlassInstrument();
        assertEquals("diding",glass.play());
        MusicalInstrument rod = new GermanMusicalInstrument(new IronRod());
        assertEquals("tatang",rod.play());
    }

    @Test
    public void step4Test() {
        MusicalInstrumentCounter counting_instrument = new MusicalInstrumentCounter(new Trumpet());
        int times = 5;
        for (int i = 0; i < times; i++) {
            counting_instrument.play();
        }
        assertEquals(times,MusicalInstrumentCounter.getCounter());
        MusicalInstrumentCounter.resetCounter();
        assertEquals(0,MusicalInstrumentCounter.getCounter());
    }

    @Test
    public void step5Test() {
        Orchestra orchestra = new Orchestra();

        String song1 = orchestra.play();
        assertEquals("failed to perform song 1","",song1);

        orchestra.add(new Trumpet());
        orchestra.add(new GermanMusicalInstrument(new IronRod()));
        String song2 = orchestra.play();
        assertEquals("failed to perform song 2","pepepe\ntatang\n",song2);

        orchestra.add(new WaterGlassInstrument());
        orchestra.add(new Horn());
        String song3 = orchestra.play();
        assertEquals("failed to perform song 3","pepepe\ntatang\ndiding\npapapa\n",song3);
    }
}
