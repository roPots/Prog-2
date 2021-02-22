package it.unimi.di.prog2.lab8.view;

import it.unimi.di.prog2.lab8.controller.MyController;

public interface TemperatureView {
  void addListener(MyController controller);

  double getTempValue();
}
