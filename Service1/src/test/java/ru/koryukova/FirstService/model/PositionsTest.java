package ru.koryukova.FirstService.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionsTest {

  @Test
  void testCalculateQuarterlyBonusForManager() {
    int salary = 5000;

    double bonus = Positions.calculateQuarterlyBonus(Positions.VP, salary);

    // Ожидаем, что квартальная премия для менеджера составит 10% от базовой зарплаты в 5000
    assertEquals(500.0, bonus, 0.001);
  }

  @Test
  void testCalculateQuarterlyBonusForNonManager() {
    int salary = 4000;

    double bonus = Positions.calculateQuarterlyBonus(Positions.HR, salary);

    // Ожидаем, что квартальная премия для не-менеджера равна 0
    assertEquals(0.0, bonus, 0.001);
  }
}
