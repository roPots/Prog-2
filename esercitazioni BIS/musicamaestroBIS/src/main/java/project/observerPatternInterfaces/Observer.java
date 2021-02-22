package project.observerPatternInterfaces;

public interface Observer<T> {
    void update(Subject<T> model, Object state);
}
