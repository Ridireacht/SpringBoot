package ru.koryukova.FirstService.service;

import java.time.Year;
import java.util.GregorianCalendar;
import ru.koryukova.FirstService.model.Positions;

public class AnnualBonusServiceImpl implements AnnualBonusService {

  @Override
  public double calculate(Positions positions, double salary, double bonus, int workDays) {

    int daysInYear;
    Year thisYear = Year.now();
    GregorianCalendar calendar = new GregorianCalendar();

    if (calendar.isLeapYear(Integer.parseInt(thisYear.toString()))) {
      daysInYear = 366;
    } else {
      daysInYear = 365;
    }

    return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
  }
}
