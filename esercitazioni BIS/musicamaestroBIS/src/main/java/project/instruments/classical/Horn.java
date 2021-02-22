package project.instruments.classical;

public class Horn implements MusicalInstrument {
    @Override
    public String play() {
        return "papapa";
    }

    @Override
    public String name() {
        return "Horn";
    }
}
