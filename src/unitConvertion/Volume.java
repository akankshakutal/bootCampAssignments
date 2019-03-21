package unitConvertion;

import java.math.BigDecimal;

public class Volume implements Quantity {
  private BigDecimal value;
  private VolumeUnits conversionFactor;

  Volume(BigDecimal value, VolumeUnits unit) {
    this.value = value;
    this.conversionFactor = unit;
  }

  @Override
  public BigDecimal convertToBase() {
    return conversionFactor.calculateBaseValue(this.value);
  }

  @Override
  public boolean equals(Object anotherVolume) {
    if (this == anotherVolume) return true;
    if (anotherVolume == null || getClass() != anotherVolume.getClass()) return false;
    Volume volume = (Volume) anotherVolume;
    BigDecimal baseOfThis = this.convertToBase();
    BigDecimal baseOfAnotherVolume = volume.convertToBase();
    return baseOfThis.equals(baseOfAnotherVolume);
  }

  enum VolumeUnits {
    GALLON(new BigDecimal(0.264172)),
    LITER(new BigDecimal(1));

    private BigDecimal value;

    VolumeUnits(BigDecimal value) {
      this.value = value;
    }

    BigDecimal calculateBaseValue(BigDecimal value1) {
      return BigDecimal.valueOf(this.value.multiply(value1).floatValue());
    }
  }

}
