package it.unimi.di.prog2.lab8.view;

public enum FahrenheitScale implements ScaleStrategy {
    INSTANCE;

    // returns fahrenheit value from given temperature in celsius
    @Override
    public double valueFromCelsius(double temperature) {
        return (temperature*1.8) + 32;
    }

    // returns celsius value from given temperature in fahrenheit
    @Override
    public double valueToCelsius(double temperature) {
        return (temperature-32)/1.8;
    }
}
