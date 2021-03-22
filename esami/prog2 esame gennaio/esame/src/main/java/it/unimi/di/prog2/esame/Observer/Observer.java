package it.unimi.di.prog2.esame.Observer;

public interface Observer<T> {
    void update(T subject); // push subject (che è anche state)
}
