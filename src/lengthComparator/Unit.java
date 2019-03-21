package lengthComparator;

import java.math.BigDecimal;

class Unit {
  static final Unit GALLON = new Unit(TYPES.VOLUME, new BigDecimal(3785.41));
  static final Unit LITER = new Unit(TYPES.VOLUME, new BigDecimal(1000));
  static Unit FEET = new Unit(TYPES.LENGTH, new BigDecimal(30.48));
  static Unit INCH = new Unit(TYPES.LENGTH, new BigDecimal(2.54));
  static Unit CM = new Unit(TYPES.LENGTH, new BigDecimal(1));
  static Unit MM = new Unit(TYPES.LENGTH, new BigDecimal(0.1));

  private final TYPES type;
  private BigDecimal ratio;

  private Unit(TYPES type, BigDecimal ratio) {
    this.ratio = ratio;
    this.type = type;
  }

  BigDecimal convertToBase(BigDecimal value) {
    return BigDecimal.valueOf(this.ratio.multiply(value).intValue());
  }

  boolean ofSameType(Unit otherUnit) {
    return this.type.equals(otherUnit.type);
  }

  private enum TYPES {LENGTH, VOLUME}
}
