package it.unimi.di.prog2.lab8.view;

public enum KelvinScale implements ScaleStrategy {
    INSTANCE;

    @Override
    public double valueFromCelsius(double temperature) {
        return temperature+273.15;
    }

    @Override
    public double valueToCelsius(double temperature) {
        return temperature-273;
    }
}
