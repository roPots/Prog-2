package it.unimi.di.prog2.lab8.view;

public enum CelsiusScale implements ScaleStrategy{
    INSTANCE;

    @Override
    public double valueFromCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double valueToCelsius(double temperature) {
        return temperature;
    }
}
