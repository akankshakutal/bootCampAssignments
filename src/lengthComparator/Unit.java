package lengthComparator;

import java.math.BigDecimal;

abstract class Unit {
  Unit STANDARD;

  Unit(Unit STANDARD) {
    this.STANDARD = STANDARD;
  }

  abstract BigDecimal convertToBase(BigDecimal value);
}
