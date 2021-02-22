package it.unimi.di.prog2.lab8.view;

public enum FahrenheitScale implements ScaleStrategy {
    INSTANCE;

    @Override
    public double valueFromCelsius(double temperature) {
        return (temperature * 9/5) + 32;
    }

    @Override
    public double valueToCelsius(double temperature) {
        return (temperature - 32) * 5/9;
    }
}
