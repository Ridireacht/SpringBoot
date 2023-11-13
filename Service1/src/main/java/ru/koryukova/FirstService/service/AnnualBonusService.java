package ru.koryukova.FirstService.service;

import ru.koryukova.FirstService.model.Positions;

public interface AnnualBonusService {

  double calculate(Positions positions, double salary, double bonus, int workDays);
}
