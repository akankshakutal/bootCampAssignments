package unitConvertion;

import java.math.BigDecimal;

class Length implements Quantity {
  private BigDecimal value;
  private LengthUnits conversionFactor;

  Length(BigDecimal value, LengthUnits unit) {
    this.value = value;
    this.conversionFactor = unit;
  }

  @Override
  public BigDecimal convertToBase() {
    return conversionFactor.calculateBaseValue(this.value);
  }

  @Override
  public boolean equals(Object anotherLength) {
    if (this == anotherLength) return true;
    if (anotherLength == null || getClass() != anotherLength.getClass()) return false;
    Length length = (Length) anotherLength;
    BigDecimal baseOfThis = this.convertToBase();
    BigDecimal baseOfAnotherVolume = length.convertToBase();
    return baseOfThis.equals(baseOfAnotherVolume);
  }

  enum LengthUnits {
    FEET(new BigDecimal(12)),
    INCH(new BigDecimal(1)),
    CM(new BigDecimal(0.4)),
    MM(new BigDecimal(0.04));

    private BigDecimal value;

    LengthUnits(BigDecimal value) {
      this.value = value;
    }

    BigDecimal calculateBaseValue(BigDecimal value1) {
      return BigDecimal.valueOf(this.value.multiply(value1).intValue());
    }
  }

}
