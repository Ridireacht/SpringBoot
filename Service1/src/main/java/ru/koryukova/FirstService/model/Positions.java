package ru.koryukova.FirstService.model;

import lombok.Getter;

@Getter
public enum Positions {

  DEV(2.2, false),
  HR(1.2, false),
  TL(2.6, false),
  CEO(4.0, true),
  VP(3.0, true),
  CFO(2.5, true);

  private final double positionCoefficient;
  private final boolean isManager;

  Positions(double positionCoefficient, boolean isManager) {
    this.positionCoefficient = positionCoefficient;
    this.isManager = isManager;
  }

  public static double calculateQuarterlyBonus(Positions position, int salary) {
    if (position.isManager()) {
      return 0.1 * salary;
    } else {
      return 0.0;
    }
  }
}
