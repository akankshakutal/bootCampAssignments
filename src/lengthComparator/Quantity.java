package lengthComparator;

import java.math.BigDecimal;
import java.util.Objects;

class Quantity {
  private final BigDecimal value;
  private final Unit unit;

  Quantity(BigDecimal value, Unit unit) {
    this.value = value;
    this.unit = unit;
  }

  boolean compare(Quantity other) {
    if(!this.unit.ofSameType(other.unit)) {
      return false;
    }

    return unit.convertToBase(this.value).equals(other.unit.convertToBase(other.value));
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    Quantity quantity = (Quantity) other;
    return Objects.equals(value, quantity.value) &&
            Objects.equals(unit, quantity.unit);
  }

  Quantity add(Quantity other) throws TypeNotMatchException{
    if(!this.unit.ofSameType(other.unit)) {
      throw new TypeNotMatchException();
    }

    return new Quantity(this.value.add(other.value), this.unit);
  }
}
