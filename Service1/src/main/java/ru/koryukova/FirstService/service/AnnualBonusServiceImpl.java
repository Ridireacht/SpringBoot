package ru.koryukova.FirstService.service;

import ru.koryukova.FirstService.model.Positions;

public class AnnualBonusServiceImpl implements AnnualBonusService {

  @Override
  public double calculate(Positions positions, double salary, double bonus, int workDays) {
    return salary * bonus * 365 * positions.getPositionCoefficient() / workDays;
  }
}
