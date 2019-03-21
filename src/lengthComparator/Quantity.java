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

  boolean compare(Quantity quantity){
    return unit.convert(this.value).equals(quantity.unit.convert(quantity.value));
  }

  @Override
  public boolean equals(Object anotherQuantity) {
    if (this == anotherQuantity) return true;
    if (anotherQuantity == null || getClass() != anotherQuantity.getClass()) return false;
    Quantity quantity = (Quantity) anotherQuantity;
    return Objects.equals(value, quantity.value) &&
            Objects.equals(unit, quantity.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit);
  }
}
